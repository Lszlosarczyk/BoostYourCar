package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class Product
{
    @SerializedName("nazwa_produktu")
    public String nazwa;

    public float cena_detaliczna;

}
