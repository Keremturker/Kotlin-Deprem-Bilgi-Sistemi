package com.keremturker.deprembilgisistemi.service

import com.keremturker.deprembilgisistemi.model.Deprem
import retrofit2.Call
import retrofit2.http.GET

interface Api {


    @GET("api")
    fun getData(): Call<ArrayList<Deprem>>
}