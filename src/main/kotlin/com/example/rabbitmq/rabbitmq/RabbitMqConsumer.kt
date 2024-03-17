package com.example.rabbitmq.rabbitmq

import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class RabbitMqConsumer {

    private val logger = LoggerFactory.getLogger(RabbitMqConsumer::class.java)

    @RabbitListener(queues = ["\${spring.rabbitmq.queue}"])
    fun receiveMessage(message: ExampleData) {
        logger.info("Received message: id=${message.id} name=${message.name}")
    }

}