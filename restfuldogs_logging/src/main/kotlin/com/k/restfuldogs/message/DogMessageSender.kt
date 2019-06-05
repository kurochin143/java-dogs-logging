package com.k.restfuldogs.message

import com.k.restfuldogs.DogRepository
import com.k.restfuldogs.RestfuldogsApplication
import com.k.restfuldogs.model.Dog
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*

//@Service
class DogMessageSender(
        private val rt: RabbitTemplate,
        private val dogRepository: DogRepository
) {
    @Scheduled(fixedDelay = 3000L)
    fun sendMessage() {
        val dogs = mutableListOf<Dog>()

        dogs.addAll(dogRepository.findAll())

        dogs.forEach {
            val random = Random()
            val rand = random.nextInt(10)
            val randBool = random.nextBoolean()
            val message = DogMessage(it.toString(), SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z").format(Date().time), rand, randBool)
            if (rand <= 5) {
                rt.convertAndSend(RestfuldogsApplication.QUEUE_NAME_DOG_BREED, message)
            } else {
                rt.convertAndSend(RestfuldogsApplication.QUEUE_NAME_DOGS, message)
            }
        }
    }
}