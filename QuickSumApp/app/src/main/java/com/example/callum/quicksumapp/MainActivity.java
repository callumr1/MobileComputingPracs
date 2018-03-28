package com.example.callum.quicksumapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button otherButton;
    private Button clearButton;
    private TextView sumText;
    private String countStr;
    private String buttonFunc;
    private Double count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(this);
        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(this);
        button8 = findViewById(R.id.button8);
        button8.setOnClickListener(this);
        button9 = findViewById(R.id.button9);
        button9.setOnClickListener(this);
        otherButton = findViewById(R.id.otherButton);
        otherButton.setOnClickListener(this);
        clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(this);
        sumText = findViewById(R.id.sumText);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button1:
                countStr = sumText.getText().toString();
                count = Double.parseDouble(countStr);
                buttonFunc = (String) button1.getText();
                if (buttonFunc.equals("1")){
                    count += 1;
                }
                else{
                    count += (1d/2d);
                    count = RoundNumbers(count);
                    button1.setText("1");
                    button2.setText("2");
                    button3.setText("3");
                }
                sumText.setText(String.valueOf(count));
                break;

            case R.id.button2:
                countStr = sumText.getText().toString();
                count = Double.parseDouble(countStr);
                buttonFunc = (String) button2.getText();
                if (buttonFunc.equals("2")){
                    count += 2;
                }
                else{
                    count +=(1d/3);
                    count = RoundNumbers(count);
                    button1.setText("1");
                    button2.setText("2");
                    button3.setText("3");
                }
                sumText.setText(String.valueOf(count));
                break;

            case R.id.button3:
                countStr = sumText.getText().toString();
                count = Double.parseDouble(countStr);
                buttonFunc = (String) button3.getText();
                if (buttonFunc.equals("3")){
                    count += 3;
                }
                else{
                    count +=(1d/4);
                    count = RoundNumbers(count);
                    button1.setText("1");
                    button2.setText("2");
                    button3.setText("3");
                }
                sumText.setText(String.valueOf(count));
                break;

            case R.id.button4:
                countStr = sumText.getText().toString();
                count = Double.parseDouble(countStr);
                count += 4;
                sumText.setText(String.valueOf(count));
                break;

            case R.id.button5:
                countStr = sumText.getText().toString();
                count = Double.parseDouble(countStr);
                count += 5;
                sumText.setText(String.valueOf(count));
                break;

            case R.id.button6:
                countStr = sumText.getText().toString();
                count = Double.parseDouble(countStr);
                count += 6;
                sumText.setText(String.valueOf(count));
                break;

            case R.id.button7:
                countStr = sumText.getText().toString();
                count = Double.parseDouble(countStr);
                count += 7;
                sumText.setText(String.valueOf(count));
                break;

            case R.id.button8:
                countStr = sumText.getText().toString();
                count = Double.parseDouble(countStr);
                count += 8;
                sumText.setText(String.valueOf(count));
                break;

            case R.id.button9:
                countStr = sumText.getText().toString();
                count = Double.parseDouble(countStr);
                count += 9;
                sumText.setText(String.valueOf(count));
                break;

            case R.id.otherButton:
                //Needs to change the 1,2,3 buttons to 1/2, 1/3, 1/4
                if(button1.getText().equals("1")){
                    button1.setText("1/2");
                    button2.setText("1/3");
                    button3.setText("1/4");
                }
                else{
                    button1.setText("1");
                    button2.setText("2");
                    button3.setText("3");
                }
                break;

            case R.id.clearButton:
                sumText.setText("0");
                break;
        }
    }
    private static double RoundNumbers(double count){
        count = count*100;
        count = (double) Math.round(count);
        count = count/100;
        return count;
    }
}
