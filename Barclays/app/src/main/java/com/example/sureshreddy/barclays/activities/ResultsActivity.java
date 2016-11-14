package com.example.sureshreddy.barclays.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sureshreddy.barclays.R;
import com.example.sureshreddy.barclays.adapter.DataAdapter;
import com.example.sureshreddy.barclays.common.BConstants;
import com.example.sureshreddy.barclays.parser.ResultItem;

public class ResultsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent i = getIntent();

        final ResultItem resultItem = (ResultItem) i.getSerializableExtra(BConstants.DATA_INTENT_EXTRA);

        if(resultItem.getResultCount() > 0) {

            findViewById(R.id.error_view).setVisibility(View.GONE);

            ListView listView = (ListView) this.findViewById(R.id.tracklist);
            DataAdapter dataAdapter = new DataAdapter(this, resultItem);
            listView.setAdapter(dataAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                   Intent intent = new Intent(ResultsActivity.this, DetailsActivity.class);
                    intent.putExtra(BConstants.DATA_INTENT_EXTRA, resultItem);
                    intent.putExtra(BConstants.POSITION_INTENT_EXTRA, i);
                    startActivity(intent);
                }
            });
        }
        else{
            findViewById(R.id.error_view).setVisibility(View.VISIBLE);
        }
    }
}
