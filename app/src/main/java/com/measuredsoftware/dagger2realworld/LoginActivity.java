package com.measuredsoftware.dagger2realworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((RealWorldApplication)getApplication()).applicationLevelComponent().inject(this);

        if (sharedPreferences == null) {
            throw new IllegalStateException(SharedPreferences.class.getSimpleName() + " instance should not be null in " + LoginActivity.class.getSimpleName() + " as it should be injected from the application");
        }

        setContentView(R.layout.activity_login);

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
