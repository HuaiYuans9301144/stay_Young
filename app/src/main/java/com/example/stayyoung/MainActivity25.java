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

public class MainActivity25 extends AppCompatActivity {
    CheckBox mCB21;
    CheckBox mCB22;
    CheckBox mCB23;
    CheckBox mCB24;
    public  static final String SHARED_PREFS = "sharedPrefs";
    private Boolean isRemember21 = false;
    private Boolean isRemember22 = false;
    private Boolean isRemember23 = false;
    private Boolean isRemember24 = false;
    Button mBT85;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main25);
        initUI();

        Button button85 = (Button) findViewById(R.id.button85);
        button85.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity25.this, MainActivity23.class);
                startActivity(intent);
                MyToast("已儲存");
            }
        });
        initializeViews();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        mCB21.setChecked(sharedPreferences.getBoolean("Remember21", true));
        mCB22.setChecked(sharedPreferences.getBoolean("Remember22", true));
        mCB23.setChecked(sharedPreferences.getBoolean("Remember23", true));
        mCB24.setChecked(sharedPreferences.getBoolean("Remember24", true));
    }
    private  void initializeViews() {
        mCB21 = (CheckBox) findViewById(R.id.checkBox11);
        mCB21.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember21 = isChecked;

            }
        });
        mCB22 = (CheckBox) findViewById(R.id.checkBox21);
        mCB22.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember22 = isChecked;

            }
        });
        mCB23 = (CheckBox) findViewById(R.id.checkBox22);
        mCB23.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember23 = isChecked;

            }
        });
        mCB24 = (CheckBox) findViewById(R.id.checkBox23);
        mCB24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember24 = isChecked;

            }
        });
    }
    @Override
    public void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("Remember21", isRemember21);
        editor.commit();
        editor.putBoolean("Remember22", isRemember22);
        editor.commit();
        editor.putBoolean("Remember23", isRemember23);
        editor.commit();
        editor.putBoolean("Remember24", isRemember24);
        editor.commit();
    }
    private void initUI() {
        mCB21 = (CheckBox) findViewById(R.id.checkBox11);
        mCB22 = (CheckBox) findViewById(R.id.checkBox21);
        mCB23 = (CheckBox) findViewById(R.id.checkBox22);
        mCB24 = (CheckBox) findViewById(R.id.checkBox23);
        mBT85 = (Button)findViewById(R.id.button85);
    }
    private void MyToast(String str)
    {
        Toast mtoast = Toast.makeText(MainActivity25.this,str,Toast.LENGTH_SHORT);
        mtoast.setGravity(Gravity.TOP,0,400);
        mtoast.show();
    }
}