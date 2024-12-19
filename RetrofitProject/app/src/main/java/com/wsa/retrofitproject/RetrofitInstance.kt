package com.wsa.retrofitproject

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object
    val Pageurl = "https://jsonplaceholder.typicode.com/"

    fun getRetrofitInstance():Retrofit{
       return Retrofit.Builder().baseUrl(Pageurl)
           .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
           .build()

    }
}