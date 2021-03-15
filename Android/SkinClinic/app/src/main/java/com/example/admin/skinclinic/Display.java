package com.example.admin.skinclinic;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 *Created by admin on 09-01-2019.
 */

public class Display extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        ImageView mImageView;
        mImageView = (ImageView) findViewById(R.id.imageView2);
        mImageView.setImageResource(R.drawable.ic_healing_black_24dp);


    }

    public void desp(View view) {

        if (view.getId() == R.id.textView3) {

            Intent i = new Intent(Display.this, Description.class);
            startActivity(i);
        }

    }

    public void about(View view) {

        if (view.getId() == R.id.textView6) {

            Intent i = new Intent(Display.this, About.class);
            startActivity(i);
        }
    }

    public void detect(View view) {

        if (view.getId() == R.id.textView5) {

            Intent i = getPackageManager().getLaunchIntentForPackage("com.example.admin.detection");
            startActivity(i);
        }

    }
    public void contact(View view) {

        if (view.getId() == R.id.textView7) {

            Intent i = new Intent(Display.this, Contact.class);
            startActivity(i);
        }

    }
    public void guide(View view) {

        if (view.getId() == R.id.textView4) {

            Intent i = new Intent(Display.this, Guide.class);
            startActivity(i);
        }

    }
}


