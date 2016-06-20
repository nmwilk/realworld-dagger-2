package com.measuredsoftware.dagger2realworld.di;

import com.measuredsoftware.dagger2realworld.di.session.SessionComponent;
import com.measuredsoftware.dagger2realworld.di.session.SessionModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by neil on 19/06/16.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    SessionComponent plus(SessionModule sessionModule);
}
