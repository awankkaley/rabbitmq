package com.example.rabbitmq.rabbitmq

import java.io.Serializable


data class ExampleData(
    val id: String,
    val name: String
) : Serializable