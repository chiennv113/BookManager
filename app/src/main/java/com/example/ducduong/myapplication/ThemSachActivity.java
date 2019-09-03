package com.example.ducduong.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ducduong.myapplication.dao.SachDAO;
import com.example.ducduong.myapplication.dao.TheLoaiDAO;
import com.example.ducduong.myapplication.model.Sach;
import com.example.ducduong.myapplication.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class ThemSachActivity extends AppCompatActivity {
    SachDAO sachDAO;
    TheLoaiDAO theLoaiDAO;
    Spinner spnTheLoai;
    EditText edMaSach, edTenSach, edNXB, edTacGia, edGiaBia, edSoLuong;
    String maTheLoai = "";
    List<TheLoai> listTheLoai = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themsach_activity);
        setTitle("THÊM SÁCH");
       // spnTheLoai = (Spinner) findViewById(R.id.spnTheLoai);
//      getTheLoai();
        edMaSach = (EditText) findViewById(R.id.edMaSach);
        edTenSach = (EditText) findViewById(R.id.edTenSach);
        edNXB = (EditText) findViewById(R.id.edNXB);
        edTacGia = (EditText) findViewById(R.id.edTacGia);
        edGiaBia = (EditText) findViewById(R.id.edGiaBia);
        edSoLuong = (EditText) findViewById(R.id.edSoLuong);
        sachDAO = new SachDAO(ThemSachActivity.this);
        //
//        spnTheLoai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                maTheLoai = listTheLoai.get(spnTheLoai.getSelectedItemPosition()).getMaTheLoai();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
        //load data into form
        Intent in = getIntent();
        Bundle b = in.getExtras();
        if (b != null) {
            edMaSach.setText(b.getString("MASACH"));
            String maTheLoai = b.getString("MATHELOAI");
            edTenSach.setText(b.getString("TENSACH"));
            edNXB.setText(b.getString("NXB"));
            edTacGia.setText(b.getString("TACGIA"));
            edGiaBia.setText(b.getString("GIABIA"));
            edSoLuong.setText(b.getString("SOLUONG"));
            spnTheLoai.setSelection(checkPositionTheLoai(maTheLoai));
        }
    }

    public void showSpinner(View view) {
        sachDAO = new SachDAO(ThemSachActivity.this);
        sachDAO.getAllSach();
    }

    public void getTheLoai() {
        theLoaiDAO = new TheLoaiDAO(ThemSachActivity.this);
        listTheLoai = theLoaiDAO.getAllTheLoai();
        ArrayAdapter<TheLoai> dataAdapter = new ArrayAdapter<TheLoai>(this,
                android.R.layout.simple_spinner_item, listTheLoai);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnTheLoai.setAdapter(dataAdapter);
    }

    public void addBook(View view) {

        Sach sach = new
                Sach(edMaSach.getText().toString(), maTheLoai, edTenSach.getText().toString(),
                edTacGia.getText().toString(), edNXB.getText().toString(),

                Double.parseDouble(edGiaBia.getText().toString()), Integer.parseInt(edSoLuong.getText
                ().toString()));

        try {
            if (sachDAO.inserSach(sach) > 0) {
                Toast.makeText(getApplicationContext(), "Thêm thành công",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Thêm thất bại",
                        Toast.LENGTH_SHORT).show();
            }
        } catch (Exception ex) {
            Log.e("Error", ex.toString());
        }
    }

    public void showBook(View view) {
      Intent intent=new Intent(ThemSachActivity.this,Sach_activity.class);
      startActivity(intent);
    }

    public int checkPositionTheLoai(String strTheLoai) {
        for (int i = 0; i < listTheLoai.size(); i++) {
            if (strTheLoai.equals(listTheLoai.get(i).getMaTheLoai())) {
                return i;
            }
        }
        return 0;
    }

    public void back(View view) {
        finish();
    }
}




