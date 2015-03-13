package org.fmedlin.wikilooks.android.presenter;

import com.squareup.otto.Bus;

import org.fmedlin.wikilooks.android.presenter.LocationModel.ArticlesFoundEvent;
import org.fmedlin.wikilooks.api.ArticlesResponse;
import org.fmedlin.wikilooks.api.ArticlesResponse.Article;
import org.fmedlin.wikilooks.api.WikiLocationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;

import java.util.Map;

import retrofit.Callback;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
public class LocationModelTest {

    LocationModel model;
    @Mock WikiLocationService api;
    @Mock Bus bus;
    @Captor ArgumentCaptor<Callback<ArticlesResponse>> callback;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        model = new LocationModel(api, bus);
    }

    @Test
    public void itShouldSearchLocation() {
        model.searchLocation(35.87, -78.78);
        verify(api).getArticles(any(Map.class), callback.capture());
        callback.getValue().success(getTestResponse(), null);
        verify(bus).post(any(ArticlesFoundEvent.class));
    }

    // helpers

    private ArticlesResponse getTestResponse() {
        ArticlesResponse response = new ArticlesResponse();
        Article article = new Article();
        article.id = "42";
        article.title = "TriDroid West";
        response.addArticle(article);
        return response;
    }
}
