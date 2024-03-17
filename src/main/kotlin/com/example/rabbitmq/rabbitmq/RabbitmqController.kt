package com.example.rabbitmq.rabbitmq

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rabbitmq")
class RabbitmqController {

    @Autowired
    lateinit var rabbitmqProducer: RabbitmqProducer

    @PostMapping("/send")
    fun sendMessage(){
        val exampleData = ExampleData("1", "RabbitMQ Example")
        rabbitmqProducer.sendMessage(exampleData)
    }
}