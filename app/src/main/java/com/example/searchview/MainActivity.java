package com.example.searchview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.searchview.databinding.ActivityMainBinding;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        ButtonClickListener1 buttonClickListener1 = new ButtonClickListener1();
        activityMainBinding.button2.setOnClickListener(buttonClickListener1);

        ButtonClickListener2 buttonClickListener2 = new ButtonClickListener2();
        activityMainBinding.button3.setOnClickListener(buttonClickListener2);

        CalendarListener1 calendarListener1 = new CalendarListener1();
        activityMainBinding.calendarView.setOnDateChangeListener(calendarListener1);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    class ButtonClickListener1 implements View.OnClickListener {

        // 날짜 설정
        @Override
        public void onClick(View v) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, 2022);
            calendar.set(Calendar.MONTH, 6);
            calendar.set(Calendar.DAY_OF_MONTH, 20);

            long date = calendar.getTimeInMillis();

            activityMainBinding.calendarView.setDate(date);
        }
    }

    class ButtonClickListener2 implements View.OnClickListener {

        // 날짜 가져오기
        @Override
        public void onClick(View v) {
            long date = activityMainBinding.calendarView.getDate();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(date);

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            activityMainBinding.textView4.setText(year + "/" + month + "/" + day);

        }
    }

    // 캘린더 날짜 선택했을때
    class CalendarListener1 implements CalendarView.OnDateChangeListener {

        @Override
        public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            long date = calendar.getTimeInMillis();
            activityMainBinding.calendarView.setDate(date);

            activityMainBinding.textView5.setText(year + "/" + (month + 1) + "/" + dayOfMonth);
        }
    }
}