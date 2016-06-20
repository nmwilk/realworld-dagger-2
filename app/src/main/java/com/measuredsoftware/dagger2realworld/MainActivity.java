package com.measuredsoftware.dagger2realworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.measuredsoftware.dagger2realworld.di.session.SessionModule;
import com.measuredsoftware.dagger2realworld.model.User;
import com.measuredsoftware.dagger2realworld.model.UserSession;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Inject
    UserSession userSession;

    @Inject
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((RealWorldApplication) getApplication()).getSessionComponent().inject(this);

        setContentView(R.layout.activity_logout);

        ((TextView) findViewById(R.id.user_id)).setText(user.getId());
        findViewById(R.id.logout).setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        userSession.logoutUser();
        ((RealWorldApplication)getApplication()).clearSessionComponent();
        finish();
    }
}
