package com.filipeneri.bipamobilecodingchallenge.repository

import com.filipeneri.bipamobilecodingchallenge.model.Node
import com.filipeneri.bipamobilecodingchallenge.service.HTTPClient
import com.filipeneri.bipamobilecodingchallenge.service.NodeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository {
    suspend fun getNodes(): List<Node> {
        return withContext(Dispatchers.IO) {
            val response = HTTPClient.retrofit()
                .create(NodeApi::class.java)
                .getNodes()
                .execute()

            if (response.isSuccessful) {
                val sql = response.body()
                if (sql != null) {
                    return@withContext sql
                } else {
                    throw Exception("Error to get Nodes")
                }
            } else {
                throw Exception("Error to get Nodes")
            }
        }
    }
}