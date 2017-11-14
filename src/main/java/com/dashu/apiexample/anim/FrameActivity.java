package com.dashu.apiexample.anim;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.dashu.apiexample.R;


/**
 * 帧动画
 * Created by tanglong on 2017/11/13 0013 16:02.
 *
 * @since version 2.1.6
 */

public class FrameActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView displayFrameImage;
    private AnimationDrawable animationDrawable ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_anim);
        findViewById(R.id.start_btn).setOnClickListener(this);
        findViewById(R.id.end_btn).setOnClickListener(this);
        displayFrameImage = findViewById(R.id.display_frame_img);
        startAnim();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_btn:
                startAnim();
                break;
            case R.id.end_btn:
                stopAnim();
                break;
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //都可以
//        startAnim();
    }

    private void startAnim() {
        displayFrameImage.setImageResource(R.drawable.loading_anim);
        animationDrawable = (AnimationDrawable) displayFrameImage.getDrawable();
        animationDrawable.start();
    }

    private void stopAnim() {
        displayFrameImage.setImageResource(R.drawable.loading_anim);
        animationDrawable = (AnimationDrawable) displayFrameImage.getDrawable();
        animationDrawable.stop();
    }
}
