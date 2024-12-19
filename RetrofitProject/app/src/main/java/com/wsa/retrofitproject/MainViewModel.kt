package com.wsa.retrofitproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import retrofit2.Response

class MainViewModel(application: Application):AndroidViewModel(application) {

   val retrofitService= RetrofitInstance().getRetrofitInstance().create(UserService::class.java)

    val userDetailsLiveData = LiveData{
        val response: Response<UserDetails> = retrofitService.getUser()
        emit(response.body())
    }

}


