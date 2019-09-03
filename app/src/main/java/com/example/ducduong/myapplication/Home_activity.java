package com.example.ducduong.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Home_activity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView nvMain;
    ImageView menu,img_sach,imguser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giaodienchinh_);
        toolbar = findViewById(R.id.toolbar);
        menu=findViewById(R.id.menu);
        imguser=findViewById(R.id.imgnguoidung);
        img_sach=findViewById(R.id.imgsach);
        img_sach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home_activity.this,ThemSachActivity.class);
                startActivity(intent);
            }
        });
        imguser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Home_activity.this,User_activity.class);
                startActivity(intent);
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.START);
            }
        });

        drawerLayout = findViewById(R.id.drawerLayout);
        nvMain=findViewById(R.id.nvmenu);
        nvMain.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.itemHome:
                        Toast.makeText(Home_activity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.itemNews:
                        Toast.makeText(Home_activity.this, "Lịch Sử", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.itemdangxuat:
                        Toast.makeText(Home_activity.this, "Đăng Xuất", Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                    case R.id.itemdoimatkhau:
                        Intent intent=new Intent(Home_activity.this,Doimatkhau_Activity.class);
                        startActivity(intent);
                        break;
                    case R.id.itemSetting:
                        Toast.makeText(Home_activity.this, "Thoát", Toast.LENGTH_SHORT).show();
                        break;
                }
                drawerLayout.closeDrawer(Gravity.START);
                return false;
            }
        });


    }

    public void theloai(View view) {
        Intent intent=new Intent(Home_activity.this, ListTheLoaiActivity.class);
        startActivity(intent);
    }

    public void hoadon1(View view) {
        Intent intent=new Intent(Home_activity.this, HoaDonActivity.class);
        startActivity(intent);
    }
}

