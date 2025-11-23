package no.nav.familie.kontrakter.felles

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.datatype.jsr310.deser.YearMonthDeserializer
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.time.YearMonth
import java.time.format.DateTimeFormatter

val objectMapper: ObjectMapper =
    ObjectMapper().apply {
        registerKotlinModule()
        registerModule(
            JavaTimeModule().apply {
                addDeserializer(YearMonth::class.java, YearMonthDeserializer(DateTimeFormatter.ofPattern("u-MM")))
            },
        )
        setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE)
        setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE)
        setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
        setVisibility(PropertyAccessor.CREATOR, JsonAutoDetect.Visibility.ANY)
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
        disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
    }
