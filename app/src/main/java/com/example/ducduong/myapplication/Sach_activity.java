package com.example.ducduong.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.ducduong.myapplication.adapter_sach.BookAdapter;
import com.example.ducduong.myapplication.dao.SachDAO;
import com.example.ducduong.myapplication.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class Sach_activity extends AppCompatActivity {
    public static List<Sach> dsSach = new ArrayList<>();
    ListView lvBook;
    BookAdapter adapter = null;
    SachDAO sachDAO;
    private Button themsach;
    private Toolbar toolbar;
    private ImageView menu;
    private LinearLayout ln;
    private EditText edSearchBook;
    private Button btnTim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach__recycelview);
        lvBook = (ListView) findViewById(R.id.lvBook);
        sachDAO = new SachDAO(Sach_activity.this);
//        themsach.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Sach_activity.this, ThemSachActivity.class);
//                startActivity(intent);
//            }
//        });
        dsSach = sachDAO.getAllSach();
        adapter = new BookAdapter(this, dsSach);
        lvBook.setAdapter(adapter);
        lvBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Sach sach = (Sach) parent.getItemAtPosition(position);
                Intent intent = new
                        Intent(Sach_activity.this, ThemSachActivity.class);
                Bundle b = new Bundle();
                b.putString("MASACH", sach.getMaSach());
                b.putString("MATHELOAI", sach.getMaTheLoai());
                b.putString("TENSACH", sach.getTenSach());
                b.putString("TACGIA", sach.getTacGia());
                b.putString("NXB", sach.getNXB());
                b.putString("GIABIA", String.valueOf(sach.getGiaBia()));
                b.putString("SOLUONG", String.valueOf(sach.getSoLuong()));
                intent.putExtras(b);
                startActivity(intent);
            }
        });
        // TextFilter
        lvBook.setTextFilterEnabled(true);
        EditText edSeach = (EditText) findViewById(R.id.edSearchBook);
        edSeach.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int
                    count) {
                System.out.println("Text [" + s + "] - Start [" + start + "] - Before[" + before + "] - Count[" + count + "]");
                if (count < before) {
                    adapter.resetData();
                }
                adapter.getFilter().filter(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        initView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_book, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Intent intent = new
                        Intent(Sach_activity.this, ThemSachActivity.class);
                startActivity(intent);
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        themsach = (Button) findViewById(R.id.themsach);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        menu = (ImageView) findViewById(R.id.menu);
        ln = (LinearLayout) findViewById(R.id.ln);
        edSearchBook = (EditText) findViewById(R.id.edSearchBook);
        btnTim = (Button) findViewById(R.id.btnTim);
    }

    public void back(View view) {
        Intent intent=new Intent(Sach_activity.this,Home_activity.class);
        startActivity(intent);
    }

    public void themsach(View view) {
        Intent intent=new Intent(Sach_activity.this,ThemSachActivity.class);
        startActivity(intent);
    }
}




