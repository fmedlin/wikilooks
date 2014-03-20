package org.fmedlin.wikilooks.android.presenter;

/**
 * Created by fred on 3/19/14.
 */
public class LocationPresenter {
    LocationModel model;
    LocationView view;

    public LocationPresenter(LocationModel model, LocationView view) {
        this.model = model;
        this.view = view;
    }
}
