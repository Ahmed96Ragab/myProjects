package com.newsapp1.ragab.newsapp1;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {


    private String mURL ;

    NewsLoader(Context context, String url) {
        super(context);
        this.mURL = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (mURL == null) {
            return null;
        }

        return QueryUtils.fetchNewsData(mURL);
    }
}
