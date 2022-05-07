package com.example.crimeintent2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.crimeintent2.databinding.ActivityMain2Binding;
import com.example.crimeintent2.databinding.ToolbarLayoutBinding;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;
    private ToolbarLayoutBinding toolBarBing;
    private ArrayList<Crime> crimes;
    static Calendar calendar;
    int currentIndex=0;
    private CrimeAdapter adapter;
    private Crime currentCrime;
    String date;
    private ActivityResultLauncher<Intent> launcher =registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    // changeDate(result);

                }
            }
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toolBarBing= ToolbarLayoutBinding.bind(binding.getRoot());
        setSupportActionBar(toolBarBing.toolbar);

        calendar=Calendar.getInstance();
        calendar.set(2000,1,1);
        date = calendar.getTime().toString();

        initDate();

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new CrimeAdapter(crimes);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CrimeAdapter.ViewHolder viewHolder=(CrimeAdapter.ViewHolder)view.getTag();
                currentIndex=viewHolder.getAdapterPosition();
                adapter.setCurrentIndex(currentIndex);
                currentCrime=crimes.get(currentIndex);

                final Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                final  Bundle bundle=new Bundle();
                bundle.putSerializable("crime",currentCrime);
                intent.putExtras(bundle);
                launcher.launch(intent);
            }
        });
        binding.recyclerview.setAdapter(adapter);

    }

    private void initDate() {
        crimes = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            Crime crime=new Crime("陋习"+i,true,"陋习"+i,date) ;
            crimes.add(crime);
        }
        for (int i = 1; i < 5; i++) {
            Crime crime=new Crime("陋习"+(i+5),false,"陋习"+(i+5),date) ;
            crimes.add(crime);
        }

    }
}
