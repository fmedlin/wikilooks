package org.fmedlin.wikilooks.android.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.fail;

@RunWith(RobolectricTestRunner.class)
public class LocationModelTest {

    LocationModelImpl model;

    @Before
    public void setup() {
        model = new LocationModelImpl();
    }

    @Test
    public void itShouldFail() {
        fail("Implement me");
    }
}
