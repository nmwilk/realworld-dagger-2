package com.measuredsoftware.dagger2realworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.measuredsoftware.dagger2realworld.di.ApplicationComponent;
import com.measuredsoftware.dagger2realworld.di.login.DaggerLogInComponent;
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

        final ApplicationComponent applicationComponent = ((RealWorldApplication) getApplication()).applicationComponent();
        DaggerLogInComponent.builder().applicationComponent(applicationComponent)
                .logInModule(new LogInModule("Production URL"))
                .build()
                .inject(this);

        setContentView(R.layout.activity_login);

        ((TextView) findViewById(R.id.url)).setText(loginBehaviour.getLogInUrl());
        findViewById(R.id.login).setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        final String userId = String.valueOf(new Random(SystemClock.currentThreadTimeMillis()).nextInt(1000));
        userSession.loginUser(new User(userId));

        final Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
