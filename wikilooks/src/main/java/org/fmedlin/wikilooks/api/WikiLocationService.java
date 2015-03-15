package org.fmedlin.wikilooks.api;

import java.util.Map;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.QueryMap;


public interface WikiLocationService {

    // deprecated wikilocation api call
    @GET("/articles")
    public void getArticles(@QueryMap Map<String, String> params,
                            Callback<ArticlesResponse> cb);

    // wikimedia api
    @GET("/api.php")
    public void api(QueryMap parameters);
}
