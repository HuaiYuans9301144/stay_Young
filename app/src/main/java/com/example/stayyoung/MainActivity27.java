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

public class MainActivity27 extends AppCompatActivity {
    CheckBox mCB41;
    CheckBox mCB42;
    CheckBox mCB43;
    CheckBox mCB44;
    CheckBox mCB45;
    CheckBox mCB46;
    CheckBox mCB47;
    public  static final String SHARED_PREFS = "sharedPrefs";
    private Boolean isRemember41 = false;
    private Boolean isRemember42 = false;
    private Boolean isRemember43 = false;
    private Boolean isRemember44 = false;
    private Boolean isRemember45 = false;
    private Boolean isRemember46 = false;
    private Boolean isRemember47 = false;
    Button mBT98;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main27);
        initUI();
        Button button98 = (Button) findViewById(R.id.button98);
        button98.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity27.this, MainActivity23.class);
                startActivity(intent);
                MyToast("已儲存");
            }
        });
        initializeViews();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        mCB41.setChecked(sharedPreferences.getBoolean("Remember41", true));
        mCB42.setChecked(sharedPreferences.getBoolean("Remember42", true));
        mCB43.setChecked(sharedPreferences.getBoolean("Remember43", true));
        mCB44.setChecked(sharedPreferences.getBoolean("Remember44", true));
        mCB45.setChecked(sharedPreferences.getBoolean("Remember45", true));
        mCB46.setChecked(sharedPreferences.getBoolean("Remember46", true));
        mCB47.setChecked(sharedPreferences.getBoolean("Remember47", true));

    }
    private  void initializeViews() {
        mCB41 = (CheckBox) findViewById(R.id.checkBox35);
        mCB41.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember41 = isChecked;

            }
        });
        mCB42 = (CheckBox) findViewById(R.id.checkBox36);
        mCB42.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember42 = isChecked;

            }
        });
        mCB43 = (CheckBox) findViewById(R.id.checkBox37);
        mCB43.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember43 = isChecked;

            }
        });
        mCB44 = (CheckBox) findViewById(R.id.checkBox38);
        mCB44.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember44 = isChecked;

            }
        });
        mCB45 = (CheckBox) findViewById(R.id.checkBox39);
        mCB45.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember45 = isChecked;


            }
        });
        mCB46 = (CheckBox) findViewById(R.id.checkBox40);
        mCB46.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember46 = isChecked;

            }
        });
        mCB47 = (CheckBox) findViewById(R.id.checkBox41);
        mCB47.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember47 = isChecked;

            }
        });

    }
    @Override
    public void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("Remember41", isRemember41);
        editor.commit();
        editor.putBoolean("Remember42", isRemember42);
        editor.commit();
        editor.putBoolean("Remember43", isRemember43);
        editor.commit();
        editor.putBoolean("Remember44", isRemember44);
        editor.commit();
        editor.putBoolean("Remember45", isRemember45);
        editor.commit();
        editor.putBoolean("Remember46", isRemember46);
        editor.commit();
        editor.putBoolean("Remember47", isRemember47);
        editor.commit();


    }
    private void initUI() {
        mCB41 = (CheckBox) findViewById(R.id.checkBox35);
        mCB42 = (CheckBox) findViewById(R.id.checkBox36);
        mCB43 = (CheckBox) findViewById(R.id.checkBox37);
        mCB44 = (CheckBox) findViewById(R.id.checkBox38);
        mCB45 = (CheckBox) findViewById(R.id.checkBox39);
        mCB46 = (CheckBox) findViewById(R.id.checkBox40);
        mCB47 = (CheckBox) findViewById(R.id.checkBox41);
        mBT98 = (Button)findViewById(R.id.button98);
    }
    private void MyToast(String str)
    {
        Toast mtoast = Toast.makeText(MainActivity27.this,str,Toast.LENGTH_SHORT);
        mtoast.setGravity(Gravity.TOP,0,400);
        mtoast.show();
    }

}

