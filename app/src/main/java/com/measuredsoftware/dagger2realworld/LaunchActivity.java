package com.measuredsoftware.dagger2realworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.measuredsoftware.dagger2realworld.model.UserSession;

import javax.inject.Inject;

/**
 * Created by neil on 19/06/16.
 */
public class LaunchActivity extends AppCompatActivity {
    @Inject
    UserSession userSession;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((RealWorldApplication)getApplication()).applicationLevelComponent().inject(this);

        setContentView(R.layout.activity_launch);

        final Class clazz;
        if (userSession.isUserLoggedIn()) {
            clazz = MainActivity.class;
        } else {
            clazz = LoginActivity.class;
        }

        final Intent intent = new Intent(this, clazz);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
