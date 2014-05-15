package org.fmedlin.wikilooks.android.presenter;

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

    public static class ArticlesFoundEvent {

    }
}
