package org.fmedlin.wikilooks.android.presenter;

import com.squareup.otto.Subscribe;

public class LocationPresenter {
    LocationModel model;
    LocationView view;

    public LocationPresenter(LocationModel model, LocationView view) {
        this.model = model;
        this.view = view;
    }

    @Subscribe
    public void onLocationUpdate(LocationModel.LocationUpdateEvent event) {
        model.searchLocation(event.longitude, event.latitude);
    }

}
