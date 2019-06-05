package com.k.restfuldogs_logging_listener.message

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class DogMessage(
        @JsonProperty("text") var text: String? = null,
        @JsonProperty("date") var date: String? = null,
        @JsonProperty("priority") var priority: Int = 0,
        @JsonProperty("isSecret") var isSecret: Boolean = false
) : Serializable