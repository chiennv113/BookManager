package com.example.ducduong.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ducduong.myapplication.database.DatabaseHelper;
import com.example.ducduong.myapplication.model.User;

public class Them_user_activity extends AppCompatActivity {

    private Button btn_listUser, btn_adduser;
    private DatabaseHelper databaseHelper;
    private EditText addusername, addpassword, addname, addphone;
    private Button btnLuu1;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_user_activity);
        initView();

        databaseHelper = new DatabaseHelper(this);

back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Them_user_activity.this, User_activity.class);
        startActivity(intent);
    }
});
        btnLuu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(addusername.getText().toString(), addpassword.getText().toString(), addname.getText().toString(), addphone.getText().toString());
//                databaseHelper.insertUser(user);
                Toast.makeText(Them_user_activity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initView() {
        addusername = findViewById(R.id.edt_username);
        addpassword = findViewById(R.id.edt_pass);
        addname = findViewById(R.id.edt_user);
        addphone = findViewById(R.id.edt_phone);
        btnLuu1 = (Button) findViewById(R.id.btn_luu1);
        back = (ImageView) findViewById(R.id.back);
    }


}
