package com.example.sureshreddy.barclays.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sureshreddy.barclays.R;
import com.example.sureshreddy.barclays.parser.Result;
import com.example.sureshreddy.barclays.parser.ResultItem;
import com.squareup.picasso.Picasso;

public class DataAdapter extends BaseAdapter {

    private final Context context;
    private ResultItem resultItem;
    private LayoutInflater inflater;

    public DataAdapter(Context context, ResultItem resultItem) {

        inflater = ((Activity) context).getLayoutInflater();
        this.resultItem = resultItem;
        this.context = context;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView trackName;
        TextView kind;
        TextView trackPrice;
    }

    @Override
    public int getCount() {
        return resultItem.getResultCount();
    }

    @Override
    public Object getItem(int position) {
        return resultItem.getResults().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.datarowview, null);

            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.trackName = (TextView) convertView.findViewById(R.id.trackname);
            viewHolder.kind = (TextView) convertView.findViewById(R.id.kind);
            viewHolder.trackPrice = (TextView) convertView.findViewById(R.id.price);

            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();

        Result result = resultItem.getResults().get(position);

        Picasso.with(context).load(result.getArtworkUrl100()).into(viewHolder.imageView);
        viewHolder.trackName.setText(result.getTrackName());
        viewHolder.trackPrice.setText("$"+String.valueOf(result.getTrackPrice()));
        viewHolder.kind.setText(result.getKind());

        return convertView;
    }
}
