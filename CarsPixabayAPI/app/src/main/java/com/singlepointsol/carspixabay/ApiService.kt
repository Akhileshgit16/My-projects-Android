package com.singlepointsol.carspixabay

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("?key=47653851-be8efc99633a4a71764951148&q=bikes &image_type=\"photo\"&pretty=true")
    suspend fun getCars() : Response<CarsResponse>
}