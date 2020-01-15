/*
 * Copyright 2019 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.JsonObjectSerializer
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.plus
import kotlinx.serialization.modules.serializersModuleOf
import kotlinx.serialization.schema.JsonSchema
import no.nav.familie.kontrakter.ef.søknad.LocalDateSerializer
import no.nav.familie.kontrakter.ef.søknad.Søknad
import java.time.LocalDate

fun main(args: Array<String>) {
    println(">> Sample of Json schema: ")

    val scope = serializersModuleOf(LocalDate::class, LocalDateSerializer)
    val bPolymorphicModule = SerializersModule { polymorphic(Any::class) { LocalDate::class with LocalDateSerializer } }
    val json = Json(
            JsonConfiguration.Stable.copy(unquoted = true, useArrayPolymorphism = true, prettyPrint = true),
            context = scope + bPolymorphicModule
    )



    println(json.stringify(JsonObjectSerializer, JsonSchema(Søknad.serializer().descriptor)))
}
