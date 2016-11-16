package com.example.barclaysinterviewproject.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.barclaysinterviewproject.R;
import com.example.barclaysinterviewproject.common.BConstants;
import com.example.barclaysinterviewproject.common.EntityHelper;
import com.example.barclaysinterviewproject.common.NetworkUtil;
import com.example.barclaysinterviewproject.common.StringUtil;
import com.example.barclaysinterviewproject.network.INetworkInterface;
import com.example.barclaysinterviewproject.network.NetworkClient;
import com.example.barclaysinterviewproject.parser.ResultItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Performs search
 */
public class SearchFragment extends Fragment implements View.OnClickListener{

    private OnSearchFragmentInteractionListener mListener;
    private EditText mSearchTerm;
    private RadioGroup mRadioGroup;
    private View mParentView;
    private ProgressDialog pd;

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        mParentView =  inflater.inflate(R.layout.fragment_search, container, false);

        mParentView.findViewById(R.id.getDataBtn).setOnClickListener(SearchFragment.this);
        mSearchTerm = (EditText) mParentView.findViewById(R.id.term);
        mRadioGroup = (RadioGroup) mParentView.findViewById(R.id.entityGroup);

        if(savedInstanceState != null){
            mSearchTerm.setText(savedInstanceState.getString(BConstants.SEARCH_TERM));
        }

        return mParentView;
    }

    @Override
    public void onClick(View view) {

        String searchText = StringUtil.getValidString(mSearchTerm.getText().toString());

        int selectedId = mRadioGroup.getCheckedRadioButtonId();
        RadioButton rd = (RadioButton) mParentView.findViewById(selectedId);
        if(searchText== null || searchText.length() < 1 || rd == null) {
            Snackbar.make(getView(), getString(R.string.error_empty), Snackbar.LENGTH_LONG)
                    .setActionTextColor(Color.RED)
                    .show();
            return;
        }

        String entity = EntityHelper.getInstance().getEntity(rd.getText().toString());


        if (NetworkUtil.hasNetworkConnection(getContext()))
            getSearchResults(searchText, entity);
        else {
            //show error message
            Snackbar.make(getView(), getString(R.string.error_message), Snackbar.LENGTH_LONG)
                    .setActionTextColor(Color.RED)
                    .show();
        }
    }

    public void onDataReceived(ResultItem resultItem) {
        if (mListener != null) {
            mListener.onDataArrived(resultItem);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSearchFragmentInteractionListener) {
            mListener = (OnSearchFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(BConstants.SEARCH_TERM, StringUtil.getValidString(mSearchTerm.getText().toString()));
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void getSearchResults(String term, String entity){

        pd = ProgressDialog.show(getContext(), getString(R.string.dialog_title), getString(R.string.dialog_msg));

        INetworkInterface networkInterface = NetworkClient.getClient().create(INetworkInterface.class);

        Call<ResultItem> call = networkInterface.getSearchResults(term, entity);
        call.enqueue(new Callback<ResultItem>() {
            @Override
            public void onResponse(Call<ResultItem> call, Response<ResultItem> response) {
               onDataReceived(response.body());
                if (pd != null && pd.isShowing())
                    pd.dismiss();
            }

            @Override
            public void onFailure(Call<ResultItem> call, Throwable t) {

                Snackbar.make(mParentView.findViewById(android.R.id.content), getString(R.string.network_error_message), Snackbar.LENGTH_LONG)
                        .setActionTextColor(Color.RED)
                        .show();
                if (pd != null && pd.isShowing())
                    pd.dismiss();
            }
        });
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnSearchFragmentInteractionListener {
        void onDataArrived(ResultItem resultItem);
    }
}
