package com.example.admin.skinclinic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by admin on 21-04-2019.
 */

public class Contact extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactlayout);
    }
    public void click7(View view) {

        if (view.getId() == R.id.imageView8) {

            Intent i = new Intent(this, Display.class);
            startActivity(i);
        }


    }
}
