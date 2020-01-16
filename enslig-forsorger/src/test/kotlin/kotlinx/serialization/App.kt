package kotlinx.serialization/*
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
import kotlinx.serialization.modules.serializersModule
import kotlinx.serialization.schema.jsonSchema
import no.nav.familie.kontrakter.ef.søknad.Søknad

/**
 * Lager Json schema for Søknad
 */
fun main() {
    val json = Json(JsonConfiguration.Stable.copy(useArrayPolymorphism = true, prettyPrint = true),
                    context = serializersModule(LocalDateSerializer))
    println(json.stringify(JsonObjectSerializer, jsonSchema(Søknad.serializer().descriptor)))
}
