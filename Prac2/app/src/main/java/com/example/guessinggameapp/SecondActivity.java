package com.example.guessinggameapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private SeekBar minSeekBar;
    private TextView minText;

    private SeekBar maxSeekBar;
    private TextView maxText;

    private final int limit = 10;
    public int minValue;
    public int maxValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        minSeekBar = (SeekBar) findViewById(R.id.minSeekBar);
        minText = (TextView) findViewById(R.id.minText);

        maxSeekBar = (SeekBar) findViewById(R.id.maxSeekBar);
        maxText = (TextView) findViewById(R.id.maxText);

        minSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                minText.setText(String.valueOf(i));
                int maxValue = minSeekBar.getMax();
                if (minSeekBar.getProgress() >= (maxValue - limit)){
                    minSeekBar.setProgress(maxValue - limit);
                }
                else if(minSeekBar.getProgress() >= (maxSeekBar.getProgress() - 10)){
                    maxSeekBar.setProgress(minSeekBar.getProgress() + 10);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        maxSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                maxText.setText(String.valueOf(i));
                if(maxSeekBar.getProgress() <= limit){
                    maxSeekBar.setProgress(limit);
                } else if (maxSeekBar.getProgress() <= (minSeekBar.getProgress() + 10)) {
                    minSeekBar.setProgress(maxSeekBar.getProgress()- 10);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void returnMainActivity(View view){
        minValue = Integer.parseInt(minText.getText().toString());
        maxValue = Integer.parseInt(maxText.getText().toString());
        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra("minValue", minValue);
        intent.putExtra("maxValue", maxValue);
        startActivity(intent);
    }
}
