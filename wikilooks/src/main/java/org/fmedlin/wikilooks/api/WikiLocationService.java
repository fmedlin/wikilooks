package org.fmedlin.wikilooks.api;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.QueryMap;

import java.util.Map;


public interface WikiLocationService {

    @GET("/articles")
    public void getArticles(@QueryMap Map<String, String> params,
                            Callback<ArticlesResponse> cb);
}
