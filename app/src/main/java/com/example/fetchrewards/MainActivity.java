package com.example.fetchrewards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Item> itemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private MainActivity ma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        itemAdapter = new ItemAdapter(itemList, ma);
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemList.clear();
        itemAdapter.notifyDataSetChanged();
        new ItemAPIAsyncTask(this).execute();


    }

    protected void setItems(ArrayList<Item> list){
        ArrayList<Item> newList = organizeList(list);
        itemList.clear();
        itemList.addAll(newList);
        itemAdapter.notifyDataSetChanged();
    }

    public ArrayList<Item> organizeList(ArrayList<Item> list){
        ArrayList<Item> orgList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getName().compareTo("null") < 0 && list.get(i).getName().compareTo("") > 0){
                orgList.add(list.get(i));
            }
        }
        for (int j = 0; j < orgList.size(); j++){
            for (int k = j + 1; k < orgList.size(); k++){
                if (orgList.get(j).getListId().compareTo(orgList.get(k).getListId()) > 0){
                    Item tmp = orgList.get(k);
                    orgList.set(k, orgList.get(j));
                    orgList.set(j, tmp);
                }
            }
        }
        for (int l = 0; l < orgList.size(); l++){
            for (int m = l + 1; m < orgList.size(); m++){
                if (Integer.parseInt(orgList.get(l).getId()) > Integer.parseInt(orgList.get(m).getId()) && orgList.get(l).getListId().compareTo(orgList.get(m).getListId()) == 0){
                    Item tmp = orgList.get(l);
                    orgList.set(l, orgList.get(m));
                    orgList.set(m, tmp);
                }
            }
        }
        return orgList;
    }

    //public ArrayList<Item> sortList(ArrayList<Item> list){

    //}
}
