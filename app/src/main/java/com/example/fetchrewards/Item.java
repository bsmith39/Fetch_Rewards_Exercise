package com.example.fetchrewards;

public class Item {
    private String name;
    private String id;
    private String listId;

    public Item(){
        this.name = "";
        this.id = "";
        this.listId = "";
    }

    public Item(String name, String id, String listId){
        this.name = name;
        this.id = id;
        this.listId = listId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }
}
