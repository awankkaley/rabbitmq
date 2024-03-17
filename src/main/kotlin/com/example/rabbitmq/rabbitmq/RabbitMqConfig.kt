package com.example.rabbitmq.rabbitmq


import org.springframework.amqp.core.*
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMqConfig {

    @Value("\${spring.rabbitmq.queue}")
    private val queueName: String? = null

    @Value("\${spring.rabbitmq.exchange}")
    private val exchangeName: String? = null

    @Value("\${spring.rabbitmq.routing-key}")
    private val routingKey: String? = null

    @Bean
    fun queue(): Queue {
        return Queue(queueName, true)
    }

    @Bean
    fun exchange(): TopicExchange {
        return TopicExchange(exchangeName)
    }

    @Bean
    fun binding(queue: Queue, exchange: TopicExchange): Binding {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey)
    }

    @Bean
    fun messageConverter(): MessageConverter {
        return Jackson2JsonMessageConverter()
    }

    @Bean
    fun amqpTemplate(connectionFactory: ConnectionFactory): AmqpTemplate {
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.messageConverter = messageConverter()
        return rabbitTemplate
    }

}