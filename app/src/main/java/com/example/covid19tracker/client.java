package com.example.covid19tracker;

import android.text.style.ClickableSpan;

import com.android.volley.Response;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class client {
   OkHttpClient Okclient=new OkHttpClient();
    String url="https://api.covid19india.org/data.json";
    Request request = new Request.Builder().url(url).build();
         Response res= (Response) Okclient.newCall(request);
}
