package com.dashu.apiexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * base基类
 * 有toolbar
 * 共同有返回键
 * Created by tanglong on 2017/10/9 0009 18:09.
 *
 * @since version 2.1.6
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
