package com.example.guessinggameapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView statusText;
    private EditText guessField;
    private TextView rangeText;

    private int secretNumber;
    private int min = 1;
    private int max = 10;
    private int minValue;
    private int maxValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Checks to see if the player set the range for the secretNumber
        try {
            Intent intent = getIntent();
            min = intent.getExtras().getInt("minValue", minValue);
            max = intent.getExtras().getInt("maxValue", maxValue);
        }catch(Exception noIntent){
            System.out.println("No intent found, will use default values");
        }

        //Sets the secret number to a random int between min and max
        Random random = new Random();
        secretNumber = random.nextInt(max - min + 1) + min;  //1 to 10 random value by default
        System.out.println(secretNumber);

        statusText = (TextView) findViewById(R.id.statusText);
        guessField = (EditText) findViewById(R.id.guessField);
        rangeText = (TextView) findViewById(R.id.rangeText);

        //Tells the player the range
        rangeText.setText("The number is between " + min + " and " + max);

        guessField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence string, int i, int i1, int i2) {
                try{
                int value = Integer.parseInt(string.toString());

                if (value == secretNumber) {
                    statusText.setText("You have Won!!");
                }
                else if(value > secretNumber){
                    if(value > max){
                        statusText.setText("That is above the range!");
                    }
                    else {
                        statusText.setText("Lower");
                    }
                }
                else if(value < secretNumber){
                    if(value < min){
                        statusText.setText("That is below the range!");
                    }
                    else {
                        statusText.setText("Higher");
                    }
                }
            }catch (Exception e) {

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    public void changeNumRange(View view){
        /** Call when the user taps on the Change Number Range button */
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
