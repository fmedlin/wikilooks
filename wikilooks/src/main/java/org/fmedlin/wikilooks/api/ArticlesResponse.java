package org.fmedlin.wikilooks.api;

import java.util.ArrayList;
import java.util.List;

public class ArticlesResponse {

    List<Article> articles;

    public static class Article {
        public String id;
        public String lat;
        public String lng;
        public String title;
        public String url;
        public String distance;
    }

    public List<Article> getArticles() {
        if (articles == null) {
            articles = new ArrayList<>();
        }
        return articles;
    }

    public void addArticle(Article article) {
        getArticles().add(article);
    }
}
