package org.fmedlin.wikilooks.android.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.squareup.otto.Bus;
import org.fmedlin.wikilooks.R;
import org.fmedlin.wikilooks.android.presenter.LocationModelImpl;
import org.fmedlin.wikilooks.android.presenter.LocationPresenter;
import org.fmedlin.wikilooks.android.presenter.LocationView;
import org.fmedlin.wikilooks.api.WikiLocationApi;

public class MainActivity extends Activity {

    Bus bus;
    LocationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createPresenter();
    }

    private void createPresenter() {
        bus = new Bus();
        presenter = new LocationPresenter(
                new LocationModelImpl(WikiLocationApi.getWikiLocationService(), bus),
                new LocationView() { }); // No UI yet!
    }

}
