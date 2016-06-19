package com.measuredsoftware.dagger2realworld.di;

import android.content.SharedPreferences;

import com.measuredsoftware.dagger2realworld.LaunchActivity;
import com.measuredsoftware.dagger2realworld.MainActivity;
import com.measuredsoftware.dagger2realworld.RealWorldApplication;
import com.measuredsoftware.dagger2realworld.di.session.SessionModule;
import com.measuredsoftware.dagger2realworld.model.UserSession;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by neil on 19/06/16.
 */
@Singleton
@Component(modules = {ApplicationModule.class, SessionModule.class})
public interface ApplicationComponent {
    UserSession userSession();

    SharedPreferences sharedPreferences();

    void inject(RealWorldApplication application);

    void inject(LaunchActivity launchActivity);

    void inject(MainActivity mainActivity);
}
