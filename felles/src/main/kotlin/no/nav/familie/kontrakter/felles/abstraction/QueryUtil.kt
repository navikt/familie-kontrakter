package no.nav.familie.kontrakter.felles.abstraction

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.familie.kontrakter.felles.objectMapper
import org.springframework.util.LinkedMultiValueMap

abstract class QueryObject {

    fun toQueryParams(): LinkedMultiValueMap<String, String> {
        return toQueryParams(this)
    }

}

fun toQueryParams(any: Any): LinkedMultiValueMap<String, String> {
    val writeValueAsString = objectMapper.writeValueAsString(any)
    val readValue: LinkedHashMap<String, Any?> = objectMapper.readValue(writeValueAsString)
    val queryParams = LinkedMultiValueMap<String, String>()
    readValue.filter { it.value != null }.forEach {
        if (it.value is List<*>) {
            queryParams.add(it.key, (it.value as List<*>).joinToString(","))
        } else {
            queryParams.add(it.key, it.value.toString())
        }
    }
    return queryParams
}
