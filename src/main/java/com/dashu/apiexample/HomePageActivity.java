package com.dashu.apiexample;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 个人主页
 */
public class HomePageActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView contentTV;
    private LinearLayout containerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        contentTV = (TextView) findViewById(R.id.content_textview);
        containerLayout = (LinearLayout) findViewById(R.id.container_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.alphaButton).setOnClickListener(this);
        findViewById(R.id.scaleButton).setOnClickListener(this);
        findViewById(R.id.rotateButton).setOnClickListener(this);
        findViewById(R.id.translateButton).setOnClickListener(this);
        findViewById(R.id.setButton).setOnClickListener(this);
        findViewById(R.id.objectButton).setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                showAlphaAnim(contentTV);
//                showScaleAnim(contentTV);
                loadObjectAnimatorSet(contentTV);

                if(i<4){
                    addItemView();
                }else{
                    removeItemView();
                }

            }
        });
    }

    private void addItemView() {
        i++;
        Button button = new Button(this);
        button.setText("button  "+i);
        containerLayout.addView(button,0);
    }
    private void removeItemView(){
        if(i>0){
            containerLayout.removeViewAt(0);
        }
        i--;
    }

    int i = 0 ;





    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.alphaButton:
//                showAlphaAnim(contentTV);
//                showAlphaViewByValueAnimator(contentTV);
                showAlphaViewByObjectAnimator(contentTV);
                break;
            case R.id.scaleButton:
//                showScaleAnim(contentTV);
//                showScaleViewByValueAnimator(contentTV);
                showScaleViewByObjectAnimator(contentTV);
                break;
            case R.id.translateButton:
//                showTranslateView(contentTV);
//                showTranslateViewByValueAnimator(contentTV);
                showTranslateViewByObjectAnimator(contentTV);
                break;

            case R.id.rotateButton:
//                showRotateView(contentTV);
//                showRotateViewByValueAnimator(contentTV);
                showRotateViewByObjectAnimator(contentTV);
                break;
            case R.id.setButton:
//                showSetView(contentTV);
//                showBackgroudViewByObjectAnimator(contentTV);
                showSetAnimtor(contentTV);
                break;
            case R.id.objectButton:
                loadObjectAnimator(contentTV);
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

    /**
     * 使用ValueAnimator,它是对值做运算，并不对view做操作
     * 缺点：操作view麻烦;需要我们自己操作
     * @param view
     */
    private void showTranslateViewByValueAnimator(final TextView view) {
        view.clearAnimation();
        //是可变参数
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,400);
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获取动画的值
                int curValue = (int)animation.getAnimatedValue();
                view.layout(view.getLeft(),curValue,view.getRight(),curValue+view.getHeight());

            }
        });
        valueAnimator.start();
    }
    /**
     * 使用ValueAnimator,它是对值做运算，并不对view做操作
     * 缺点：操作view麻烦;需要我们自己操作
     * @param view
     */
    private void showScaleViewByValueAnimator(final TextView view) {
        view.clearAnimation();
        //是可变参数
        PropertyValuesHolder xValue = PropertyValuesHolder.ofFloat("scaleX", 1.0f,2.0f);
        PropertyValuesHolder yValue = PropertyValuesHolder.ofFloat("scaleY", 1.0f,3.0f);
        ValueAnimator valueAnimator = ValueAnimator.ofPropertyValuesHolder(xValue,yValue);
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获取动画的值
                float xScale = (float) animation.getAnimatedValue("scaleX");
                float yScale = (float) animation.getAnimatedValue("scaleY");
                view.setScaleX(xScale);
                view.setScaleY(yScale);

            }
        });
        valueAnimator.start();
    }
    /**
     * 使用ValueAnimator,它是对值做运算，并不对view做操作
     * 缺点：操作view麻烦;需要我们自己操作
     * @param view
     */
    private void showAlphaViewByValueAnimator(final TextView view) {
        view.clearAnimation();
        //是可变参数
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1.0f,0.2f);
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获取动画的值
                float alpha = (float) animation.getAnimatedValue();
                view.setAlpha(alpha);

            }
        });
        valueAnimator.start();
    }
    /**
     * 使用ValueAnimator,它是对值做运算，并不对view做操作
     * 缺点：操作view麻烦;需要我们自己操作
     * @param view
     */
    private void showRotateViewByValueAnimator(final TextView view) {
        view.clearAnimation();
        //是可变参数
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,180);
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获取动画的值
                int rotate = (int) animation.getAnimatedValue();
                view.setRotation(rotate);

            }
        });
        valueAnimator.start();
    }
    private ObjectAnimator showAlphaViewByObjectAnimator(final TextView view) {
        view.clearAnimation();
        //是可变参数
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"alpha",0.2f,1.0f);
        animator.setDuration(2000);
        animator.start();
        return animator;
    }
    private ObjectAnimator showScaleViewByObjectAnimator(final TextView view) {
        view.clearAnimation();
        //是可变参数
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"scaleX",0,3,1);
        animator.setDuration(2000);
        animator.start();
        return animator;
    }
    private ObjectAnimator showTranslateViewByObjectAnimator(final TextView view) {
        view.clearAnimation();
        //是可变参数
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"translationX",0,300,100,300);
        animator.setDuration(2000);
        animator.start();
        return animator;
    }
    private ObjectAnimator showRotateViewByObjectAnimator(final TextView view) {
        view.clearAnimation();
        //是可变参数
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofFloat("rotation",0,180,0);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(view,propertyValuesHolder);
        animator.setDuration(2000);
        animator.start();
        return animator;
    }
    private ObjectAnimator showBackgroudViewByObjectAnimator(final TextView view) {
        view.clearAnimation();
        //是可变参数
        ObjectAnimator animator = ObjectAnimator.ofInt(view, "BackgroundColor", 0xffff00ff, 0xffffff00,
                0xffff00ff);
        animator.setDuration(2000);
        animator.start();
        return animator;
    }

    private void loadObjectAnimator(final TextView view) {
        view.clearAnimation();
        //是可变参数
        ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(this,R.animator.test_object);
        animator.setTarget(view);
        animator.start();
    }
    private void loadObjectAnimatorSet(final TextView view) {
        view.clearAnimation();
        //是可变参数
        AnimatorSet animator = (AnimatorSet)AnimatorInflater.loadAnimator(this,R.animator.test_object_set);
        animator.setTarget(view);
        animator.start();
    }

    private void showSetAnimtor(TextView view){
        AnimatorSet  animationSet = new AnimatorSet();
        ObjectAnimator animator = ObjectAnimator.ofInt(view, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofFloat("rotation",0,180);
        ObjectAnimator animator2 = ObjectAnimator.ofPropertyValuesHolder(view,propertyValuesHolder);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(view,"translationX",0,300,100,300);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(view,"scaleX",0,3,1);
        ObjectAnimator animator5 = ObjectAnimator.ofFloat(view,"alpha",0.2f,1.0f);
        animator.setDuration(3000);
        animator2.setDuration(3000);
        animator3.setDuration(3000);
        animator4.setDuration(3000);
        animator5.setDuration(3000);

        List<Animator> list = new ArrayList<>();
        list.add(animator);
        list.add(animator2);
        list.add(animator3);
        list.add(animator4);
        list.add(animator5);
        animationSet.playTogether(list);

    }

}
