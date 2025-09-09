package com.filipeneri.bipamobilecodingchallenge.service

import com.filipeneri.bipamobilecodingchallenge.model.Node
import retrofit2.Call
import retrofit2.http.GET

interface NodeApi {

    @GET("/api/v1/lightning/nodes/rankings/connectivity")
    fun getNodes(): Call<List<Node>>
}