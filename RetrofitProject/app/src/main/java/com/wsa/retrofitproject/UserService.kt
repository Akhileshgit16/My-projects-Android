package com.wsa.retrofitproject

import retrofit2.Response
import retrofit2.http.GET

interface UserService  {
    @GET("\users")
    suspend fun getUser(): Response<UserDetails>

}