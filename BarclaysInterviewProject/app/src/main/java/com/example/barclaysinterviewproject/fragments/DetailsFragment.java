package com.example.barclaysinterviewproject.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.barclaysinterviewproject.R;
import com.example.barclaysinterviewproject.common.BConstants;
import com.example.barclaysinterviewproject.parser.Result;
import com.squareup.picasso.Picasso;


public class DetailsFragment extends Fragment {

    private Result mResult;
    private ImageView imageView;
    private TextView description, trackName;

    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance(Result result) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(BConstants.DATA_INTENT_EXTRA, result);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mResult = (Result) getArguments().getSerializable(BConstants.DATA_INTENT_EXTRA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setRetainInstance(true);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        trackName = (TextView) view.findViewById(R.id.trackName);
        description = (TextView) view.findViewById(R.id.description);
        imageView = (ImageView) view.findViewById(R.id.image);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        Picasso.with(getContext()).load(mResult.getArtworkUrl100()).into(imageView);
        trackName.setText(mResult.getTrackName());
        description.setText(mResult.getArtistName());
    }
}
