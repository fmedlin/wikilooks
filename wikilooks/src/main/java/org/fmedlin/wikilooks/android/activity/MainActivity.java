package org.fmedlin.wikilooks.android.activity;

import android.app.Activity;
import android.os.Bundle;

import com.twotoasters.servos.util.otto.BusProvider;

import org.fmedlin.wikilooks.R;
import org.fmedlin.wikilooks.android.presenter.LocationModel;
import org.fmedlin.wikilooks.android.presenter.LocationPresenter;
import org.fmedlin.wikilooks.android.presenter.LocationView;
import org.fmedlin.wikilooks.api.WikiLocationApi;

import timber.log.Timber;

public class MainActivity extends Activity {

    LocationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timber.d("onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createPresenter();
    }

    private void createPresenter() {
        presenter = new LocationPresenter(
                new LocationModel(WikiLocationApi.getWikiLocationService(), BusProvider.getInstance()),
                new LocationView() { },
                this
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.unregister(presenter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.register(presenter);
    }
}
