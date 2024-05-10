package com.example.stayyoung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {
    private  Switch vibrate1;
    private  Switch vibrate2;
    private  Button page6BTN;
    public  static final String SHARED_PREFS = "sharedPrefs";
    public  static final String Vibrate1 = "vibrate1";
    public  static final String Vibrate2 = "vibrate2";
    private boolean switchOnOff1;
    private boolean switchOnOff2;
    private Spinner frequencySpinner;
    private Spinner differentSpinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        vibrate1 = (Switch) findViewById(R.id.vibrate1);
        vibrate2 = (Switch) findViewById(R.id.vibrate2);


        frequencySpinner = (Spinner)findViewById(R.id.frequencySpinner);
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final int timeSelection = sharedPreferences.getInt("timeSelection",0);
        final GlobalVariable gv = (GlobalVariable)getApplicationContext();

        final String[] frequency = {"0分鐘","10分鐘","20分鐘","30分鐘","40分鐘"};
        final ArrayAdapter<String> frequencyList = new ArrayAdapter<>(MainActivity6.this,
                android.R.layout.simple_spinner_dropdown_item, frequency);
        frequencySpinner.setAdapter(frequencyList);
        frequencySpinner.setSelection(timeSelection);
        frequencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editor.putInt("timeSelection",position).commit();
                gv.settime(timeSelection);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        differentSpinner = (Spinner)findViewById(R.id.differentSpinner);
        SharedPreferences sharedPreferences1 = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        final SharedPreferences.Editor editor1 = sharedPreferences.edit();
        final int levelSelection = sharedPreferences.getInt("levelSelection",9);
       // final GlobalVariable gv = (GlobalVariable)getApplicationContext();

        final String[] level = {"0","1","2","3","4","5","6","7","8","9"};
        final ArrayAdapter<String> levelList = new ArrayAdapter<>(MainActivity6.this,
                android.R.layout.simple_spinner_dropdown_item, level);
        differentSpinner.setAdapter(levelList);
        differentSpinner.setSelection(levelSelection);
        differentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editor.putInt("levelSelection",position).commit();
                gv.setlevel(levelSelection);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button page6BTN = (Button) findViewById(R.id.page6BTN);
        page6BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity6.this, MainActivity2.class);
                startActivity(intent);
                saveData();

            }
        });
        loadData();
        updateViews();
    }
    public  void  saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(Vibrate1,vibrate1.isChecked());
        editor.putBoolean(Vibrate2,vibrate2.isChecked());
        editor.apply();
        Toast.makeText(this,"已儲存",Toast.LENGTH_SHORT).show();

    }
    public  void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        switchOnOff1 = sharedPreferences.getBoolean(Vibrate1,false);
        switchOnOff2 = sharedPreferences.getBoolean(Vibrate2,false);

    }
    public  void  updateViews() {
        vibrate1.setChecked(switchOnOff1);
        vibrate2.setChecked(switchOnOff2);

    }


}

