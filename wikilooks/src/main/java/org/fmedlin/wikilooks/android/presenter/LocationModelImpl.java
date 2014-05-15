package org.fmedlin.wikilooks.android.presenter;

import com.squareup.otto.Bus;
import org.fmedlin.wikilooks.api.ArticlesResponse;
import org.fmedlin.wikilooks.api.ArticlesResponse.Article;
import org.fmedlin.wikilooks.api.WikiLocationService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationModelImpl implements LocationModel {

    WikiLocationService api;
    Bus bus;
    List<Article> articles;

    public LocationModelImpl(WikiLocationService api, Bus bus) {
        this.api = api;
        this.bus = bus;
    }

    @Override
    public void searchLocation(double longitude, double latitude) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("lng", String.valueOf(longitude));
        queryParams.put("lat", String.valueOf(latitude));

        api.getArticles(queryParams, new Callback<ArticlesResponse>() {
            @Override
            public void success(ArticlesResponse articlesResponse, Response response) {
                articles = articlesResponse.getArticles();
                bus.post(new ArticlesFoundEvent());
            }

            @Override
            public void failure(RetrofitError retrofitError) {
            }
        });
    }
}
