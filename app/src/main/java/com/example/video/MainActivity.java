package com.example.video;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.MediaController;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.myVideo)
    VideoView myVideo;

    private TrailerAdapter adapter;
    private int[] trailerimage = {R.drawable.thumbnail, R.drawable.thumbnail2};
    String [] video={"/storage/emulated/0/VID_20161222_194407_434.mp4","/storage/emulated/0/20170210_185749.mp4"};
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //Creating MediaController
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(myVideo);

        myVideo.setMediaController(mediaController);
        //myVideo.setVideoURI(uri);
        myVideo.requestFocus();
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        adapter = new TrailerAdapter(this, trailerimage, new OnTrailerClickListener() {
            @Override
            public void onItemClick(int position) {

                    Uri uri=Uri.parse(video[position]);
                    myVideo.setVideoURI(uri);
                    myVideo.start();
                   // myVideo.start();


            }
        });
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }
}
