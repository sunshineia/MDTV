package com.example.mdtv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private RecyclerView channelList;
    private ChannelListAdapter channelAdapter;

    public static final String EXTRA_MESSAGE = "com.example.mdtv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("TV-节目列表");
        channelList = findViewById(R.id.main_recycler_channelList);
        channelAdapter = new ChannelListAdapter();
        channelList.setLayoutManager(new LinearLayoutManager(this));//设置列表样式
        channelList.setAdapter(channelAdapter);
        channelList.addItemDecoration(
                new DividerItemDecoration(
                        this, DividerItemDecoration.VERTICAL
                )
        );
        channelAdapter.setOnItemClickListener(new ChannelListAdapter.OnItemClickListener() {
            public void onClick(int position) {//窗口跳转，跳转到播放页面
                Intent intent = new Intent(MainActivity.this, BofangActivity.class);
                intent.putExtra("name", ChannelLab.get().getTv(position));
                startActivity(intent);
            }
        });
    }
}



