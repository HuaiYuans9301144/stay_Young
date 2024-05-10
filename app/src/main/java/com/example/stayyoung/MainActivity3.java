package com.example.stayyoung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity3 extends AppCompatActivity {
    private SeekBar seekBar1,seekBar2,seekBar3,seekBar4;
    private TextView textView,textView2,textView3,textView4;
    private Button submitBTN;
    public  static final String SHARED_PREFS = "sharedPrefs";
    public  static final String SHARED_PREFS2 = "sharedPrefs2";
    public  static final String SHARED_PREFS3 = "sharedPrefs3";
    public  static final String SHARED_PREFS4 = "sharedPrefs4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button submitBTN = (Button) findViewById(R.id.submitBTN);
        submitBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity3.this, MainActivity4.class);
                startActivity(intent); }
        });

        Button historyBTN = (Button) findViewById(R.id.historyBTN);
        historyBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity3.this, MainActivity3_3.class);
                startActivity(intent); }
        });

        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        seekBar1.setProgress(sharedPreferences.getInt(SHARED_PREFS,0));

        textView = (TextView) findViewById(R.id.sbTV1);
        textView.setText(seekBar1.getProgress() + "/" + seekBar1.getMax());
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do something here,
                //if you want to do anything at the start of
                // touching the seekbar
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Display the value in textview
                textView.setText(progress + "/" + seekBar.getMax());
                seekBar1.setSecondaryProgress(seekBar.getProgress());
                editor.putInt(SHARED_PREFS,seekBar1.getProgress());
                editor.commit();
            }
        });


        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        SharedPreferences sharedPreferences1 = getSharedPreferences(SHARED_PREFS2,MODE_PRIVATE);
        final SharedPreferences.Editor editor1 = sharedPreferences.edit();
        seekBar2.setProgress(sharedPreferences.getInt(SHARED_PREFS2,0));
        textView2 = (TextView) findViewById(R.id.sbTV2);
        textView2.setText(seekBar2.getProgress() + "/" + seekBar2.getMax());
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do something here,
                //if you want to do anything at the start of
                // touching the seekbar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Display the value in textview
                textView2.setText(progress + "/" + seekBar.getMax());
                seekBar2.setSecondaryProgress(seekBar.getProgress());
                editor1.putInt(SHARED_PREFS2,seekBar2.getProgress());
                editor1.commit();
            }
        });

        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        SharedPreferences sharedPreferences2 = getSharedPreferences(SHARED_PREFS3,MODE_PRIVATE);
        final SharedPreferences.Editor editor2 = sharedPreferences.edit();
        seekBar3.setProgress(sharedPreferences.getInt(SHARED_PREFS3,0));
        textView3 = (TextView) findViewById(R.id.sbTV3);
        textView3.setText(seekBar3.getProgress() + "/" + seekBar3.getMax());
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do something here,
                //if you want to do anything at the start of
                // touching the seekbar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Display the value in textview
                textView3.setText(progress + "/" + seekBar.getMax());
                seekBar3.setSecondaryProgress(seekBar.getProgress());
                editor2.putInt(SHARED_PREFS3,seekBar3.getProgress());
                editor2.commit();
            }
        });

        seekBar4 = (SeekBar) findViewById(R.id.seekBar4);
        SharedPreferences sharedPreferences3 = getSharedPreferences(SHARED_PREFS4,MODE_PRIVATE);
        final SharedPreferences.Editor editor3 = sharedPreferences.edit();
        seekBar4.setProgress(sharedPreferences.getInt(SHARED_PREFS4,0));
        textView4 = (TextView) findViewById(R.id.sbTV4);
        textView4.setText(seekBar4.getProgress() + "/" + seekBar4.getMax());
        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do something here,
                //if you want to do anything at the start of
                // touching the seekbar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Display the value in textview
                textView4.setText(progress + "/" + seekBar.getMax());
                seekBar4.setSecondaryProgress(seekBar.getProgress());
                editor3.putInt(SHARED_PREFS4,seekBar4.getProgress());
                editor3.commit();
            }
        });


        }
}
