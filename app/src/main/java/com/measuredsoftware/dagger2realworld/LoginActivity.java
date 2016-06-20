package com.measuredsoftware.dagger2realworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.measuredsoftware.dagger2realworld.di.login.LogInModule;
import com.measuredsoftware.dagger2realworld.model.LoginBehaviour;
import com.measuredsoftware.dagger2realworld.model.User;
import com.measuredsoftware.dagger2realworld.model.UserSession;

import java.util.Random;

import javax.inject.Inject;

/**
 * Created by neil on 19/06/16.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @Inject
    UserSession userSession;

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    LoginBehaviour loginBehaviour;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((RealWorldApplication) getApplication()).getSessionComponent().plus(new LogInModule("Production URL")).inject(this);

        setContentView(R.layout.activity_login);

        ((TextView) findViewById(R.id.url)).setText(loginBehaviour.getLogInUrl());
        findViewById(R.id.login).setOnClickListener(this);

        if (userSession.isUserLoggedIn()) {
            final Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(final View v) {
        final String userId = String.valueOf(new Random(SystemClock.currentThreadTimeMillis()).nextInt(1000));
        userSession.loginUser(new User(userId));

        final Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
