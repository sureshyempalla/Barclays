package com.example.sureshreddy.barclays;

import com.example.sureshreddy.barclays.common.BConstants;
import com.example.sureshreddy.barclays.parser.ParserUtil;
import com.example.sureshreddy.barclays.parser.ResultItem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;



public class WebserviceUtil {

    public static ResultItem getDatafromServer(String term, String entity) {
        try {

            URL url = new URL(BConstants.URL_HEAD + term + BConstants.URL_TAIL + entity);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");


            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            StringBuffer sb=new StringBuffer("");

            while ((output = br.readLine()) != null) {
                sb.append(output);
            }

            //Log.i("TAG","output = "+sb.toString());

            conn.disconnect();
            return ParserUtil.getParsedData(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}

