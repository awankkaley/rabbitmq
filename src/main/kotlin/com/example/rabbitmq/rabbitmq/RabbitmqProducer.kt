package com.example.rabbitmq.rabbitmq

import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class RabbitmqProducer {

    //logger factory
    private val logger = LoggerFactory.getLogger(RabbitmqProducer::class.java)


    @Value("\${spring.rabbitmq.exchange}")
    private val exchange: String? = null

    @Value("\${spring.rabbitmq.routing-key}")
    private val routingKey: String? = null

    @Autowired
    lateinit var rabbitTemplate: RabbitTemplate

    fun sendMessage(message: ExampleData) {
        logger.info("Sending message to the queue using routing key: $routingKey and exchange: $exchange data: $message")
        rabbitTemplate.convertAndSend(exchange!!, routingKey!!, message)
    }
}