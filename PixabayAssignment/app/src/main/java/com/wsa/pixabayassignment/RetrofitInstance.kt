package com.wsa.pixabayassignment

import PixabayService
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory

val retrofit = Retrofit.Builder()
    .baseUrl("https://pixabay.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val service = retrofit.create(PixabayService::class.java)
