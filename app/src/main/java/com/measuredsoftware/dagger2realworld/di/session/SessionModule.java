package com.measuredsoftware.dagger2realworld.di.session;

import android.content.SharedPreferences;
import android.util.Log;

import com.measuredsoftware.dagger2realworld.model.User;
import com.measuredsoftware.dagger2realworld.model.UserSession;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by neil on 19/06/16.
 */
@Module
public class SessionModule {
    @Provides
    @Session
    UserSession userSession(SharedPreferences sharedPreferences) {
        Log.i("instances", "creating userSession");
        return new UserSession(sharedPreferences);
    }

    @Provides
    User user(UserSession userSession) {
        return userSession.getUser();
    }
}
