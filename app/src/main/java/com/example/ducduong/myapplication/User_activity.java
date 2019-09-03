package com.example.ducduong.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.ducduong.myapplication.adapter_sach.Nguoidungadapter;
import com.example.ducduong.myapplication.database.DatabaseHelper;

import java.util.List;

public class User_activity extends AppCompatActivity  {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private List<com.example.ducduong.myapplication.model.User> usersList;
    private Nguoidungadapter adapter;
    private Button btn_luu;
    private ListView listView;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        btn_luu=findViewById(R.id.btn_themsach);
        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(User_activity.this,Them_user_activity.class);
                startActivity(intent);
            }
        });
        databaseHelper=new DatabaseHelper(this);
        listView=findViewById(R.id.lv_user);
//        usersList=databaseHelper.getAllUsers();
        adapter=new Nguoidungadapter(usersList,this);
        listView.setAdapter(adapter);

    }
}