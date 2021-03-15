package com.example.admin.skinclinic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView mImageView;
        mImageView = (ImageView) findViewById(R.id.imageView);
        mImageView.setImageResource(R.drawable.ic_healing_black_24dp);
    }

    public void onButtonClick(View view){

        if(view.getId() == R.id.Bdisplay){

            Intent i = new Intent(MainActivity.this, Display.class);
            startActivity(i);
        }

    }
}
