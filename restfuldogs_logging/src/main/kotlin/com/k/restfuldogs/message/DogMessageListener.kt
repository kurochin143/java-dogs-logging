package com.k.restfuldogs.message

import com.k.restfuldogs.Log
import com.k.restfuldogs.RestfuldogsApplication
import org.springframework.amqp.rabbit.annotation.RabbitListener

//@Service
class DogMessageListener {
    companion object : Log()

    @RabbitListener(queues = [RestfuldogsApplication.QUEUE_NAME_DOGS])
    fun receiveMessageLOW(dogMessage: DogMessage) {
        logger.info("Received Message DOG: {} ", dogMessage.toString())
    }

    @RabbitListener(queues = [RestfuldogsApplication.QUEUE_NAME_DOG_BREED])
    fun receiveMessageHigh(dogMessage: DogMessage) {
        logger.info("Received Message DOG_BREED: {} ", dogMessage.toString())
    }

}