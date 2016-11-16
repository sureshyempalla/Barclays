package com.example.barclaysinterviewproject.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.barclaysinterviewproject.R;
import com.example.barclaysinterviewproject.common.BConstants;
import com.example.barclaysinterviewproject.parser.ResultItem;

/**
 * A fragment representing a list of Items.
 */

public class DisplayResultsFragment extends Fragment {

    private ResultItem mResultItem;
    private OnListFragmentInteractionListener mListener;

    /** Empty constructor */
    public DisplayResultsFragment() {
    }

    public static DisplayResultsFragment newInstance(ResultItem resultItem) {
        DisplayResultsFragment fragment = new DisplayResultsFragment();
        Bundle args = new Bundle();
        args.putSerializable(BConstants.DATA_INTENT_EXTRA, resultItem);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mResultItem = (ResultItem) getArguments().getSerializable(BConstants.DATA_INTENT_EXTRA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setRetainInstance(true);

        View view = inflater.inflate(R.layout.fragment_display_results_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new ResultItemAdapter(mResultItem, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(int position);
    }
}
