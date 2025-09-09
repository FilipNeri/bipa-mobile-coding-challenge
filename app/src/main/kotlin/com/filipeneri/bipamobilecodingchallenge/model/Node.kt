package com.filipeneri.bipamobilecodingchallenge.model

data class Node(
    val publicKey: String,
    val alias: String,
    val channels: Long,
    val capacity: Long,
    val firstSeen: Long,
    val updatedAt: Long,
    val city: City,
    val country:Country
)


