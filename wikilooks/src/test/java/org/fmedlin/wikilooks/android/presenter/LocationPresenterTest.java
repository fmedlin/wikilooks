package org.fmedlin.wikilooks.android.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class LocationPresenterTest {

    LocationPresenter presenter;

    @Mock LocationModel model;
    @Mock LocationView view;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new LocationPresenter(model, view);
    }

    @Test
    public void itShouldFail() {
        fail("Implement me");
    }

}
