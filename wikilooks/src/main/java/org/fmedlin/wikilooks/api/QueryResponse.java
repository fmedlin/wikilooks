package org.fmedlin.wikilooks.api;

import java.util.List;

public class QueryResponse {

    Warning warnings;
    Query query;


    public static class Warning {
        Object query;

    }

    public static class Query {
        List<GeoSearch> geoSearch;
    }

    public static class GeoSearch {
        long pageid;
        int ns;
        String title;
        double lat;
        double lan;
        double dist;
        String primary;
    }
}
