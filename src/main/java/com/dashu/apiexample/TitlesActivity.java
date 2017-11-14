package com.dashu.apiexample;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dashu.apiexample.anim.FrameActivity;
import com.dashu.apiexample.anim.ObjectAnim2Activity;
import com.dashu.apiexample.anim.ObjectAnimActivity;
import com.dashu.apiexample.anim.TransitionActivity;
import com.dashu.apiexample.anim.ViewAnimationActivity;

import java.util.ArrayList;
import java.util.List;

public class TitlesActivity extends AppCompatActivity {

    ListView listView;
    private List<String> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titles);
        listView = (ListView) findViewById(R.id.title_listview);
        initData();
        initRecyclerView();

    }

    private void initData() {
        dataList = new ArrayList<>();
        dataList.add("帧动画");
        dataList.add("补间动画");
        dataList.add("属性动画");
        dataList.add("属性动画2");
        dataList.add("转场动画");
    }

    private void initRecyclerView(){
        listView.setAdapter(new MyAdapter(dataList));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(dataList.get(i).equals("帧动画")){
                    jumpActivity(FrameActivity.class);
                }else if(dataList.get(i).equals("补间动画")){
                    jumpActivity(ViewAnimationActivity.class);
                }else if(dataList.get(i).equals("属性动画")){
                    jumpActivity(ObjectAnimActivity.class);
                }else if(dataList.get(i).equals("属性动画2")){
                    jumpActivity(ObjectAnim2Activity.class);
                }else if(dataList.get(i).equals("转场动画")){
                    jumpActivity(TransitionActivity.class);
                }
            }
        });
    }

    private void jumpActivity(Class targetActivity){
        Intent intent = new Intent(this,targetActivity);
        startActivity(intent);
    }

    private class MyAdapter extends BaseAdapter {
        private List<String> mDataList;
        private ObjectAnimator animator ;
        private MyHolder holder;
        public MyAdapter(List<String> dataList) {
            this.mDataList = dataList;
            animator = (ObjectAnimator) AnimatorInflater.loadAnimator(TitlesActivity.this,R.animator.recycler_item_in);
        }


        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public Object getItem(int position) {
            return dataList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MyHolder myHolder = null;
            if(convertView==null){
                myHolder = new MyHolder();
                convertView = getLayoutInflater().inflate(R.layout.item_recycler,null);
                myHolder.textview = (TextView) convertView.findViewById(R.id.textView);
                convertView.setTag(myHolder);
            }else{
                myHolder = (MyHolder) convertView.getTag();
            }

            myHolder.textview.setText(mDataList.get(position));
            animator.setTarget(myHolder.textview);

            return convertView;
        }


        class MyHolder{
            TextView textview;
        }
    }
}
