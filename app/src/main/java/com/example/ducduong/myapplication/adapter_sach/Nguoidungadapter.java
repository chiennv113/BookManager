package com.example.ducduong.myapplication.adapter_sach;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ducduong.myapplication.R;
import com.example.ducduong.myapplication.database.DatabaseHelper;
import com.example.ducduong.myapplication.model.User;

import java.util.List;

public class Nguoidungadapter extends BaseAdapter {
    private List<User> userList;
    private Context context;
    private DatabaseHelper databaseHelper;
    private User user;

    public Nguoidungadapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.itemnguoidung, parent, false);
            viewHolder.tvname = convertView.findViewById(R.id.tvname2);
            viewHolder.tvphone = convertView.findViewById(R.id.tvdiachi2);
            viewHolder.img = convertView.findViewById(R.id.delete);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.tvname.setText("SDT:  "+userList.get(position).getName());
        viewHolder.tvphone.setText("Họ tên:  "+userList.get(position).getPassword());
//        viewHolder.img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        return convertView;
    }
    class ViewHolder{
        private TextView tvname;
        private TextView tvphone;
        private ImageView img;
    }}
