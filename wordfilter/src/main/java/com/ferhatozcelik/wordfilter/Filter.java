package com.ferhatozcelik.wordfilter;


/// Ferhat ÖZÇELİK
/// https://ferhatozcelik.github.io/
import android.app.Activity;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Filter {
    private static String URL = "https://ferhatozcelik.github.io/wordfilter.json";
    RequestQueue queue;
    String wordlist;
    ArrayList list;
    String id;

    public void run(Activity context)
    {
        queue = NetworkController.getInstance(context).getRequestQueue();
        queue.add(new JsonObjectRequest(0,URL,null, new listener(),new error()));
        list = new ArrayList<String>();
    }
    private class listener implements Response.Listener<JSONObject> {
        @Override
        public void onResponse(JSONObject response) {

            try {
                JSONArray wordfilter = response.getJSONArray("wordfilter");

                for (int i = 0; i < wordfilter.length(); i++){
                 try {
                     list.clear();
                     JSONObject words = wordfilter.getJSONObject(i);
                     id =  words.getString("id");
                     wordlist = words.getString("word");
                     list.add(wordlist);
                     Log.d("WordList","word"+i+": "+ wordlist);

                 }catch (Exception e){
                 }
                }
            } catch (JSONException e) {


            }
        }
    }
    private class error implements Response.ErrorListener {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    }

    public String FilterGetString(String text,String alert){

        if (list.contains(text)){
            return alert;
        }else {
            return text;
        }
    }
    public Boolean FilterGetBoolean(String text){

        if (list.contains(text)){
            return false;
        }else {
            return true;
        }
    }


}
