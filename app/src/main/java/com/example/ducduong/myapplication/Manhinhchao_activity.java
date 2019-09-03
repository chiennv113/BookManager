package com.example.ducduong.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Manhinhchao_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manchao_activity);



        Thread thread = new Thread() {

            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                } finally {
                    Intent a = new Intent(Manhinhchao_activity.this, Dangnhap_activity.class);
                    startActivity(a);
                }
            }
        };
        thread.start();

    }

    protected void onPause() {
        super.onPause();
        finish();
    }
    }

