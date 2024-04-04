package com.example.searchview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.searchview.databinding.FragmentInputBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InputFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InputFragment extends Fragment {

    FragmentInputBinding fragmentInputBinding;
    MainActivity mainActivity;
    public static InputFragment newInstance() {
        InputFragment fragment = new InputFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mainActivity = (MainActivity) getActivity();
        fragmentInputBinding = FragmentInputBinding.inflate(inflater);

        InputButtonClickListener listener = new InputButtonClickListener();
        fragmentInputBinding.button.setOnClickListener(listener);

        return fragmentInputBinding.getRoot();
    }

    class InputButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            // 사용자 입력 내용 추출
            String str1 = fragmentInputBinding.editText.getText().toString();
            String str2 = fragmentInputBinding.editText2.getText().toString();

            mainActivity.edit1Value = str1;
            mainActivity.edit2Value = str2;

            //result로 교체
            mainActivity.setFragment(MainActivity.RESULT_FRAGMENT, true);
        }
    }
}