package com.example.stayyoung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.view.Gravity;


public class MainActivity22 extends AppCompatActivity {
    CheckBox mCB2;
    CheckBox mCB3;
    CheckBox mCB4;
    CheckBox mCB5;
    CheckBox mCB6;
    CheckBox mCB1;
    CheckBox mCB7;
    CheckBox mCB8;
    CheckBox mCB9;
    public  static final String SHARED_PREFS = "sharedPrefs";
    private Boolean isRemember2 = false;
    private Boolean isRemember3 = false;
    private Boolean isRemember4 = false;
    private Boolean isRemember5 = false;
    private Boolean isRemember6 = false;
    private Boolean isRemember7 = false;
    private Boolean isRemember8 = false;
    private Boolean isRemember9 = false;
    private Boolean isRemember1 = false;



    Button mBT2;            //提交檔案按鈕
    Button mBT3;            //跳轉到下一項按鈕

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22); //載入佈局檔案
        initUI();                              //初始化控制元件
        //繫結監聽器


        Button button87 = (Button) findViewById(R.id.button87);
        button87.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity22.this, MainActivity23.class);
                startActivity(intent);
                MyToast("已儲存");
            }
        });
        initializeViews();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        mCB1.setChecked(sharedPreferences.getBoolean("Remember2", true));
        mCB2.setChecked(sharedPreferences.getBoolean("Remember3", true));
        mCB3.setChecked(sharedPreferences.getBoolean("Remember4", true));
        mCB4.setChecked(sharedPreferences.getBoolean("Remember5", true));
        mCB5.setChecked(sharedPreferences.getBoolean("Remember6", true));
        mCB6.setChecked(sharedPreferences.getBoolean("Remember7", true));
        mCB7.setChecked(sharedPreferences.getBoolean("Remember1", true));
        mCB8.setChecked(sharedPreferences.getBoolean("Remember8", true));
        mCB9.setChecked(sharedPreferences.getBoolean("Remember9", true));

    }
    private  void initializeViews() {
        mCB1 = (CheckBox) findViewById(R.id.checkBox2);
        mCB1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember2 = isChecked;

            }
        });
        mCB2 = (CheckBox)findViewById(R.id.checkBox3);
        mCB2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember3 = isChecked;

            }
        });
        mCB3 = (CheckBox)findViewById(R.id.checkBox4);
        mCB3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember4 = isChecked;

            }
        });
        mCB4 = (CheckBox)findViewById(R.id.checkBox5);
        mCB4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember5 = isChecked;

            }
        });
        mCB5 = (CheckBox)findViewById(R.id.checkBox6);
        mCB5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember6 = isChecked;

            }
        });
        mCB6 = (CheckBox)findViewById(R.id.checkBox7);
        mCB6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember7 = isChecked;

            }
        });
        mCB7 = (CheckBox)findViewById(R.id.checkBox);
        mCB7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember1 = isChecked;

            }
        });
        mCB8 = (CheckBox)findViewById(R.id.checkBox8);
        mCB8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember8 = isChecked;

            }
        });
        mCB9 = (CheckBox)findViewById(R.id.checkBox9);
        mCB9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember9 = isChecked;

            }
        });

    }
    @Override
    public void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("Remember2", isRemember2);
        editor.commit();
        editor.putBoolean("Remember3", isRemember3);
        editor.commit();
        editor.putBoolean("Remember4", isRemember4);
        editor.commit();
        editor.putBoolean("Remember5", isRemember5);
        editor.commit();
        editor.putBoolean("Remember6", isRemember6);
        editor.commit();
        editor.putBoolean("Remember7", isRemember7);
        editor.commit();
        editor.putBoolean("Remember1", isRemember1);
        editor.commit();
        editor.putBoolean("Remember8", isRemember8);
        editor.commit();
        editor.putBoolean("Remember9", isRemember9);
        editor.commit();

    }

        private void initUI() {
        mCB1 = (CheckBox)findViewById(R.id.checkBox2);
        mCB2 = (CheckBox)findViewById(R.id.checkBox3);
        mCB3 = (CheckBox)findViewById(R.id.checkBox4);
        mCB4 = (CheckBox)findViewById(R.id.checkBox5);
        mCB5 = (CheckBox)findViewById(R.id.checkBox6);
        mCB6 = (CheckBox)findViewById(R.id.checkBox7);
        mCB7 = (CheckBox)findViewById(R.id.checkBox);
        mCB8 = (CheckBox)findViewById(R.id.checkBox8);
        mCB9 = (CheckBox)findViewById(R.id.checkBox9);
        mBT2 = (Button)findViewById(R.id.button87);
        mBT3 = (Button)findViewById(R.id.button87);
    }

    private void MyToast(String str)
    {
        Toast mtoast = Toast.makeText(MainActivity22.this,str,Toast.LENGTH_SHORT);
        mtoast.setGravity(Gravity.TOP,0,400);
        mtoast.show();
    }

}


