package com.example.mydietapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    final Random rndImage = new Random();
    final Random rndText = new Random();
    int rando = rndText.nextInt(2);
    final String[] listQuotes = {"Be Awesome", "Be Cool", "Be Smart"};
    TextView textQuote = (TextView) findViewById(R.id.quote);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textQuote.setText(listQuotes[rando]);

        final ImageView img = findViewById(R.id.imageRandom);
        final String str = "img_" + rndImage.nextInt(2);
        img.setImageDrawable(
                getResources().getDrawable(getResourceID(str, getApplicationContext()))
        );
    }

    protected static int getResourceID(String resName, final Context ctx) {
        final int ResourceID = ctx.getResources().getIdentifier(resName, "drawable", ctx.getApplicationInfo().packageName);
        if (ResourceID ==0){
            throw new IllegalArgumentException("No resource string found with name " + resName);
        }
        else{
            return ResourceID;
        }
    }
}
