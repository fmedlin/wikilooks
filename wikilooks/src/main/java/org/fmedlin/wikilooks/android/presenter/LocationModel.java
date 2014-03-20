package org.fmedlin.wikilooks.android.presenter;

/**
 * Created by fred on 3/19/14.
 */
public interface LocationModel {

    void searchLocation(double longitude, double latitude);

    // Events posted

    public static class LocationUpdateEvent {
        double longitude;
        double latitude;

        public LocationUpdateEvent(double longitude, double latitude) {
            this.longitude = longitude;
            this.latitude = latitude;
        }
    }
}
