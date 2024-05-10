package com.example.stayyoung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity24 extends AppCompatActivity {
    CheckBox mCB10;
    CheckBox mCB12;
    CheckBox mCB13;
    CheckBox mCB14;
    CheckBox mCB15;
    CheckBox mCB16;
    CheckBox mCB17;
    CheckBox mCB18;
    CheckBox mCB19;
    CheckBox mCB20;
    public  static final String SHARED_PREFS = "sharedPrefs";
    private Boolean isRemember10 = false;
    private Boolean isRemember12 = false;
    private Boolean isRemember13 = false;
    private Boolean isRemember14 = false;
    private Boolean isRemember15 = false;
    private Boolean isRemember16 = false;
    private Boolean isRemember17 = false;
    private Boolean isRemember18 = false;
    private Boolean isRemember19 = false;
    private Boolean isRemember20 = false;
    Button mBT971;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main24);
        initUI();

        Button button97 = (Button) findViewById(R.id.button97);
        button97.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity24.this, MainActivity23.class);
                startActivity(intent);
                MyToast("已儲存");

            }
        });
        initializeViews();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        mCB10.setChecked(sharedPreferences.getBoolean("Remember10", true));
        mCB12.setChecked(sharedPreferences.getBoolean("Remember12", true));
        mCB13.setChecked(sharedPreferences.getBoolean("Remember13", true));
        mCB14.setChecked(sharedPreferences.getBoolean("Remember14", true));
        mCB15.setChecked(sharedPreferences.getBoolean("Remember15", true));
        mCB16.setChecked(sharedPreferences.getBoolean("Remember16", true));
        mCB17.setChecked(sharedPreferences.getBoolean("Remember17", true));
        mCB18.setChecked(sharedPreferences.getBoolean("Remember18", true));
        mCB19.setChecked(sharedPreferences.getBoolean("Remember19", true));
        mCB20.setChecked(sharedPreferences.getBoolean("Remember20", true));

    }
    private  void initializeViews() {
        mCB10 = (CheckBox) findViewById(R.id.checkBox10);
        mCB10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember10 = isChecked;

            }
        });
        mCB12 = (CheckBox)findViewById(R.id.checkBox12);
        mCB12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember12 = isChecked;

            }
        });
        mCB13 = (CheckBox)findViewById(R.id.checkBox13);
        mCB13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember13 = isChecked;

            }
        });
        mCB14 = (CheckBox)findViewById(R.id.checkBox14);
        mCB14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember14 = isChecked;

            }
        });
        mCB15 = (CheckBox)findViewById(R.id.checkBox15);
        mCB15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember15 = isChecked;

            }
        });
        mCB16 = (CheckBox)findViewById(R.id.checkBox16);
        mCB16.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember16 = isChecked;

            }
        });
        mCB17 = (CheckBox)findViewById(R.id.checkBox17);
        mCB17.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember17 = isChecked;

            }
        });
        mCB18 = (CheckBox)findViewById(R.id.checkBox18);
        mCB18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember18 = isChecked;

            }
        });
        mCB19 = (CheckBox)findViewById(R.id.checkBox19);
        mCB19.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember19 = isChecked;

            }
        });
        mCB20 = (CheckBox)findViewById(R.id.checkBox20);
        mCB20.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember20 = isChecked;

            }
        });

    }
    @Override
    public void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("Remember10", isRemember10);
        editor.commit();
        editor.putBoolean("Remember12", isRemember12);
        editor.commit();
        editor.putBoolean("Remember13", isRemember13);
        editor.commit();
        editor.putBoolean("Remember14", isRemember14);
        editor.commit();
        editor.putBoolean("Remember15", isRemember15);
        editor.commit();
        editor.putBoolean("Remember16", isRemember16);
        editor.commit();
        editor.putBoolean("Remember17", isRemember17);
        editor.commit();
        editor.putBoolean("Remember18", isRemember18);
        editor.commit();
        editor.putBoolean("Remember19", isRemember19);
        editor.commit();
        editor.putBoolean("Remember20", isRemember20);
        editor.commit();

    }

    private void initUI() {
        mCB10 = (CheckBox)findViewById(R.id.checkBox10);
        mCB12 = (CheckBox)findViewById(R.id.checkBox12);
        mCB13 = (CheckBox)findViewById(R.id.checkBox13);
        mCB14 = (CheckBox)findViewById(R.id.checkBox14);
        mCB15 = (CheckBox)findViewById(R.id.checkBox15);
        mCB16 = (CheckBox)findViewById(R.id.checkBox16);
        mCB17 = (CheckBox)findViewById(R.id.checkBox17);
        mCB18 = (CheckBox)findViewById(R.id.checkBox18);
        mCB19 = (CheckBox)findViewById(R.id.checkBox19);
        mCB20 = (CheckBox)findViewById(R.id.checkBox20);
        mBT971 = (Button)findViewById(R.id.button97);


    }
    private void MyToast(String str)
    {
        Toast mtoast = Toast.makeText(MainActivity24.this,str,Toast.LENGTH_SHORT);
        mtoast.setGravity(Gravity.TOP,0,400);
        mtoast.show();
    }

    }
