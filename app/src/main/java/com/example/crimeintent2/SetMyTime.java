package com.example.crimeintent2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


import com.example.crimeintent2.databinding.DialogDatePickerBinding;

import java.util.Calendar;

public class SetMyTime extends DialogFragment {
    private DialogDatePickerBinding binding;
    String date;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogDatePickerBinding.inflate(inflater, container, false);
        binding.Date.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

                Calendar calendar = Calendar.getInstance();
                calendar.set(i, i1, i2);
                date = calendar.getTime().toString();
            }
        });
        binding.btnQueren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.getDate(date);
                Bundle bundle = new Bundle();
                bundle.putString("Time", date);
                getParentFragmentManager().setFragmentResult("key", bundle);
                SetMyTime.this.dismiss();

            }
        });
        binding.btnQuxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetMyTime.this.dismiss();
            }
        });


        return binding.getRoot();
    }

    private DateCallback callback;

    public interface DateCallback {
        void getDate(String date);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof DateCallback) {
            this.callback = (DateCallback) context;
        } else {
            throw new ClassCastException(context + "未实现");
        }
    }

    @Override
    public void onStart() {
        WindowManager.LayoutParams attributes = requireDialog().getWindow().getAttributes();
        attributes.width = ViewGroup.LayoutParams.MATCH_PARENT;
        requireDialog().getWindow().setAttributes(attributes);
        super.onStart();
    }
}
