package com.example.crimeintent2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.crimeintent2.databinding.DialogDatePickerBinding;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DatePickerDialog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DatePickerDialog extends Fragment {
    DialogDatePickerBinding binding;
    String date;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public DatePickerDialog() {
        // Required empty public constructor
    }


    public static DatePickerDialog newInstance(String param1, String param2) {
        DatePickerDialog fragment = new DatePickerDialog();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
    //   binding=DialogDatePickerBinding.inflate(infla)
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DialogDatePickerBinding.inflate(inflater,container,false);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}