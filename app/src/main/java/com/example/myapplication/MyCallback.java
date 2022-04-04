package com.example.myapplication;

public interface MyCallback
{
    void onSuccess(Product[] list);
    void onFailure(String error);
}
