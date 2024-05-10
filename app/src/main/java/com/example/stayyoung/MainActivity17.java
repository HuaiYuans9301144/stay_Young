package com.example.stayyoung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity17 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);
        Button button63 = (Button) findViewById(R.id.button63);
        button63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity17.this, MainActivity18.class);
                startActivity(intent);
            }
        });
        Button button64 = (Button) findViewById(R.id.button64);
        button64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity17.this, MainActivity19.class);
                startActivity(intent);
            }
        });
        Button button65 = (Button) findViewById(R.id.button65);
        button65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity17.this, MainActivity20.class);
                startActivity(intent);
            }
        });
        Button button66 = (Button) findViewById(R.id.button66);
        button66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity17.this, MainActivity21.class);
                startActivity(intent);
            }
        });
        Button button67 = (Button) findViewById(R.id.button67);
        button67.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity17.this, MainActivity7.class);
                startActivity(intent);
            }
        });
    }
}