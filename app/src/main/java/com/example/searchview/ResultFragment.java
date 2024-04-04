package com.example.searchview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.searchview.databinding.FragmentResultBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResultFragment extends Fragment {


    FragmentResultBinding fragmentResultBinding;
    MainActivity mainActivity;

    public static ResultFragment newInstance() {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mainActivity = (MainActivity) getActivity();
        fragmentResultBinding =  FragmentResultBinding.inflate(inflater);

        fragmentResultBinding.textView.setText(mainActivity.edit1Value);
        fragmentResultBinding.textView2.setText(mainActivity.edit2Value);

        return fragmentResultBinding.getRoot();
    }
}