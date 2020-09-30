package com.example.fetchrewards;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ViewHolder>{
    private List<Item> itemList;
    private MainActivity mainActivity;

    public ItemAdapter(List<Item> itemList, MainActivity ma){
        this.itemList = itemList;
        mainActivity = ma;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setup, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Item item = itemList.get(position);
        holder.name.setText("Name: " + item.getName());
        holder.id.setText("ID: " + item.getId());
        holder.listId.setText("ListID: " + item.getListId());
    }

    @Override
    public int getItemCount(){
        return itemList.size();
    }
}
