package org.fmedlin.wikilooks.android.presenter;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;
import com.squareup.otto.Bus;

import org.fmedlin.wikilooks.api.ArticlesResponse;
import org.fmedlin.wikilooks.api.ArticlesResponse.Article;
import org.fmedlin.wikilooks.api.WikiLocationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import timber.log.Timber;

public class LocationModel implements ConnectionCallbacks, OnConnectionFailedListener {

    WikiLocationService api;
    Bus bus;
    GoogleApiClient playClient;
    List<Article> articles;

    public LocationModel(Context context, WikiLocationService api, Bus bus) {
        this.api = api;
        this.bus = bus;
        setupApiClient(context);
    }

    private void setupApiClient(Context context) {
        playClient = new GoogleApiClient.Builder(context)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        playClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        Timber.d("connected");
        Location last = LocationServices.FusedLocationApi.getLastLocation(playClient);
        if (last != null) {
            bus.post(new LocationUpdateEvent(last.getLatitude(), last.getLongitude()));
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Timber.d("connection suspended");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Timber.d("connection failed");
    }

    public void searchLocation(double latitude, double longitude) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("lat", String.valueOf(latitude));
        queryParams.put("lng", String.valueOf(longitude));

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

    // Events posted

    public static class LocationUpdateEvent {
        double longitude;
        double latitude;

        public LocationUpdateEvent(double longitude, double latitude) {
            this.longitude = longitude;
            this.latitude = latitude;
        }
    }

    public static class ArticlesFoundEvent {

    }

}
