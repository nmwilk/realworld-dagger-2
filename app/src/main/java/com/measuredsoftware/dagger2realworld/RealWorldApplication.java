package com.measuredsoftware.dagger2realworld;

import android.app.Application;

import com.measuredsoftware.dagger2realworld.di.ApplicationComponent;
import com.measuredsoftware.dagger2realworld.di.ApplicationModule;
import com.measuredsoftware.dagger2realworld.di.DaggerApplicationComponent;
import com.measuredsoftware.dagger2realworld.di.session.SessionComponent;
import com.measuredsoftware.dagger2realworld.di.session.SessionModule;

/**
 * Created by neil on 19/06/16.
 */
public class RealWorldApplication extends Application {

    private ApplicationComponent applicationComponent;
    private SessionComponent sessionComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public SessionComponent getSessionComponent() {
        if (sessionComponent == null) {
            sessionComponent = applicationComponent.plus(new SessionModule());
        }

        return sessionComponent;
    }

    public void clearSessionComponent() {
        sessionComponent = null;
    }

    public ApplicationComponent applicationComponent() {
        return applicationComponent;
    }
}
