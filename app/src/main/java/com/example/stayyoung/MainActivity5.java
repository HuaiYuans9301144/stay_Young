package com.example.stayyoung;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {
    private Spinner skinSP1,skinSP2,skinSP3,skinSP4,skinSP5,skinSP6,skinSP7,skinSP8,skinSP9;

    private SeekBar skinSB1,skinSB2,skinSB3,skinSB4,skinSB5,skinSB6,skinSB7,skinSB8,skinSB9;
    private TextView resultTV1,resultTV2,resultTV3,resultTV4,resultTV5,resultTV6,resultTV7,resultTV8,resultTV9;
    private EditText edit1,edit2,edit3,edit4,edit5,edit6,edit7,edit8,edit9;
    public  static final String SHARED_PREFS = "sharedPrefs";
    public  static final String SHARED_PREFS2 = "sharedPrefs2";
    public  static final String SHARED_PREFS3 = "sharedPrefs3";
    public  static final String SHARED_PREFS4 = "sharedPrefs4";
    public  static final String SHARED_PREFS5 = "sharedPrefs5";
    public  static final String SHARED_PREFS6 = "sharedPrefs6";
    public  static final String SHARED_PREFS7 = "sharedPrefs7";
    public  static final String SHARED_PREFS8 = "sharedPrefs8";
    public  static final String SHARED_PREFS9 = "sharedPrefs9";

    public  static final String SHARED_PREFS11 = "sharedPrefs11";
    public  static final String SHARED_PREFS22 = "sharedPrefs22";
    public  static final String SHARED_PREFS33 = "sharedPrefs33";
    public  static final String SHARED_PREFS44 = "sharedPrefs44";
    public  static final String SHARED_PREFS55 = "sharedPrefs55";
    public  static final String SHARED_PREFS66 = "sharedPrefs66";
    public  static final String SHARED_PREFS77 = "sharedPrefs77";
    public  static final String SHARED_PREFS88 = "sharedPrefs88";
    public  static final String SHARED_PREFS99 = "sharedPrefs99";
    private String sk1;private String sk2;private String sk3;
    private String sk4;private String sk5;private String sk6;
    private String sk7;private String sk8;private String sk9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        skinSB1 = (SeekBar) findViewById(R.id.skinSB1);
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        skinSB1.setProgress(sharedPreferences.getInt(SHARED_PREFS,0));

        resultTV1 = (TextView) findViewById(R.id.resultTV1);
        resultTV1.setText(skinSB1.getProgress() + "/" + skinSB1.getMax());

        skinSB1.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener() {
            GlobalVariable gv = (GlobalVariable)getApplicationContext();
            int progress = gv.getProgress1();
            //int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) { progress = progresValue; }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                resultTV1.setText(progress + "/" + seekBar.getMax());
                editor.putInt(SHARED_PREFS,skinSB1.getProgress());
                editor.commit();
                gv.setProgress1(progress);
            }

                                             }
        );



        skinSB2 = (SeekBar) findViewById(R.id.skinSB2);
        SharedPreferences sharedPreferences2 = getSharedPreferences(SHARED_PREFS2,MODE_PRIVATE);
        final SharedPreferences.Editor editor2 = sharedPreferences.edit();
        skinSB2.setProgress(sharedPreferences.getInt(SHARED_PREFS2,0));

        resultTV2 = (TextView) findViewById(R.id.resultTV2);
        resultTV2.setText(skinSB2.getProgress() + "/" + skinSB2.getMax());
        skinSB2.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener() {
            GlobalVariable gv = (GlobalVariable)getApplicationContext();
            int progress1 = gv.getProgress2();

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) { progress1 = progresValue; }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do something here,
                //if you want to do anything at the start of
                // touching the seekbar
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Display the value in textview
                resultTV2.setText(progress1 + "/" + seekBar.getMax());
                editor2.putInt(SHARED_PREFS2,skinSB2.getProgress());
                editor2.commit();
                gv.setProgress2(progress1);
            }


        });

        skinSB3 = (SeekBar) findViewById(R.id.skinSB3);
        SharedPreferences sharedPreferences3 = getSharedPreferences(SHARED_PREFS3,MODE_PRIVATE);
        final SharedPreferences.Editor editor3 = sharedPreferences.edit();
        skinSB3.setProgress(sharedPreferences.getInt(SHARED_PREFS3,0));

        resultTV3 = (TextView) findViewById(R.id.resultTV3);
        resultTV3.setText(skinSB3.getProgress() + "/" + skinSB3.getMax());
        skinSB3.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener() {
            GlobalVariable gv = (GlobalVariable)getApplicationContext();
            int progress2 = gv.getProgress3();

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) { progress2 = progresValue; }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do something here,
                //if you want to do anything at the start of
                // touching the seekbar
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Display the value in textview
                resultTV3.setText(progress2 + "/" + seekBar.getMax());
                editor3.putInt(SHARED_PREFS3,seekBar.getProgress());
                editor3.commit();
                gv.setProgress3(progress2);
            }
        });


        skinSB4 = (SeekBar) findViewById(R.id.skinSB4);
        SharedPreferences sharedPreferences4 = getSharedPreferences(SHARED_PREFS4,MODE_PRIVATE);
        final SharedPreferences.Editor editor4 = sharedPreferences.edit();
        skinSB4.setProgress(sharedPreferences.getInt(SHARED_PREFS4,0));

        resultTV4 = (TextView) findViewById(R.id.resultTV4);
        resultTV4.setText(skinSB4.getProgress() + "/" + skinSB4.getMax());
        skinSB4.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener() {
            GlobalVariable gv = (GlobalVariable)getApplicationContext();
            int progress3 = gv.getProgress4();
            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) { progress3 = progresValue; }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do something here,
                //if you want to do anything at the start of
                // touching the seekbar
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Display the value in textview
                resultTV4.setText(progress3 + "/" + seekBar.getMax());
                editor4.putInt(SHARED_PREFS4,seekBar.getProgress());
                editor4.commit();
                gv.setProgress4(progress3);
            }

        });
        skinSB5 = (SeekBar) findViewById(R.id.skinSB5);
        SharedPreferences sharedPreferences5 = getSharedPreferences(SHARED_PREFS5,MODE_PRIVATE);
        final SharedPreferences.Editor editor5 = sharedPreferences.edit();
        skinSB5.setProgress(sharedPreferences.getInt(SHARED_PREFS5,0));

        resultTV5 = (TextView) findViewById(R.id.resultTV5);
        resultTV5.setText(skinSB5.getProgress() + "/" + skinSB5.getMax());
        skinSB5.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener() {
            GlobalVariable gv = (GlobalVariable)getApplicationContext();
            int progress4 = gv.getProgress5();

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) { progress4 = progresValue; }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do something here,
                //if you want to do anything at the start of
                // touching the seekbar
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Display the value in textview
                resultTV5.setText(progress4 + "/" + seekBar.getMax());
                editor5.putInt(SHARED_PREFS5, seekBar.getProgress());
                editor5.commit();
                gv.setProgress5(progress4);
            }

        });
        skinSB6 = (SeekBar) findViewById(R.id.skinSB6);
        SharedPreferences sharedPreferences6 = getSharedPreferences(SHARED_PREFS6,MODE_PRIVATE);
        final SharedPreferences.Editor editor6 = sharedPreferences.edit();
        skinSB6.setProgress(sharedPreferences.getInt(SHARED_PREFS6,0));

        resultTV6 = (TextView) findViewById(R.id.resultTV6);
        resultTV6.setText(skinSB6.getProgress() + "/" + skinSB6.getMax());
        skinSB6.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener() {
            GlobalVariable gv = (GlobalVariable)getApplicationContext();
            int progress5 = gv.getProgress6();
            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) { progress5 = progresValue; }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do something here,
                //if you want to do anything at the start of
                // touching the seekbar
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Display the value in textview
                resultTV6.setText(progress5 + "/" + seekBar.getMax());
                editor6.putInt(SHARED_PREFS6,seekBar.getProgress());
                editor6.commit();
                gv.setProgress6(progress5);
            }

        });
        //第七個變數
        skinSB7 = (SeekBar) findViewById(R.id.skinSB7);
        SharedPreferences sharedPreferences7 = getSharedPreferences(SHARED_PREFS7,MODE_PRIVATE);
        final SharedPreferences.Editor editor7 = sharedPreferences.edit();
        skinSB7.setProgress(sharedPreferences.getInt(SHARED_PREFS7,0));

        resultTV7 = (TextView) findViewById(R.id.resultTV7);
        resultTV7.setText(skinSB7.getProgress() + "/" + skinSB7.getMax());

        skinSB7.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            GlobalVariable gv = (GlobalVariable)getApplicationContext();

            int progress6 = gv.getProgress7();
            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) { progress6 = progresValue; }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do something here,
                //if you want to do anything at the start of
                // touching the seekbar
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Display the value in textview
                resultTV7.setText(progress6 + "/" + seekBar.getMax());
                editor7.putInt(SHARED_PREFS7,seekBar.getProgress());
                editor7.commit();
                gv.setProgress7(progress6);
            }
        }
        );

        skinSB8 = (SeekBar) findViewById(R.id.skinSB8);
        SharedPreferences sharedPreferences8 = getSharedPreferences(SHARED_PREFS8,MODE_PRIVATE);
        final SharedPreferences.Editor editor8 = sharedPreferences.edit();
        skinSB8.setProgress(sharedPreferences.getInt(SHARED_PREFS8,0));

        resultTV8 = (TextView) findViewById(R.id.resultTV8);
        resultTV8.setText(skinSB8.getProgress() + "/" + skinSB8.getMax());

        skinSB8.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
              GlobalVariable gv = (GlobalVariable)getApplicationContext();

           int progress7 = gv.getProgress8();
             @Override
              public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) { progress7 = progresValue; }
              @Override
              public void onStartTrackingTouch(SeekBar seekBar) {
                     // Do something here,
                     //if you want to do anything at the start of
                     // touching the seekbar
                                               }
              @Override
              public void onStopTrackingTouch(SeekBar seekBar) {
                   // Display the value in textview
                   resultTV8.setText(progress7 + "/" + seekBar.getMax());
                   editor8.putInt(SHARED_PREFS8,seekBar.getProgress());
                   editor8.commit();
                   gv.setProgress8(progress7);
                                               }
                                           }
        );

        //第九個變數
        skinSB9 = (SeekBar) findViewById(R.id.skinSB9);
        SharedPreferences sharedPreferences9 = getSharedPreferences(SHARED_PREFS9,MODE_PRIVATE);
        final SharedPreferences.Editor editor9 = sharedPreferences.edit();
        skinSB9.setProgress(sharedPreferences.getInt(SHARED_PREFS9,0));

        resultTV9 = (TextView) findViewById(R.id.resultTV10);
        resultTV9.setText(skinSB9.getProgress() + "/" + skinSB9.getMax());

        skinSB9.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
              GlobalVariable gv = (GlobalVariable)getApplicationContext();

              int progress8 = gv.getProgress9();
              @Override
              public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) { progress8 = progresValue; }
              @Override
              public void onStartTrackingTouch(SeekBar seekBar) {
              // Do something here,
              //if you want to do anything at the start of
              // touching the seekbar
              }
              @Override
              public void onStopTrackingTouch(SeekBar seekBar) {
        //      // Display the value in textview
              resultTV9.setText(progress8 + "/" + seekBar.getMax());
              editor9.putInt(SHARED_PREFS8,seekBar.getProgress());
              editor9.commit();
              gv.setProgress9(progress8);
               }}
          );

        //spinner下拉選單
        skinSP1 = (Spinner)findViewById(R.id.skinSP1);
        SharedPreferences sharedPreferences11 = getSharedPreferences(SHARED_PREFS11, MODE_PRIVATE);
        final SharedPreferences.Editor editor11 = sharedPreferences11.edit();
        final int Selection1 = sharedPreferences11.getInt("Skin1",0);
        final GlobalVariable gv = (GlobalVariable)getApplicationContext();
        sk1 = (String) skinSP1.getSelectedItem();;
        final String[] product = {"全面修復霜","溫泉舒緩噴霧","c10肌光活膚精華","淨透煥膚極效精華","毛孔緊緻控油精華","淨痘無暇極致精華"};
        final ArrayAdapter<String> productList1 = new ArrayAdapter<>(MainActivity5.this,
                android.R.layout.simple_spinner_dropdown_item, product);
        skinSP1.setAdapter(productList1);
        skinSP1.setSelection(Selection1);
        skinSP1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editor11.putInt("skin1",position).commit();
                sk1 = (String) skinSP1.getSelectedItem();
                gv.setSkin1(sk1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        skinSP2 = (Spinner)findViewById(R.id.skinSP2);
        SharedPreferences sharedPreferences22 = getSharedPreferences(SHARED_PREFS22, MODE_PRIVATE);
        final SharedPreferences.Editor editor22 = sharedPreferences22.edit();
        final int skin2 = sharedPreferences22.getInt("skin2",0);

        sk2 = (String) skinSP2.getSelectedItem();;
        final String[] product2 = {"全面修復霜","溫泉舒緩噴霧","c10肌光活膚精華","淨透煥膚極效精華","毛孔緊緻控油精華","淨痘無暇極致精華"};
        final ArrayAdapter<String> productList2 = new ArrayAdapter<>(MainActivity5.this,
                android.R.layout.simple_spinner_dropdown_item, product2);
        skinSP2.setAdapter(productList2);
        skinSP2.setSelection(skin2);
        skinSP2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editor22.putInt("skin2",position).commit();
                sk2 = (String) skinSP2.getSelectedItem();
                gv.setSkin2(sk2);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        skinSP3 = (Spinner)findViewById(R.id.skinSP3);
        SharedPreferences sharedPreferences33 = getSharedPreferences(SHARED_PREFS33, MODE_PRIVATE);
        final SharedPreferences.Editor editor33 = sharedPreferences33.edit();
        final int skin3 = sharedPreferences33.getInt("skin3",0);
        sk3 = (String) skinSP3.getSelectedItem();;

        final String[] product3 = {"全面修復霜","溫泉舒緩噴霧","c10肌光活膚精華","淨透煥膚極效精華","毛孔緊緻控油精華","淨痘無暇極致精華"};
        final ArrayAdapter<String> productList3 = new ArrayAdapter<>(MainActivity5.this,
                android.R.layout.simple_spinner_dropdown_item, product3);
        skinSP3.setAdapter(productList3);
        skinSP3.setSelection(skin3);
        skinSP3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editor33.putInt("skin3",position).commit();
                sk3 = (String) skinSP3.getSelectedItem();
                gv.setSkin3(sk3);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        skinSP4 = (Spinner)findViewById(R.id.skinSP4);
        SharedPreferences sharedPreferences44 = getSharedPreferences(SHARED_PREFS44, MODE_PRIVATE);
        final SharedPreferences.Editor editor44 = sharedPreferences44.edit();
        final int Selection4 = sharedPreferences44.getInt("Selection4",0);
        sk4 = (String) skinSP4.getSelectedItem();

        final String[] product4 = {"全面修復霜","溫泉舒緩噴霧","c10肌光活膚精華","淨透煥膚極效精華","毛孔緊緻控油精華","淨痘無暇極致精華"};
        final ArrayAdapter<String> productList4 = new ArrayAdapter<>(MainActivity5.this,
                android.R.layout.simple_spinner_dropdown_item, product4);
        skinSP4.setAdapter(productList4);
        skinSP4.setSelection(Selection4);
        skinSP4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editor44.putInt("Selection4",position).commit();
                sk4 = (String) skinSP4.getSelectedItem();
                gv.setSkin4(sk4);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        skinSP5 = (Spinner)findViewById(R.id.skinSP5);
        SharedPreferences sharedPreferences55 = getSharedPreferences(SHARED_PREFS55, MODE_PRIVATE);
        final SharedPreferences.Editor editor55 = sharedPreferences55.edit();
        final int Selection5 = sharedPreferences55.getInt("Selection5",0);
        sk5 = (String) skinSP5.getSelectedItem();

        final String[] product5 = {"全面修復霜","溫泉舒緩噴霧","c10肌光活膚精華","淨透煥膚極效精華","毛孔緊緻控油精華","淨痘無暇極致精華"};
        final ArrayAdapter<String> productList5 = new ArrayAdapter<>(MainActivity5.this,
                android.R.layout.simple_spinner_dropdown_item, product5);
        skinSP5.setAdapter(productList5);
        skinSP5.setSelection(Selection5);
        skinSP5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editor55.putInt("Selection5",position).commit();
                sk5 = (String) skinSP5.getSelectedItem();
                gv.setSkin5(sk5);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        skinSP6 = (Spinner)findViewById(R.id.skinSP6);
        SharedPreferences sharedPreferences66 = getSharedPreferences(SHARED_PREFS66, MODE_PRIVATE);
        final SharedPreferences.Editor editor66 = sharedPreferences66.edit();
        final int Selection6 = sharedPreferences66.getInt("Selection6",0);
        sk6 = (String) skinSP6.getSelectedItem();

        final String[] product6 = {"全面修復霜","溫泉舒緩噴霧","c10肌光活膚精華","淨透煥膚極效精華","毛孔緊緻控油精華","淨痘無暇極致精華"};
        final ArrayAdapter<String> productList6 = new ArrayAdapter<>(MainActivity5.this,
                android.R.layout.simple_spinner_dropdown_item, product6);
        skinSP6.setAdapter(productList6);
        skinSP6.setSelection(Selection6);
        skinSP6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editor66.putInt("Selection6",position).commit();
                sk6 = (String) skinSP6.getSelectedItem();
                gv.setSkin6(sk6);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        skinSP7 = (Spinner)findViewById(R.id.skinSP7);
        SharedPreferences sharedPreferences77 = getSharedPreferences(SHARED_PREFS77, MODE_PRIVATE);
        final SharedPreferences.Editor editor77 = sharedPreferences77.edit();
        final int Selection7 = sharedPreferences77.getInt("Selection7",0);
        sk7 = (String) skinSP7.getSelectedItem();

        final String[] product7 = {"全面修復霜","溫泉舒緩噴霧","c10肌光活膚精華","淨透煥膚極效精華","毛孔緊緻控油精華","淨痘無暇極致精華"};
        final ArrayAdapter<String> productList7 = new ArrayAdapter<>(MainActivity5.this,
                android.R.layout.simple_spinner_dropdown_item, product7);
        skinSP7.setAdapter(productList7);
        skinSP7.setSelection(Selection7);
        skinSP7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editor77.putInt("Selection7",position).commit();
                sk7 = (String) skinSP7.getSelectedItem();
                gv.setSkin7(sk7);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        skinSP8 = (Spinner)findViewById(R.id.skinSP8);
        SharedPreferences sharedPreferences88 = getSharedPreferences(SHARED_PREFS88, MODE_PRIVATE);
        final SharedPreferences.Editor editor88 = sharedPreferences88.edit();
        final int Selection8 = sharedPreferences88.getInt("Selection8",0);
        sk8 = (String) skinSP8.getSelectedItem();

        final String[] product8 = {"全面修復霜","溫泉舒緩噴霧","c10肌光活膚精華","淨透煥膚極效精華","毛孔緊緻控油精華","淨痘無暇極致精華"};
        final ArrayAdapter<String> productList8 = new ArrayAdapter<>(MainActivity5.this,
                android.R.layout.simple_spinner_dropdown_item, product8);
        skinSP8.setAdapter(productList8);
        skinSP8.setSelection(Selection8);
        skinSP8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editor88.putInt("Selection8",position).commit();
                sk8 = (String) skinSP8.getSelectedItem();
                gv.setSkin8(sk8);


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        skinSP9 = (Spinner)findViewById(R.id.skinSP9);
        SharedPreferences sharedPreferences99 = getSharedPreferences(SHARED_PREFS99, MODE_PRIVATE);
        final SharedPreferences.Editor editor99 = sharedPreferences99.edit();
        final int Selection9 = sharedPreferences99.getInt("Selection9",0);
        sk9 = (String) skinSP9.getSelectedItem();

        final String[] product9 = {"全面修復霜","溫泉舒緩噴霧","c10肌光活膚精華","淨透煥膚極效精華","毛孔緊緻控油精華","淨痘無暇極致精華"};
        final ArrayAdapter<String> productList9 = new ArrayAdapter<>(MainActivity5.this,
                android.R.layout.simple_spinner_dropdown_item, product9);
        skinSP9.setAdapter(productList9);
        skinSP9.setSelection(Selection9);
        skinSP9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editor99.putInt("Selection9",position).commit();
                sk9 = (String) skinSP9.getSelectedItem();
                gv.setSkin9(sk9);


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });





        InitTextWatcher();


        Button page5BTN = (Button) findViewById(R.id.page5BTN);
        page5BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity5.this, MainActivity2.class);
                startActivity(intent);

            }
        });

        Button button88 = (Button) findViewById(R.id.button88);
        button88.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity5.this, MainActivity2.class);
                startActivity(intent);

            }
        });

    }

    private void InitTextWatcher() {
        // 建立文字監聽
        edit1 = (EditText) findViewById(R.id.note1);edit2 = (EditText) findViewById(R.id.note2);
        edit3 = (EditText) findViewById(R.id.note3);edit4 = (EditText) findViewById(R.id.note4);
        edit5 = (EditText) findViewById(R.id.note5);edit6 = (EditText) findViewById(R.id.note6);
        edit7 = (EditText) findViewById(R.id.note7);edit8 = (EditText) findViewById(R.id.note8);
        edit9 = (EditText) findViewById(R.id.note9);
        String ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8,ed9;


        GlobalVariable gv = (GlobalVariable)getApplicationContext();
        TextWatcher mTextWatcher = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

        };

        // 加入文字監聽
        edit1.addTextChangedListener(mTextWatcher);edit2.addTextChangedListener(mTextWatcher);edit3.addTextChangedListener(mTextWatcher);
        edit4.addTextChangedListener(mTextWatcher);edit5.addTextChangedListener(mTextWatcher);edit6.addTextChangedListener(mTextWatcher);
        edit7.addTextChangedListener(mTextWatcher);edit8.addTextChangedListener(mTextWatcher);edit9.addTextChangedListener(mTextWatcher);

        ed1=edit1.getText().toString();ed2=edit2.getText().toString();ed3=edit3.getText().toString();
        ed4=edit4.getText().toString();ed5=edit5.getText().toString();ed6=edit6.getText().toString();
        ed7=edit7.getText().toString();ed8=edit8.getText().toString();ed9=edit9.getText().toString();

        gv.setEdit1(ed1);gv.setEdit2(ed2);gv.setEdit3(ed3);gv.setEdit4(ed4);gv.setEdit5(ed5);
        gv.setEdit6(ed6);gv.setEdit7(ed7);gv.setEdit8(ed8);gv.setEdit9(ed9);
    }


}
