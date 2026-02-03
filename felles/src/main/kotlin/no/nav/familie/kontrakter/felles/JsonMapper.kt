package no.nav.familie.kontrakter.felles

import tools.jackson.databind.DeserializationFeature
import tools.jackson.databind.SerializationFeature
import tools.jackson.databind.cfg.EnumFeature
import tools.jackson.databind.json.JsonMapper
import tools.jackson.module.kotlin.KotlinFeature
import tools.jackson.module.kotlin.KotlinModule

val jsonMapper: JsonMapper
    get() = jsonMapperBuilder.build()

val jsonMapperBuilder: JsonMapper.Builder =
    JsonMapper
        .builder()
        .addModule(
            KotlinModule
                .Builder()
                .enable(KotlinFeature.KotlinPropertyNameAsImplicitName)
                .build(),
        ).disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .disable(EnumFeature.READ_ENUMS_USING_TO_STRING)
        .disable(EnumFeature.WRITE_ENUMS_USING_TO_STRING)
        .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
