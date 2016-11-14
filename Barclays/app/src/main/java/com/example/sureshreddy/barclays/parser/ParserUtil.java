package com.example.sureshreddy.barclays.parser;

import com.google.gson.Gson;



public class ParserUtil {

    public static ResultItem getParsedData(String rawJson){
        Gson gson = new Gson();
        return gson.fromJson(rawJson, ResultItem.class);
    }
}
