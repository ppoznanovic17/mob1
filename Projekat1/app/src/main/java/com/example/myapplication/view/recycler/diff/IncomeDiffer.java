package com.example.myapplication.view.recycler.diff;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.myapplication.model.Transaction;

public class IncomeDiffer extends DiffUtil.ItemCallback<Transaction> {
    @Override
    public boolean areItemsTheSame(@NonNull Transaction oldItem, @NonNull Transaction newItem) {
        return oldItem.getUuid() == newItem.getUuid();
    }

    @Override
    public boolean areContentsTheSame(@NonNull Transaction oldItem, @NonNull Transaction newItem) {
        return oldItem.getTitle().equals(newItem.getTitle())
                && oldItem.getDescription().equals(newItem.getDescription())
                && oldItem.getType().equals(newItem.getType())
                && oldItem.getValue().equals(newItem.getValue());
    }
}
