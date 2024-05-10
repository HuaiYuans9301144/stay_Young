package com.example.stayyoung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    SharedPreferences Select;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Spinner spinner1 = (Spinner)findViewById(R.id.spinner);

        final String[] brand = {"LA ROCHE POSAY理膚寶水"};
        ArrayAdapter<String> brandList = new ArrayAdapter<>(MainActivity4.this,
                android.R.layout.simple_spinner_dropdown_item,
                brand);
        spinner1.setAdapter(brandList);


        final Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
        Select = getSharedPreferences("Selection", Context.MODE_PRIVATE);
        editor = Select.edit();
        final int ProductSelection = Select.getInt("ProductSelection",0);

        final String[] product1 = {"無","防曬產品", "一般化妝產品(具防曬系數)", "一般化妝產品(不具防曬系數)"};
        final ArrayAdapter<String> productList = new ArrayAdapter<>(MainActivity4.this,
                android.R.layout.simple_spinner_dropdown_item,
                product1);
        spinner2.setAdapter(productList);
        spinner2.setSelection(ProductSelection);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editor.putInt("ProductSelection",position).commit();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        Button page4BTN = (Button) findViewById(R.id.page4BTN);
        page4BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity4.this , MainActivity2.class);
                startActivity(intent);
                Toast.makeText(MainActivity4.this,"已儲存",Toast.LENGTH_SHORT).show();
            }
        });
        Button button83 = (Button) findViewById(R.id.button83);
        button83.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity4.this, MainActivity3.class);
                startActivity(intent);
            }
        });

    }
}
