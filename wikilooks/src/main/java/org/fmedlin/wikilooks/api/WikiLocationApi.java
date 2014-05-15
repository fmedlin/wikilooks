package org.fmedlin.wikilooks.api;

import retrofit.RestAdapter;

public class WikiLocationApi {

    static final String ENDPOINT = "http://api.wikilocation.org";

    static WikiLocationService service;

    static WikiLocationService getWikiLocationService() {
        if (service == null) {
            service = new RestAdapter.Builder()
                    .build()
                    .create(WikiLocationService.class);
        }
        return service;
    }
}
