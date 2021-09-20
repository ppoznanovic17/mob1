package com.example.myapplication.view.recycler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Transaction;

import java.util.function.Function;

public class IncomeTransactionAdapter extends ListAdapter<Transaction, IncomeTransactionAdapter.ViewHolder> {

    private final Function<Transaction, Void> onTransactionClicked;

    public IncomeTransactionAdapter(@NonNull DiffUtil.ItemCallback<Transaction> diffCallback, Function<Transaction, Void> onTransactionClicked) {
        super(diffCallback);
        this.onTransactionClicked = onTransactionClicked;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_prihod_list_item, parent, false);
        return new ViewHolder(view, parent.getContext(), position -> {
            Transaction t = getItem(position);
            onTransactionClicked.apply(t);
            return null;
        });
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Transaction t = getItem(position);
        holder.bind(t);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final Context context;

        public ViewHolder(@NonNull View itemView, Context context, Function<Integer, Void> onItemClicked) {
            super(itemView);
            this.context = context;
            itemView.setOnClickListener(v -> {
                if(getAdapterPosition() != RecyclerView.NO_POSITION) {
                    onItemClicked.apply(getAdapterPosition());
                }
            });
        }

        public void bind(Transaction t) {
            TextView transactionTitle = itemView.findViewById(R.id.incomeTitle);
            TextView transactionValue = itemView.findViewById(R.id.incomeValue);
            transactionTitle.setText(t.getTitle());
            transactionValue.setText(t.getValue().toString());

        }

    }
}
