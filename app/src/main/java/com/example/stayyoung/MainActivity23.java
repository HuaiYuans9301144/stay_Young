package com.example.stayyoung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity23 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main23);

        Button button84 = (Button) findViewById(R.id.button84);
        button84.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity23.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        Button button86 = (Button) findViewById(R.id.button86);
        button86.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity23.this, MainActivity5.class);
                startActivity(intent);
            }
        });
        Button button90 = (Button) findViewById(R.id.button90);
        button90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity23.this, MainActivity22.class);
                startActivity(intent);
            }
        });
        Button button95 = (Button) findViewById(R.id.button95);
        button95.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity23.this, MainActivity24.class);
                startActivity(intent);
            }
        });
        Button button91 = (Button) findViewById(R.id.button91);
        button91.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity23.this, MainActivity25.class);
                startActivity(intent);
            }
        });
        Button button93 = (Button) findViewById(R.id.button93);
        button93.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity23.this, MainActivity26.class);
                startActivity(intent);
            }
        });
        Button button92 = (Button) findViewById(R.id.button92);
        button92.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity23.this, MainActivity27.class);
                startActivity(intent);
            }
        });
        Button button94 = (Button) findViewById(R.id.button94);
        button94.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity23.this, MainActivity28.class);
                startActivity(intent);
            }
        });
    }
}