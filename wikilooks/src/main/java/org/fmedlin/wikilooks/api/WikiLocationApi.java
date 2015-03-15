package org.fmedlin.wikilooks.api;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;

public class WikiLocationApi {

    static final String ENDPOINT = "http://en.wikipedia.org/w";

    static WikiLocationService service;

    public static WikiLocationService getWikiLocationService() {
        if (service == null) {
            service = new RestAdapter.Builder()
                    .setEndpoint(ENDPOINT)
                    .setLogLevel(LogLevel.FULL)
                    .build()
                    .create(WikiLocationService.class);
        }
        return service;
    }
}
