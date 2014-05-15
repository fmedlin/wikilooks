package org.fmedlin.wikilooks.api;

import retrofit.RestAdapter;

public class WikiLocationApi {

    static final String ENDPOINT = "http://api.wikilocation.org";

    static WikiLocationService service;

    public static WikiLocationService getWikiLocationService() {
        if (service == null) {
            service = new RestAdapter.Builder()
                    .setEndpoint(ENDPOINT)
                    .build()
                    .create(WikiLocationService.class);
        }
        return service;
    }
}
