package com.example.barclaysinterviewproject.network;

/**
 * Created by DrakeBoltz on 11/16/2016.
 */

import com.example.barclaysinterviewproject.parser.ResultItem;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface INetworkInterface {
    @GET("/search")
    Call<ResultItem> getSearchResults(@Query("term") String term, @Query("entity") String entity);
}
