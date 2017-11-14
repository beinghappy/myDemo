package com.dashu.apiexample.anim;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.dashu.apiexample.R;

public class ObjectAnimActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView contentTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);
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
                showAlphaViewByValueAnimator(contentTV);
                break;
            case R.id.scaleButton:
                showScaleViewByValueAnimator(contentTV);
                break;
            case R.id.translateButton:
                showTranslateViewByValueAnimator(contentTV);
                break;
            case R.id.rotateButton:
                showRotateViewByValueAnimator(contentTV);
                break;
        }
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
}
