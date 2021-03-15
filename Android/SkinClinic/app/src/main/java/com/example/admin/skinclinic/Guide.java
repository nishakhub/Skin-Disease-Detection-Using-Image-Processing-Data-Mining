package com.example.admin.skinclinic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by admin on 21-04-2019.
 */

public class Guide extends AppCompatActivity {

    VideoView videoView;
    Button btn;
    MediaController mc;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guidelayout);
        videoView=(VideoView)findViewById(R.id.videoView2);
        btn=(Button)findViewById(R.id.btnplay);
    }

    public void click6(View view) {

        if (view.getId() == R.id.imageView14) {

            Intent i = new Intent(Guide.this, Display.class);
            startActivity(i);
        }


    }

    public void Videoplay(View v){

        mc = new MediaController(this);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.test);
        mc.setAnchorView(videoView);
        videoView.setMediaController(mc);
        videoView.start();
    }
}
