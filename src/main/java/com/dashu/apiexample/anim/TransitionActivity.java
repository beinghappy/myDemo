package com.dashu.apiexample.anim;

import android.content.Intent;
import android.os.Bundle;
import android.support.transition.ChangeBounds;
import android.support.transition.Fade;
import android.support.transition.Scene;
import android.support.transition.TransitionManager;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dashu.apiexample.HomePageActivity;
import com.dashu.apiexample.R;

public class TransitionActivity extends AppCompatActivity {

    private Scene scene1;
    private Scene scene2;
    private boolean isScene2;
    ViewGroup sceneRoot;
    ImageView image1;
    ImageView image2;
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        sceneRoot = (ViewGroup) findViewById(R.id.root_layout);
//        initScene();
        image1 = findViewById(R.id.image_1);
        image2 = findViewById(R.id.image_2);
        textview = findViewById(R.id.textView2);
        findViewById(R.id.change_screen_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                change(view);
                changeBound(view);
//                fade(view);
//                goContentTransitions(view);
//                goContentTransitionsShareImage(view);
            }
        });

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goContentTransitionsShareImage(view);
            }
        });

//        Slide slide=new Slide();
//        slide.setDuration(500);
//        slide.setSlideEdge(Gravity.LEFT);
//        getWindow().setEnterTransition(slide);
    }

    private void initScene() {

        scene1= Scene.getSceneForLayout(sceneRoot,R.layout.screen1,this);
        scene2=Scene.getSceneForLayout(sceneRoot,R.layout.screen2,this);
        TransitionManager.go(scene1);
    }


    /**
     * activity跳转的动画
     * @param view
     */
    public void goContentTransitions(View view){
        Intent intent = new Intent(this, HomePageActivity.class);
//        startActivity(intent);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        startActivity(intent,activityOptionsCompat.toBundle());
    }

    public void goContentTransitionsShareImage(View view){
        Intent intent = new Intent(this, AnotherTransitionActivity.class);
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                new Pair<View, String>(image1,"hello")
                ,new Pair<View,String>(textview,"world")
        );
        startActivity(intent,activityOptionsCompat.toBundle());
    }


    /**
     * scene1和scene2相互切换，播放动画 * @param view
     */
    public void change(View view){
        ChangeBounds changeBounds = new ChangeBounds();
        TransitionManager.go(isScene2?scene1:scene2,changeBounds);
        changeBounds.addTarget(R.id.image_1);
        isScene2=!isScene2;
    }

    public void fade(View view){
        Fade fade = new Fade();
        fade.setDuration(1000);
        TransitionManager.beginDelayedTransition(sceneRoot,fade);
        toggleVisibility(image1,image2);
    }

    public void changeBound(View view){
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(1000);
        //开启延迟动画，在这里会记录当前视图树的状态
        TransitionManager.beginDelayedTransition(sceneRoot,changeBounds);
        //我们直接修改视图树中的View的属性
        ViewGroup.LayoutParams layoutParams = image1.getLayoutParams();
        layoutParams.height = 400;
        layoutParams.width = 400;
        image1.setLayoutParams(layoutParams);

    }


    private static void toggleVisibility(View... views) {
        for (View view : views) {
            boolean isVisible = view.getVisibility() == View.VISIBLE;
            view.setVisibility(isVisible ? View.INVISIBLE : View.VISIBLE);
        }

    }

}
