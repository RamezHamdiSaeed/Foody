package com.example.foody.screens.info.ui.recyclerView.Procedures;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foody.R;

import java.util.List;

public class ProceduresRecyclerViewAdapter extends RecyclerView.Adapter<ProceduresRecyclerViewAdapter.ViewHolder> {
    private List<Step> itemList;
    private Context context;

    public ProceduresRecyclerViewAdapter(Context context, List<Step> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Step item = itemList.get(position);

        // Bind data to views

        holder.textViewTitle.setText(item.getStep());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            cardView = itemView.findViewById(R.id.ingredientCard);
        }
    }
}