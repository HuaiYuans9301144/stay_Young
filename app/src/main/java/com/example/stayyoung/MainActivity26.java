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

public class MainActivity26 extends AppCompatActivity {
    CheckBox mCB31;
    CheckBox mCB32;
    CheckBox mCB33;
    CheckBox mCB34;
    CheckBox mCB35;
    CheckBox mCB36;
    CheckBox mCB37;
    CheckBox mCB38;
    CheckBox mCB39;
    CheckBox mCB30;
    CheckBox mCB301;
    public  static final String SHARED_PREFS = "sharedPrefs";
    private Boolean isRemember31 = false;
    private Boolean isRemember32 = false;
    private Boolean isRemember33 = false;
    private Boolean isRemember34 = false;
    private Boolean isRemember35 = false;
    private Boolean isRemember36 = false;
    private Boolean isRemember37 = false;
    private Boolean isRemember38 = false;
    private Boolean isRemember39 = false;
    private Boolean isRemember30 = false;
    private Boolean isRemember301 = false;
    Button mBT96;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main26);
        initUI();

        Button button96 = (Button) findViewById(R.id.button96);
        button96.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity26.this, MainActivity23.class);
                startActivity(intent);
                MyToast("已儲存");
            }
        });
        initializeViews();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        mCB31.setChecked(sharedPreferences.getBoolean("Remember31", true));
        mCB32.setChecked(sharedPreferences.getBoolean("Remember32", true));
        mCB33.setChecked(sharedPreferences.getBoolean("Remember33", true));
        mCB34.setChecked(sharedPreferences.getBoolean("Remember34", true));
        mCB35.setChecked(sharedPreferences.getBoolean("Remember35", true));
        mCB36.setChecked(sharedPreferences.getBoolean("Remember36", true));
        mCB37.setChecked(sharedPreferences.getBoolean("Remember37", true));
        mCB38.setChecked(sharedPreferences.getBoolean("Remember38", true));
        mCB39.setChecked(sharedPreferences.getBoolean("Remember39", true));
        mCB30.setChecked(sharedPreferences.getBoolean("Remember30", true));
        mCB301.setChecked(sharedPreferences.getBoolean("Remember301", true));
    }
    private  void initializeViews() {
        mCB31 = (CheckBox) findViewById(R.id.checkBox24);
        mCB31.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember31 = isChecked;

            }
        });
        mCB32 = (CheckBox) findViewById(R.id.checkBox25);
        mCB32.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember32 = isChecked;

            }
        });
        mCB33 = (CheckBox) findViewById(R.id.checkBox26);
        mCB33.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember33 = isChecked;

            }
        });
        mCB34 = (CheckBox) findViewById(R.id.checkBox27);
        mCB34.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember34 = isChecked;

            }
        });
        mCB35 = (CheckBox) findViewById(R.id.checkBox28);
        mCB35.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember35 = isChecked;


            }
        });
        mCB36 = (CheckBox) findViewById(R.id.checkBox29);
        mCB36.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember36 = isChecked;

            }
        });
        mCB37 = (CheckBox) findViewById(R.id.checkBox30);
        mCB37.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember37 = isChecked;

            }
        });
        mCB38 = (CheckBox) findViewById(R.id.checkBox31);
        mCB38.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember38 = isChecked;

            }
        });
        mCB39 = (CheckBox) findViewById(R.id.checkBox32);
        mCB39.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember39 = isChecked;

            }
        });
        mCB30 = (CheckBox) findViewById(R.id.checkBox33);
        mCB30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember30 = isChecked;


            }
        });
        mCB301 = (CheckBox) findViewById(R.id.checkBox34);
        mCB301.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember301 = isChecked;

            }
        });
    }
    @Override
    public void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("Remember31", isRemember31);
        editor.commit();
        editor.putBoolean("Remember32", isRemember32);
        editor.commit();
        editor.putBoolean("Remember33", isRemember33);
        editor.commit();
        editor.putBoolean("Remember34", isRemember34);
        editor.commit();
        editor.putBoolean("Remember35", isRemember35);
        editor.commit();
        editor.putBoolean("Remember36", isRemember36);
        editor.commit();
        editor.putBoolean("Remember37", isRemember37);
        editor.commit();
        editor.putBoolean("Remember38", isRemember38);
        editor.commit();
        editor.putBoolean("Remember39", isRemember39);
        editor.commit();
        editor.putBoolean("Remember30", isRemember30);
        editor.commit();
        editor.putBoolean("Remember301", isRemember301);
        editor.commit();

    }
    private void initUI() {
        mCB31 = (CheckBox) findViewById(R.id.checkBox24);
        mCB32 = (CheckBox) findViewById(R.id.checkBox25);
        mCB33 = (CheckBox) findViewById(R.id.checkBox26);
        mCB34 = (CheckBox) findViewById(R.id.checkBox27);
        mCB35 = (CheckBox) findViewById(R.id.checkBox28);
        mCB36 = (CheckBox) findViewById(R.id.checkBox29);
        mCB37 = (CheckBox) findViewById(R.id.checkBox30);
        mCB38 = (CheckBox) findViewById(R.id.checkBox31);
        mCB39 = (CheckBox) findViewById(R.id.checkBox32);
        mCB30 = (CheckBox) findViewById(R.id.checkBox33);
        mCB301 = (CheckBox) findViewById(R.id.checkBox34);
        mBT96 = (Button)findViewById(R.id.button96);
    }
    private void MyToast(String str)
    {
        Toast mtoast = Toast.makeText(MainActivity26.this,str,Toast.LENGTH_SHORT);
        mtoast.setGravity(Gravity.TOP,0,400);
        mtoast.show();
    }

}