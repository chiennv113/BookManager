package com.example.ducduong.myapplication.model;

import android.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment {
    private int year, month, day;
    public DatePickerFragment() {
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
    }
}
