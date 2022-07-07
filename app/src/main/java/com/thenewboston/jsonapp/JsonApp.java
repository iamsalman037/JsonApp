package com.thenewboston.jsonapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by SAM on 3/18/2018.
 */

public class JsonApp extends AppCompatActivity {
    String url = "https://api.androidhive.info/contacts/";
    ListView lv;
    private ArrayList<JSonModel> jSonModelArrayList;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        lv = findViewById(R.id.lv);

        jSonModelArrayList = new ArrayList<JSonModel>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray jsonArray = jsonObject.getJSONArray("contacts");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonobj = jsonArray.getJSONObject(i);
                        String ids = jsonobj.getString("id");
                        String offer_name = jsonobj.getString("name");
                        String offer_type = jsonobj.getString("email");
                        String addr= jsonobj.getString("address");
                        String gend= jsonobj.getString("gender");

                        jSonModelArrayList.add(new JSonModel(offer_name, offer_type,addr,gend));

                    }
                    customAdapter = new CustomAdapter(jSonModelArrayList, JsonApp.this);

                    lv.setAdapter(customAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
