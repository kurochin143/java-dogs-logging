package com.k.restfuldogs_logging_listener

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class RestfuldogsLoggingListenerApplication {
    companion object {
        const val EXCHANGE_NAME = "DogServer"
        const val QUEUE_NAME_DOGS = "DogsQueue"
        const val QUEUE_NAME_DOG_BREED = "DogBreedQueue"
    }

    @Bean
    fun appExchange(): TopicExchange {
        return TopicExchange(EXCHANGE_NAME)
    }

    @Bean
    fun appQueueDogs(): Queue {
        return Queue(QUEUE_NAME_DOGS)
    }

    @Bean
    fun declareBindingDogs(): Binding {
        return BindingBuilder.bind(appQueueDogs()).to(appExchange()).with(QUEUE_NAME_DOGS)
    }

    @Bean
    fun appQueueDogBreed(): Queue {
        return Queue(QUEUE_NAME_DOG_BREED)
    }

    @Bean
    fun declareBindingDogBreed(): Binding {
        return BindingBuilder.bind(appQueueDogBreed()).to(appExchange()).with(QUEUE_NAME_DOG_BREED)
    }

    @Bean
    fun producerJackson2MessageConverter(): Jackson2JsonMessageConverter {
        return Jackson2JsonMessageConverter()
    }
}

fun main(args: Array<String>) {
    runApplication<RestfuldogsLoggingListenerApplication>(*args)
}
