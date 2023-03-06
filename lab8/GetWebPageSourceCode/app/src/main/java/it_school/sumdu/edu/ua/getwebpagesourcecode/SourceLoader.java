package it_school.sumdu.edu.ua.getwebpagesourcecode;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class SourceLoader extends AsyncTaskLoader<String> {
    private String query;

    public SourceLoader(@NonNull Context context, String query) {
        super(context);
        this.query = query;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetworkUtils.getSource(query);
    }
}
