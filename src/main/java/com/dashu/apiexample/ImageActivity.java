package com.dashu.apiexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ImageActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<String> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        recyclerView = (RecyclerView) findViewById(R.id.title_recyclerview);
        initData();
        initRecyclerView();

    }

    private void initData() {
        dataList = new ArrayList<>();
        for(int i = 0 ; i < 40 ; i++){
            dataList.add("hello "+ i +" to world");
        }
    }

    private void initRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter(dataList);
        myAdapter.setOnItemListener(new OnItemListener() {
            @Override
            public void onItemClick(int position) {

            }
        });
        recyclerView.setAdapter(myAdapter);
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
        private List<String> mDataList;

        public OnItemListener getOnItemListener() {
            return onItemListener;
        }

        public void setOnItemListener(OnItemListener onItemListener) {
            this.onItemListener = onItemListener;
        }

        private OnItemListener onItemListener;
        public MyAdapter(List<String> dataList) {
            this.mDataList = dataList;
        }


        Animation animator ;
        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.item_recycler,null);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(MyHolder holder, final int position) {
            holder.textview.setText(mDataList.get(position));
            holder.textview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onItemListener!=null){
                        onItemListener.onItemClick(position);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }


        class MyHolder extends RecyclerView.ViewHolder{
            TextView textview;
            public MyHolder(View itemView) {
                super(itemView);
                textview = (TextView) itemView.findViewById(R.id.textView);
            }
        }

    }

    public interface OnItemListener{
        public void onItemClick(int position);
    }

}
