package com.example.fetchrewards;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public TextView id;
    public TextView listId;

    public ViewHolder(View view){
        super(view);
        name = itemView.findViewById(R.id.itemName);
        id = itemView.findViewById(R.id.itemId);
        listId = itemView.findViewById(R.id.itemListId);
    }
}
