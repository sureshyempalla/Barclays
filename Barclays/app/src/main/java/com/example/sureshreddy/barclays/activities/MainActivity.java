package com.example.sureshreddy.barclays.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.sureshreddy.barclays.R;
import com.example.sureshreddy.barclays.WebserviceUtil;
import com.example.sureshreddy.barclays.common.BConstants;
import com.example.sureshreddy.barclays.common.EntityHelper;
import com.example.sureshreddy.barclays.common.NetworkUtil;
import com.example.sureshreddy.barclays.common.StringUtil;
import com.example.sureshreddy.barclays.parser.ResultItem;

public class MainActivity extends Activity implements View.OnClickListener {

   // private AutoCompleteTextView mSearchEntity;
    private EditText mSearchTerm;
    private RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        View getDataBtn = findViewById(R.id.getDataBtn);
        getDataBtn.setOnClickListener(this);


       // mSearchEntity = (AutoCompleteTextView) findViewById(R.id.entity);
        mSearchTerm = (EditText) findViewById(R.id.term);
        mRadioGroup = (RadioGroup) findViewById(R.id.entityGroup);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, BConstants.ENTITY);

      //  mSearchEntity.setAdapter(adapter);
       // mSearchEntity.setThreshold(1);

    }

    @Override
    public void onClick(View view) {

        String searchText = StringUtil.getValidString(mSearchTerm.getText().toString());

        int selectedId = mRadioGroup.getCheckedRadioButtonId();
        RadioButton rd = (RadioButton)findViewById(selectedId);


        //String entity = StringUtil.getValidString(mSearchEntity.getText().toString());
        String entity = EntityHelper.getInstance().getEntity(rd.getText().toString());


        if (NetworkUtil.hasNetworkConnection(MainActivity.this))
            new DownloadDataTask().execute(searchText, entity);
        else {
            //show error dialog
        }
    }

    private class DownloadDataTask extends AsyncTask<String, Integer, ResultItem> {

        private ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = ProgressDialog.show(MainActivity.this, getString(R.string.dialog_title), getString(R.string.dialog_msg));
        }

        protected ResultItem doInBackground(String... params) {

            String term = params[0];
            String entity = params[1];
            ResultItem data = WebserviceUtil.getDatafromServer(term, entity);
            return data;

        }

        @Override
        protected void onPostExecute(ResultItem s) {

            if (pd != null && pd.isShowing())
                pd.dismiss();

            if(s != null) {
                Intent i = new Intent(getApplicationContext(), ResultsActivity.class);
                i.putExtra(BConstants.DATA_INTENT_EXTRA, s);
                startActivity(i);
            }
            else{
                Toast.makeText(MainActivity.this, getString(R.string.invalid), Toast.LENGTH_LONG).show();
                int selectedId = mRadioGroup.getCheckedRadioButtonId();
                ((RadioButton)findViewById(selectedId)).setSelected(false);
            }
        }
    }
}