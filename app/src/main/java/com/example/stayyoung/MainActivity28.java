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

public class MainActivity28 extends AppCompatActivity {
    CheckBox mCB61;
    CheckBox mCB62;
    CheckBox mCB63;
    CheckBox mCB64;
    CheckBox mCB65;
    CheckBox mCB66;
    CheckBox mCB67;
    CheckBox mCB68;
    CheckBox mCB69;
    CheckBox mCB60;
    CheckBox mCB601;
    CheckBox mCB602;
    CheckBox mCB603;
    public  static final String SHARED_PREFS = "sharedPrefs";
    private Boolean isRemember61 = false;
    private Boolean isRemember62 = false;
    private Boolean isRemember63 = false;
    private Boolean isRemember64 = false;
    private Boolean isRemember65 = false;
    private Boolean isRemember66 = false;
    private Boolean isRemember67 = false;
    private Boolean isRemember68 = false;
    private Boolean isRemember69 = false;
    private Boolean isRemember60 = false;
    private Boolean isRemember601 = false;
    private Boolean isRemember602 = false;
    private Boolean isRemember603 = false;
    Button mBT99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main28);
        initUI();

        Button button99 = (Button) findViewById(R.id.button99);
        button99.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity28.this, MainActivity23.class);
                startActivity(intent);
                MyToast("已儲存");

            }
        });
        initializeViews();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        mCB61.setChecked(sharedPreferences.getBoolean("Remember61", true));
        mCB62.setChecked(sharedPreferences.getBoolean("Remember62", true));
        mCB63.setChecked(sharedPreferences.getBoolean("Remember63", true));
        mCB64.setChecked(sharedPreferences.getBoolean("Remember64", true));
        mCB65.setChecked(sharedPreferences.getBoolean("Remember65", true));
        mCB66.setChecked(sharedPreferences.getBoolean("Remember66", true));
        mCB67.setChecked(sharedPreferences.getBoolean("Remember67", true));
        mCB68.setChecked(sharedPreferences.getBoolean("Remember68", true));
        mCB69.setChecked(sharedPreferences.getBoolean("Remember69", true));
        mCB60.setChecked(sharedPreferences.getBoolean("Remember60", true));
        mCB601.setChecked(sharedPreferences.getBoolean("Remember601", true));
        mCB602.setChecked(sharedPreferences.getBoolean("Remember602", true));
        mCB603.setChecked(sharedPreferences.getBoolean("Remember603", true));

    }
    private  void initializeViews() {
        mCB61 = (CheckBox) findViewById(R.id.checkBox42);
        mCB61.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember61 = isChecked;

            }
        });
        mCB62 = (CheckBox)findViewById(R.id.checkBox43);
        mCB62.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember62 = isChecked;

            }
        });
        mCB63 = (CheckBox)findViewById(R.id.checkBox44);
        mCB63.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember63 = isChecked;

            }
        });
        mCB64 = (CheckBox)findViewById(R.id.checkBox45);
        mCB64.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember64 = isChecked;

            }
        });
        mCB65 = (CheckBox)findViewById(R.id.checkBox46);
        mCB65.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember65 = isChecked;

            }
        });
        mCB66 = (CheckBox)findViewById(R.id.checkBox47);
        mCB66.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember66 = isChecked;

            }
        });
        mCB67 = (CheckBox)findViewById(R.id.checkBox48);
        mCB67.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember67 = isChecked;

            }
        });
        mCB68 = (CheckBox)findViewById(R.id.checkBox49);
        mCB68.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember68 = isChecked;

            }
        });
        mCB69 = (CheckBox)findViewById(R.id.checkBox50);
        mCB69.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember69 = isChecked;

            }
        });
        mCB60 = (CheckBox)findViewById(R.id.checkBox51);
        mCB60.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember60 = isChecked;

            }
        });
        mCB601 = (CheckBox)findViewById(R.id.checkBox52);
        mCB601.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember601 = isChecked;

            }
        });
        mCB602 = (CheckBox)findViewById(R.id.checkBox53);
        mCB602.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember602 = isChecked;

            }
        });
        mCB603 = (CheckBox)findViewById(R.id.checkBox54);
        mCB603.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isRemember603 = isChecked;

            }
        });

    }
    @Override
    public void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("Remember61", isRemember61);
        editor.commit();
        editor.putBoolean("Remember62", isRemember62);
        editor.commit();
        editor.putBoolean("Remember63", isRemember63);
        editor.commit();
        editor.putBoolean("Remember64", isRemember64);
        editor.commit();
        editor.putBoolean("Remember65", isRemember65);
        editor.commit();
        editor.putBoolean("Remember66", isRemember66);
        editor.commit();
        editor.putBoolean("Remember67", isRemember67);
        editor.commit();
        editor.putBoolean("Remember68", isRemember68);
        editor.commit();
        editor.putBoolean("Remember69", isRemember69);
        editor.commit();
        editor.putBoolean("Remember60", isRemember60);
        editor.commit();
        editor.putBoolean("Remember601", isRemember601);
        editor.commit();
        editor.putBoolean("Remember602", isRemember602);
        editor.commit();
        editor.putBoolean("Remember603", isRemember603);
        editor.commit();

    }

    private void initUI() {
        mCB61 = (CheckBox)findViewById(R.id.checkBox42);
        mCB62 = (CheckBox)findViewById(R.id.checkBox43);
        mCB63 = (CheckBox)findViewById(R.id.checkBox44);
        mCB64 = (CheckBox)findViewById(R.id.checkBox45);
        mCB65 = (CheckBox)findViewById(R.id.checkBox46);
        mCB66 = (CheckBox)findViewById(R.id.checkBox47);
        mCB67 = (CheckBox)findViewById(R.id.checkBox48);
        mCB68 = (CheckBox)findViewById(R.id.checkBox49);
        mCB69 = (CheckBox)findViewById(R.id.checkBox50);
        mCB60 = (CheckBox)findViewById(R.id.checkBox51);
        mCB601 = (CheckBox)findViewById(R.id.checkBox52);
        mCB602 = (CheckBox)findViewById(R.id.checkBox53);
        mCB603 = (CheckBox)findViewById(R.id.checkBox54);
        mBT99 = (Button)findViewById(R.id.button99);


    }
    private void MyToast(String str)
    {
        Toast mtoast = Toast.makeText(MainActivity28.this,str,Toast.LENGTH_SHORT);
        mtoast.setGravity(Gravity.TOP,0,400);
        mtoast.show();
    }

}

