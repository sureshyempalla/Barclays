package com.example.barclaysinterviewproject.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.barclaysinterviewproject.R;
import com.example.barclaysinterviewproject.parser.ResultItem;
import com.squareup.picasso.Picasso;


public class ResultItemAdapter extends RecyclerView.Adapter<ResultItemAdapter.ViewHolder> {

    private final ResultItem resultItem;
    private final DisplayResultsFragment.OnListFragmentInteractionListener mListener;

    public ResultItemAdapter(ResultItem resultItem, DisplayResultsFragment.OnListFragmentInteractionListener listener) {
        this.resultItem = resultItem;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Picasso.with(holder.imageView.getContext()).load(resultItem.getResults().get(position).getArtworkUrl100()).into(holder.imageView);
        holder.trackName.setText(resultItem.getResults().get(position).getTrackName());
        holder.trackPrice.setText(String.valueOf(resultItem.getResults().get(position).getTrackPrice()));
        holder.kind.setText(resultItem.getResults().get(position).getKind());

        //Hide the horizontal divider for last item
        if(position == getItemCount() - 1)
            holder.dividerLine.setVisibility(View.INVISIBLE);


        //Click listener on each row item
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultItem.getResultCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView trackName;
        TextView kind;
        TextView trackPrice;
        View dividerLine;
        public final View mView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            imageView = (ImageView) view.findViewById(R.id.image);
            trackName = (TextView) view.findViewById(R.id.trackname);
            kind = (TextView) view.findViewById(R.id.kind);
            trackPrice = (TextView) view.findViewById(R.id.price);
            dividerLine = view.findViewById(R.id.divider_line);
        }
    }
}
