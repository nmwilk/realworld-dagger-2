package com.measuredsoftware.dagger2realworld.di;

import com.measuredsoftware.dagger2realworld.LaunchActivity;
import com.measuredsoftware.dagger2realworld.LoginActivity;
import com.measuredsoftware.dagger2realworld.MainActivity;
import com.measuredsoftware.dagger2realworld.RealWorldApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by neil on 19/06/16.
 */
@Singleton
@Component(modules = {ApplicationModule.class, SessionModule.class})
public interface ApplicationComponent {
    void inject(RealWorldApplication application);

    void inject(LaunchActivity launchActivity);

    void inject(MainActivity mainActivity);

    void inject(LoginActivity loginActivity);
}
