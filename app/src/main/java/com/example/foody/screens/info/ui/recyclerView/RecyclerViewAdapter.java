package com.example.foody.screens.info.ui.recyclerView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foody.R;


import java.util.List;

public class RecyclerViewAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<MyItem> itemList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<MyItem> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyItem item = itemList.get(position);

        // Bind data to views
        Glide.with(context).load("https://www.themealdb.com/images/ingredients/"+item.getTitle()+"-Small.png").into(holder.imageView);

        holder.textViewTitle.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewTitle;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            cardView = itemView.findViewById(R.id.ingredientCard);
        }
    }
}