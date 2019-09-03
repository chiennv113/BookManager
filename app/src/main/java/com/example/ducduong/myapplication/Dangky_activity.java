package com.example.ducduong.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Dangky_activity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView menu;
    private EditText edtUsername;
    private EditText edtPass;
    private EditText edtRepass;
    private EditText edtEmail;
    private Button luu;
    private Button huy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        initView();
        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        menu = (ImageView) findViewById(R.id.menu);
        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPass = (EditText) findViewById(R.id.edt_pass);
        edtRepass = (EditText) findViewById(R.id.edt_Repass);
        edtEmail = (EditText) findViewById(R.id.edt_email);
        luu = (Button) findViewById(R.id.luu);
        huy = (Button) findViewById(R.id.huy);
    }
}
