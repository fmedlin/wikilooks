package org.fmedlin.wikilooks.android.presenter;

import android.content.Context;

import com.squareup.otto.Subscribe;

import org.fmedlin.wikilooks.android.presenter.LocationModel.LocationUpdateEvent;

import timber.log.Timber;

public class LocationPresenter {
    LocationModel model;
    LocationView view;

    public LocationPresenter(LocationModel model, LocationView view, Context context) {
        this.model = model;
        this.view = view;
        model.setupApiClient(context);
    }

    @Subscribe
    public void onLocationUpdate(LocationUpdateEvent event) {
        Timber.d("Location update: %f, %f", event.latitude, event.longitude);
        model.searchLocation(event.latitude, event.longitude);
    }

}
