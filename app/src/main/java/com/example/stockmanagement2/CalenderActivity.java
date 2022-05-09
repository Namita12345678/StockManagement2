
package com.example.stockmanagement2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import org.jetbrains.annotations.Nullable;


class CalendarActivity extends Dashboard {

        private  static final String TAG = "CalendarActivity";
        private CalendarView mCalendarView;
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calender_layout);
            mCalendarView = (CalendarView) findViewById(R.id.calendarView);
            mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                @Override
                public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
                    String date = year + "/" + month + "/"+ dayOfMonth ;
                    Log.d(TAG, "onSelectedDayChange: yyyy/mm/dd:" + date);
                    Intent intent = new Intent(CalendarActivity.this, Dashboard.class);
                    intent.putExtra("date",date);
                    startActivity(intent);

                }
            });
        }
    }

