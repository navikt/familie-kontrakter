package no.nav.familie.ks.kontrakter

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.time.LocalDate
import java.time.format.DateTimeFormatter


interface Kontrakt

val objectMapper: ObjectMapper
    get() = ObjectMapper()
        .setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE)
        .setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE)
        .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
        .setVisibility(PropertyAccessor.CREATOR, JsonAutoDetect.Visibility.ANY)
        .registerKotlinModule()
        .registerModule(JavaTimeModule().addDeserializer(LocalDate::class.java, LocalDateDeserializer(
            DateTimeFormatter.ofPattern("dd.MM.yyyy"))))
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)