package com.k.restfuldogs.message

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*


data class DogMessage(
        @JsonProperty("text") var text: String? = null,
        @JsonProperty("date") var date: String? = null,
        @JsonProperty("priority") var priority: Int = 0,
        @JsonProperty("isSecret") var isSecret: Boolean = false
) : Serializable {

    fun setDateToCurrent() {
        date = SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z").format(Date().time)
    }
}