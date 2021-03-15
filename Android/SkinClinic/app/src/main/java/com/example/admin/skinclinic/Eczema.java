package com.example.admin.skinclinic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

/**
 * Created by admin on 18-01-2019.
 */

public class Eczema extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eczemalayout);


        ImageView ImageView2;
        ImageView2 = (ImageView) findViewById(R.id.imageView5);
        ImageView2.setImageResource(R.drawable.eczema);

        WebView view = (WebView) findViewById(R.id.webview3);
        String text;
        text = "<html><body><p align=\"justify\">";
        text+= "Impetigo (im-puh-TIE-go) is a common and highly contagious skin infection that mainly affects infants and children." +
                " Impetigo usually appears as red sores on the face, " +
                "especially around a child's nose and mouth, and on hands and feet." +
                " The sores burst and develop honey-colored crusts.";
        text+= "</p></body></html>";
        view.loadData(text, "text/html", "utf-8");

        WebSettings webSettings = view.getSettings();
        webSettings.setDefaultFontSize(20);


    }
}
