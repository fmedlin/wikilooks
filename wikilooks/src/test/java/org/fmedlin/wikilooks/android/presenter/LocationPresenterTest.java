package org.fmedlin.wikilooks.android.presenter;

import android.content.Context;

import org.fmedlin.wikilooks.android.presenter.LocationModel.LocationUpdateEvent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;

import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class LocationPresenterTest {

    LocationPresenter presenter;
    @Mock LocationModel model;
    @Mock LocationView view;
    @Mock Context context;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new LocationPresenter(model, view, context);
    }

    @Test
    public void locationUpdate() {
        double longitude = 123.45;
        double latitude = 678.90;

        presenter.onLocationUpdate(new LocationUpdateEvent(longitude, latitude));
        verify(model).searchLocation(latitude, longitude);
    }

}
