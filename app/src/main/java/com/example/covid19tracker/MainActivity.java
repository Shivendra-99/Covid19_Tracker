package com.example.covid19tracker;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity implements CustomAdapter.OnItemClickListener {
     public static final String acti="action";
    public static final String confi="config";
    public static final String dead="death";
    public static final String state="state";
    public static final String reco="recovered";
    TextView conf,act,rec,dec,time;
    ArrayList<StatewiseItem> arrayList;
    CustomAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conf=(TextView)findViewById(R.id.conf);
        act=(TextView)findViewById(R.id.act);
        rec=(TextView)findViewById(R.id.rec);
        dec=(TextView)findViewById(R.id.decs);
        time=(TextView)findViewById(R.id.timeUpdate);
        recyclerView=findViewById(R.id.recyle);
        arrayList=new ArrayList<>();
        loadData();
        loaddata1();
    }
    private void loaddata1() {
        RequestQueue queue= Volley.newRequestQueue(this);
        String url="https://api.covid19india.org/data.json";
        final JsonObjectRequest json=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray=response.getJSONArray("statewise");
                    JSONObject ni=jsonArray.getJSONObject(0);
                    conf.setText(ni.getString("confirmed").toString());
                    act.setText(ni.getString("active").toString());
                    rec.setText(ni.getString("recovered").toString());
                    dec.setText(ni.getString("deaths").toString());
                    time.setText(ni.getString("lastupdatedtime").toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(json);
    }
    public void loadData() {
        RequestQueue queue= Volley.newRequestQueue(this);
        String url="https://api.covid19india.org/data.json";
         JsonObjectRequest json=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
             @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray=response.getJSONArray("statewise");

                    for(int i=1;i<jsonArray.length();i++)
                    {
                        JSONObject num=jsonArray.getJSONObject(i);
                            StatewiseItem a = new StatewiseItem();
                            a.setActive(num.getString("active").toString());
                            a.setConfirmed(num.getString("confirmed").toString());
                            a.setDeaths(num.getString("deaths").toString());
                            a.setState(num.getString("state").toString());
                            a.setRecovered(num.getString("recovered").toString());
                            arrayList.add(a);
                    }
                     adapter=new CustomAdapter(getApplicationContext(),arrayList);
                    recyclerView.setAdapter(adapter);
                    adapter.setOnItemClickListener(MainActivity.this);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
     queue.add(json);
    }
    @Override
    public void onItemClick(int pos) {
     Intent b=new Intent(this,MainActivity2.class);
     b.putExtra(acti,arrayList.get(pos).getActive());
     b.putExtra(confi,arrayList.get(pos).getConfirmed());
        b.putExtra(state,arrayList.get(pos).getState());
        b.putExtra(dead,arrayList.get(pos).getDeaths());
        b.putExtra(reco,arrayList.get(pos).getRecovered());
     startActivity(b);
    }
}