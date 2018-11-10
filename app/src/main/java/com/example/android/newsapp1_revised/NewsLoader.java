package com.example.android.newsapp1_revised;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private static final String LOG_TAG = NewsLoader.class.getName();
    private String GUARDIAN_REQUEST_URL = "https://content.guardianapis.com/search?show-fields=byline&q=music&order-by=newest&from-date=2018-01-01&api-key=12db7c5e-96be-4c1e-939d-4f471104e3f0";

    public NewsLoader(Context context, String url) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<News> loadInBackground() {
        if (GUARDIAN_REQUEST_URL == null) {
            return null;
        }

        List<News> news = QueryUtils.fetchNewsData(GUARDIAN_REQUEST_URL);
        return news;
    }
}

