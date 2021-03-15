package com.example.admin.skinclinic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.content.Intent;
import android.view.View;

/**
 * Created by admin on 09-01-2019.
 */

public class Description extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descriptionlayout);

        ImageView nImageView;
        nImageView = (ImageView) findViewById(R.id.imageView9);
        nImageView.setImageResource(R.drawable.impetigo);


        ImageView rImageView;
        rImageView = (ImageView) findViewById(R.id.imageView10);
        rImageView.setImageResource(R.drawable.melo);

        ImageView sImageView;
        sImageView = (ImageView) findViewById(R.id.imageView11);
        sImageView.setImageResource(R.drawable.eczema);


    }

    public void click1(View view) {

        if (view.getId() == R.id.imageView9) {

            Intent i = new Intent(Description.this, Impetigo.class);
            startActivity(i);
        }


    }

    public void click2(View view) {

        if (view.getId() == R.id.imageView10) {

            Intent i = new Intent(Description.this, Melanoma.class);
            startActivity(i);
        }


    }
    public void click3(View view) {

        if (view.getId() == R.id.imageView11) {

            Intent i = new Intent(Description.this, Eczema.class);
            startActivity(i);
        }


    }
    public void click5(View view) {

        if (view.getId() == R.id.imageView7) {

            Intent i = new Intent(Description.this, Display.class);
            startActivity(i);
        }


    }

}

