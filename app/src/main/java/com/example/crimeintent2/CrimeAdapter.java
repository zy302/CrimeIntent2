package com.example.crimeintent2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.crimeintent2.databinding.ItemCrimeBinding;

import java.util.List;

public class CrimeAdapter extends RecyclerView.Adapter<CrimeAdapter.ViewHolder> {
    private View.OnClickListener onClickListener;
    private int currentIndex =0;
    private List<Crime> crimes;

    public CrimeAdapter(List<Crime> crimes) {
        this.crimes = crimes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCrimeBinding binding=ItemCrimeBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final Crime crime=crimes.get(position);
            holder.binding.bigTitle.setText(crime.getBigtitle());
            holder.binding.Date.setText(crime.getDate());
            if (crime.isSolved()){
                holder.binding.imageView.setVisibility(View.VISIBLE);
            }else {
                holder.binding.imageView.setVisibility(View.INVISIBLE);

            }
            holder.itemView.setSelected(currentIndex==position);

    }

    @Override
    public int getItemCount() {
        return crimes.size();
    }
    public void setCurrentIndex(int position){
        notifyItemChanged(currentIndex);
        notifyItemChanged(position);
        this.currentIndex=position;
    }
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
    protected class ViewHolder extends RecyclerView.ViewHolder{
        ItemCrimeBinding binding;
        public ViewHolder(@NonNull ItemCrimeBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
            this.itemView.setTag(this);
            this.itemView.setOnClickListener(onClickListener);
        }
    }
}
