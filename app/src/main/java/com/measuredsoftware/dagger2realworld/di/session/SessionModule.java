package com.measuredsoftware.dagger2realworld.di.session;

import android.content.SharedPreferences;

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
    @Singleton
    UserSession userSession(SharedPreferences sharedPreferences) {
        return new UserSession(sharedPreferences);
    }

    @Provides
    User user(UserSession userSession) {
        return userSession.getUser();
    }
}
