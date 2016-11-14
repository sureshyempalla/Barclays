package com.example.sureshreddy.barclays.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sureshreddy.barclays.R;
import com.example.sureshreddy.barclays.common.BConstants;
import com.example.sureshreddy.barclays.parser.ResultItem;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends Activity {

    private ImageView imageView;
    private TextView description, trackName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        trackName = (TextView) findViewById(R.id.trackName);
        description = (TextView) findViewById(R.id.description);
        imageView = (ImageView) findViewById(R.id.image);

        Intent i = getIntent();
        ResultItem resultItem = (ResultItem) i.getSerializableExtra(BConstants.DATA_INTENT_EXTRA);
        int position = i.getIntExtra(BConstants.POSITION_INTENT_EXTRA, 0);

        Picasso.with(DetailsActivity.this).load(resultItem.getResults().get(position).getArtworkUrl100()).into(imageView);
        trackName.setText(resultItem.getResults().get(position).getTrackName());
        description.setText(resultItem.getResults().get(position).getArtistName());
    }
}
