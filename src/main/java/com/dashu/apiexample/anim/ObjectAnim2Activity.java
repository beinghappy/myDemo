package com.dashu.apiexample.anim;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dashu.apiexample.R;

/**
 * 属性动画二
 */
public class ObjectAnim2Activity extends AppCompatActivity implements View.OnClickListener{

    private TextView contentTV;
    private LinearLayout containerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim2);
        contentTV = (TextView) findViewById(R.id.content_textview);
        containerLayout = (LinearLayout) findViewById(R.id.container_layout);
        findViewById(R.id.alphaButton).setOnClickListener(this);
        findViewById(R.id.scaleButton).setOnClickListener(this);
        findViewById(R.id.rotateButton).setOnClickListener(this);
        findViewById(R.id.translateButton).setOnClickListener(this);
        findViewById(R.id.colorButton).setOnClickListener(this);
        findViewById(R.id.objectButton).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.alphaButton:
                showAlphaViewByObjectAnimator(contentTV);
                break;
            case R.id.scaleButton:
                showScaleViewByObjectAnimator(contentTV);
                break;
            case R.id.translateButton:
                showTranslateViewByObjectAnimator(contentTV);
                break;

            case R.id.rotateButton:
                showRotateViewByObjectAnimator(contentTV);
                break;
            case R.id.colorButton:
                showBackgroudViewByObjectAnimator(contentTV);
                break;
            case R.id.objectButton:
                loadObjectAnimator(contentTV);
                break;
        }
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

}
