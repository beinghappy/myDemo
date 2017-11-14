package com.dashu.apiexample.anim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dashu.apiexample.R;

public class AnotherTransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_transition);

        getWindow().setSharedElementEnterTransition(new android.transition.ChangeBounds().setDuration(1000));
    }
}
