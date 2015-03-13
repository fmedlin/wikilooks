package org.fmedlin.wikilooks.app;

import android.app.Application;

import org.fmedlin.wikilooks.BuildConfig;

import timber.log.Timber;
import timber.log.Timber.DebugTree;

public class WikiLooks extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new DebugTree());
        }
    }
}
