package com.example.searchview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    static final String INPUT_FRAGMENT = "input";
    static final String RESULT_FRAGMENT = "result";

    String edit1Value;
    String edit2Value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 첫 화면으로 input 보여줌
        setFragment(INPUT_FRAGMENT, false);

        EdgeToEdge.enable(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //fragment를 전환하는 메서드
    public void setFragment(String name, boolean add) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // 이름 기준으로 분기
        switch (name) {
            case INPUT_FRAGMENT:
                InputFragment inputFragment = InputFragment.newInstance();
                fragmentTransaction.replace(R.id.fragmentContainerView, inputFragment);
                break;
            case RESULT_FRAGMENT:
                ResultFragment resultFragment = ResultFragment.newInstance();
                fragmentTransaction.replace(R.id.fragmentContainerView, resultFragment);
                break;
        }

        if (add) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }
}