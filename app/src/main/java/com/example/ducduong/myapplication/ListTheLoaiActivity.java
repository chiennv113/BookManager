 package com.example.ducduong.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ducduong.myapplication.adapter_sach.TheLoaiAdapter;
import com.example.ducduong.myapplication.dao.TheLoaiDAO;
import com.example.ducduong.myapplication.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class ListTheLoaiActivity extends AppCompatActivity {
    public static List<TheLoai> dsTheLoai = new ArrayList<>();
    ListView lvTheLoai;
    TheLoaiAdapter adapter ;
    TheLoaiDAO theLoaiDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_the_loai);
        setTitle("THỂ LOẠI");
        lvTheLoai = (ListView) findViewById(R.id.lvTheLoai);
        registerForContextMenu(lvTheLoai);
        theLoaiDAO = new TheLoaiDAO(ListTheLoaiActivity.this);
        dsTheLoai = theLoaiDAO.getAllTheLoai();
        adapter = new TheLoaiAdapter(this, dsTheLoai);
        lvTheLoai.setAdapter(adapter);
        lvTheLoai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new
                        Intent(ListTheLoaiActivity.this,ThemTheLoai.class);
                Bundle b = new Bundle();
                b.putString("MATHELOAI", dsTheLoai.get(position).getMaTheLoai());
                b.putString("TENTHELOAI", dsTheLoai.get(position).getTenTheLoai());
                b.putString("MOTA", dsTheLoai.get(position).getMoTa());
                b.putString("VITRI",
                        String.valueOf(dsTheLoai.get(position).getViTri()));
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }

//    public void back(View view) {
//        Intent intent=new Intent(ListTheLoaiActivity.this,Home_activity.class);
//        startActivity(intent);
//
//
//        };
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_book, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.add:
                Intent intent = new
                        Intent(ListTheLoaiActivity.this,ThemTheLoai.class);
                startActivity(intent);
                return(true);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onResume() {
        super.onResume();
        dsTheLoai.clear();
       dsTheLoai = theLoaiDAO.getAllTheLoai();
        adapter.changeDataset(dsTheLoai);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
        menu.setHeaderTitle("Chọn thông tin");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.themtheloai:
                Intent intent1 = new
                        Intent(ListTheLoaiActivity.this,ThemTheLoai.class);
                startActivity(intent1);
                return(true);

        }
        return super.onContextItemSelected(item);

    }


    public void themtheloai(View view) {
        Intent intent=new Intent(ListTheLoaiActivity.this,ThemTheLoai.class);
        startActivity(intent);
    }
}
