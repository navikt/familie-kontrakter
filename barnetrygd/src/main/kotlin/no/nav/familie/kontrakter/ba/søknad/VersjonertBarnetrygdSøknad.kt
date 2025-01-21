package no.nav.familie.kontrakter.ba.søknad

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import no.nav.familie.kontrakter.felles.søknad.BaksSøknadBase
import no.nav.familie.kontrakter.felles.søknad.MissingVersionException
import no.nav.familie.kontrakter.felles.søknad.UnsupportedVersionException
import no.nav.familie.kontrakter.ba.søknad.v7.Søknad as BarnetrygdSøknadV7
import no.nav.familie.kontrakter.ba.søknad.v8.Søknad as BarnetrygdSøknadV8
import no.nav.familie.kontrakter.ba.søknad.v9.BarnetrygdSøknad as BarnetrygdSøknadV9

class VersjonertBarnetrygdSøknadSerializer : JsonSerializer<VersjonertBarnetrygdSøknad>() {
    override fun serialize(
        value: VersjonertBarnetrygdSøknad,
        jsonGenerator: JsonGenerator,
        serializers: SerializerProvider,
    ) {
        jsonGenerator.writePOJO(value.barnetrygdSøknad)
    }
}

class VersjonertBarnetrygdSøknadDeserializer : JsonDeserializer<VersjonertBarnetrygdSøknad>() {
    /**
     * @throws MissingVersionException `kontraktVersjon` ikke finnes i JSON-string.
     * @throws UnsupportedVersionException dersom `kontraktVersjon` ikke er støttet.
     */
    override fun deserialize(
        p: JsonParser,
        ctxt: DeserializationContext,
    ): VersjonertBarnetrygdSøknad {
        val node: JsonNode = p.codec.readTree(p)
        val versjon =
            node.get("kontraktVersjon")?.asInt()
                ?: throw MissingVersionException("JSON-string mangler feltet 'kontraktVersjon' og kan ikke deserialiseres. $node")

        return when (versjon) {
            7 -> VersjonertBarnetrygdSøknadV7(barnetrygdSøknad = p.codec.treeToValue(node, BarnetrygdSøknadV7::class.java))
            8 -> VersjonertBarnetrygdSøknadV8(barnetrygdSøknad = p.codec.treeToValue(node, BarnetrygdSøknadV8::class.java))
            9 -> VersjonertBarnetrygdSøknadV9(barnetrygdSøknad = p.codec.treeToValue(node, BarnetrygdSøknadV9::class.java))
            else -> throw UnsupportedVersionException("Mangler implementasjon for versjon: $versjon av BarnetrygdSøknad.")
        }
    }
}

@JsonSerialize(using = VersjonertBarnetrygdSøknadSerializer::class)
@JsonDeserialize(using = VersjonertBarnetrygdSøknadDeserializer::class)
sealed class VersjonertBarnetrygdSøknad(
    open val barnetrygdSøknad: BaksSøknadBase,
)

// Egen sealed class for versjoner av barnetrygdsøknad vi støtter ved mottak. Dette vil være de 2 siste versjonene til enhver tid.
sealed class StøttetVersjonertBarnetrygdSøknad(
    override val barnetrygdSøknad: BaksSøknadBase,
) : VersjonertBarnetrygdSøknad(barnetrygdSøknad = barnetrygdSøknad)

data class VersjonertBarnetrygdSøknadV7(
    override val barnetrygdSøknad: BarnetrygdSøknadV7,
) : VersjonertBarnetrygdSøknad(barnetrygdSøknad = barnetrygdSøknad)

data class VersjonertBarnetrygdSøknadV8(
    override val barnetrygdSøknad: BarnetrygdSøknadV8,
) : StøttetVersjonertBarnetrygdSøknad(barnetrygdSøknad = barnetrygdSøknad)

data class VersjonertBarnetrygdSøknadV9(
    override val barnetrygdSøknad: BarnetrygdSøknadV9,
) : StøttetVersjonertBarnetrygdSøknad(barnetrygdSøknad = barnetrygdSøknad)
