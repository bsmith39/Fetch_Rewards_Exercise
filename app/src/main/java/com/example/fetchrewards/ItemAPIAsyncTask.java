package com.example.fetchrewards;

import android.os.AsyncTask;
import android.net.Uri;
import android.util.Log;

import org.json.JSONObject;
import org.json.JSONArray;
import java.io.*;
import java.util.ArrayList;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ItemAPIAsyncTask extends AsyncTask<String, Void, String> {
    private MainActivity mainActivity;
    private ArrayList<Item> itemList = new ArrayList<>();
    private static final String itemUrl = "https://fetch-hiring.s3.amazonaws.com/hiring.json";
    private static final String TAG = "ItemAPIAsyncTask";

    public ItemAPIAsyncTask(MainActivity ma){
        mainActivity = ma;
    }

    @Override
    protected String doInBackground(String... strings){
        Uri.Builder builder = Uri.parse(itemUrl).buildUpon();
        String newUrl = builder.build().toString();

        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL url = new URL(newUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            inputStream.close();
            reader.close();
            return stringBuilder.toString();
        } catch (Exception e) {
            Log.e(TAG, "doInBackground", e);

        }
        return null;

    }

    private void parseJSON(String s){
        try {
            JSONArray jsonArray = new JSONArray(s);
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jItem = (JSONObject) jsonArray.get(i);
                Item item = new Item(jItem.getString("name"), jItem.getString("id"), jItem.getString("listId"));
                itemList.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onPostExecute(String list){
        parseJSON(list);
        mainActivity.setItems(itemList);
    }

}
