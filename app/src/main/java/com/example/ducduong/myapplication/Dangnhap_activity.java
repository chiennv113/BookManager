package com.example.ducduong.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ducduong.myapplication.database.DatabaseHelper;
import com.example.ducduong.myapplication.model.User;

public class Dangnhap_activity extends AppCompatActivity {
    private Button btdn, brdk;
    private ImageView img;
    private EditText edtuses;
    private EditText edtpass;
    private CheckBox ckb;
    private TextView tv;
    private Button btdk;
    private DatabaseHelper databaseHelper;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btdn = findViewById(R.id.btdn);

        databaseHelper=new DatabaseHelper(this);

        initView();
        initActions();
//        databaseHelper=new DatabaseHelper(this);
//
//        User_activity user=new User_activity("admin","Duc Duong","123534676767","admin");

    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);
        edtuses = (EditText) findViewById(R.id.edtuses);
        edtpass = (EditText) findViewById(R.id.edtpass);
        ckb = (CheckBox) findViewById(R.id.ckb);
        tv = (TextView) findViewById(R.id.tv);
        btdk = (Button) findViewById(R.id.btdk);
    }

    public void initActions() {
        btdn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                        String userName = edtuses.getText().toString();
//                        String password = edtpass.getText().toString();
//
//                        if(edtuses.getText().toString().trim().equalsIgnoreCase("")){
//                            edtuses.setError("Không được để trống");
//                        }
//                        if(edtpass.getText().toString().trim().equalsIgnoreCase("")){
//                            edtpass.setError("Không được để trống");
//                        }else{
////                            User user = databaseHelper.getUser(userName);
//                            if(user == null){
//                                Toast.makeText(Dangnhap_activity.this, "Tên đăng nhập không đúng", Toast.LENGTH_SHORT).show();
//                            }else{
//                                String pass = user.getPassword();
//                                if(pass.equals(password)){
                                    Intent a = new Intent(Dangnhap_activity.this, Home_activity.class);
                                    startActivity(a);
//                                }else{
//                                    Toast.makeText(Dangnhap_activity.this, "Sai mật khẩu", Toast.LENGTH_SHORT).show();
//                                }
//                         }
//                        }
                    }
                });


    }
}
