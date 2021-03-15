package com.example.admin.skinclinic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.webkit.WebView;
import android.webkit.WebSettings;
/**
 * Created by admin on 10-01-2019.
 */

public class About extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutlayout);

    }

    public void click4(View view) {

        if (view.getId() == R.id.imageView6) {

            Intent i = new Intent(About.this, Display.class);
            startActivity(i);
        }


    }
}