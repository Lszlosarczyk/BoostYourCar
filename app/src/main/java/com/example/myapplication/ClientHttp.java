package com.example.myapplication;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ClientHttp
{
    private final static String TAG = "ClientHttp";

    private final String url = "http://192.168.1.52:9999/boostyourcar/"; //adres rest api
    private final OkHttpClient client = new OkHttpClient().newBuilder().build();

    private String endpoint = "";

    public Boolean get(String endpoint, MyCallback callback)
    {
        Request request = new Request.Builder()
                .url(url+endpoint)
                .method("GET", null) //GET, PUT, DELETE, POST
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback()
        {
            public void onResponse(Call call, Response response) throws IOException
            {
                if (response.code() == 200)
                {
                    Gson gson = new Gson();
                    Product[] product = gson.fromJson(response.body().string(), Product[].class);
                    callback.onSuccess(product);
                }
            }

            public void onFailure(Call call, IOException e)
            {
                callback.onFailure(e.getMessage());
                Log.e(TAG, "onFailure: " + e.getMessage());
            }
        });

        return false;
    }
}
