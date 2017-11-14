package com.dashu.apiexample.anim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.dashu.apiexample.R;

public class ViewAnimationActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView contentTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        contentTV = (TextView) findViewById(R.id.content_textview);
        findViewById(R.id.alphaButton).setOnClickListener(this);
        findViewById(R.id.scaleButton).setOnClickListener(this);
        findViewById(R.id.rotateButton).setOnClickListener(this);
        findViewById(R.id.translateButton).setOnClickListener(this);
        findViewById(R.id.setButton).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.alphaButton:
                showAlphaAnim(contentTV);
                break;
            case R.id.scaleButton:
                showScaleAnim(contentTV);
                break;
            case R.id.translateButton:
                showTranslateView(contentTV);
                break;

            case R.id.rotateButton:
                showRotateView(contentTV);
                break;
            case R.id.setButton:
                showSetView(contentTV);
                break;
        }
    }

    private void showAlphaAnim(View view){
        view.clearAnimation();
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.test_alpha);
        view.startAnimation(animation);
    }
    private void showScaleAnim(View view){
        view.clearAnimation();
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.test_scale);
        view.startAnimation(animation);
    }

    private void showTranslateView(TextView view) {
        view.clearAnimation();
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.test_translate);
        view.startAnimation(animation);
    }

    private void showRotateView(TextView view) {
        view.clearAnimation();
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.test_rotate);
        view.startAnimation(animation);
    }

    private void showSetView(TextView view) {
        view.clearAnimation();
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.test_set);
        view.startAnimation(animation);
    }
}
