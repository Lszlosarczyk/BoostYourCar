package com.example.myapplication;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ClientHttp
{
    private final static String TAG = "ClientHttp";

    private final String url = "https://randomuser.me/api/"; //adres rest api
    private final OkHttpClient client = new OkHttpClient().newBuilder().build();

    public Boolean login(String user, String password)
    {
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null) //GET, PUT, DELETE, POST
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback()
        {
            public void onResponse(Call call, Response response) throws IOException
            {

                Log.d(TAG, "onResponse: " + response.body().string());
                if (response.code() == 200)
                {
                    Log.d(TAG, "code=200. OK ");
//                    Gson gson = new Gson();
//                    MyClass myClass = gson.fromJson(response.body().string(), MyClass.class);
                }
            }

            public void onFailure(Call call, IOException e)
            {
                Log.e(TAG, "onFailure: " + e.getMessage());
            }
        });

        return false;
    }
}
