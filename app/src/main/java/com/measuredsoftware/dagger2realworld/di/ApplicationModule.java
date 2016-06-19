package com.measuredsoftware.dagger2realworld.di;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by neil on 19/06/16.
 */
@Module
public class ApplicationModule {
    private final Context context;

    public ApplicationModule(final Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    SharedPreferences sharedPreferences() {
        return context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
    }
}
