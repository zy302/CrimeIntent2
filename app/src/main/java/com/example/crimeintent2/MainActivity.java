package com.example.crimeintent2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.crimeintent2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements  SetMyTime.DateCallback{

    ActivityMainBinding binding;
    private Crime currentCrime;
    private boolean isUpdate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetMyTime setMyTime = new SetMyTime();
                setMyTime.show(getSupportFragmentManager(), "设置时间");

            }
        });
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            currentCrime =(Crime)bundle.get("crime");
        }
        if(currentCrime!=null){
            isUpdate=true;
            binding.bigTitle.setText(currentCrime.getBigtitle());
            binding.Date.setText(currentCrime.getDate());
            binding.checkBox.setChecked(currentCrime.solved);
        }


    }


    @Override
    public void getDate(String date) {
        binding.Date.setText(date);
    }
}
