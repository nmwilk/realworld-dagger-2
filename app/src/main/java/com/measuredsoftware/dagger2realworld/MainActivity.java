package com.measuredsoftware.dagger2realworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.measuredsoftware.dagger2realworld.model.UserSession;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Inject
    UserSession userSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((RealWorldApplication)getApplication()).applicationLevelComponent().inject(this);

        setContentView(R.layout.activity_logout);

        ((TextView)findViewById(R.id.user_id)).setText(userSession.getUser().getId());
        findViewById(R.id.logout).setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        userSession.logoutUser();
        finish();
    }
}
