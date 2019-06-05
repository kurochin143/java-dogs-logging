package com.k.restfuldogs_logging_listener.message

import com.k.restfuldogs_logging_listener.Log
import com.k.restfuldogs_logging_listener.RestfuldogsLoggingListenerApplication
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class DogMessageListener {
    companion object : Log()

    @RabbitListener(queues = [RestfuldogsLoggingListenerApplication.QUEUE_NAME_DOGS])
    fun receiveMessageDOGS(dogMessage: DogMessage) {
        logger.info("Received Message DOG: {} ", dogMessage.toString())
    }

    @RabbitListener(queues = [RestfuldogsLoggingListenerApplication.QUEUE_NAME_DOG_BREED])
    fun receiveMessageDOG_BREED(dogMessage: DogMessage) {
        logger.info("Received Message DOG_BREED: {} ", dogMessage.toString())
    }

}