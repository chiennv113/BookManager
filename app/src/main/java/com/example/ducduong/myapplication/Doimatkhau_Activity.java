package com.example.ducduong.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Doimatkhau_Activity extends AppCompatActivity {

    private EditText edtuses;
    private EditText edtpass;
    private EditText edtrepass;
    private Button btnLuu;
    private Button btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doimatkhau_);
        initView();
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        edtuses = (EditText) findViewById(R.id.edtuses);
        edtpass = (EditText) findViewById(R.id.edtpass);
        edtrepass = (EditText) findViewById(R.id.edtrepass);
        btnLuu = (Button) findViewById(R.id.btn_luu);
        btnHuy = (Button) findViewById(R.id.btn_huy);
    }
}
