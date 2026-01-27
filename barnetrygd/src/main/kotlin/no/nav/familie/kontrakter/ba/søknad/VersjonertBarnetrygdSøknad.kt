package no.nav.familie.kontrakter.ba.søknad

import no.nav.familie.kontrakter.felles.søknad.BaSøknadBase
import no.nav.familie.kontrakter.felles.søknad.MissingVersionException
import no.nav.familie.kontrakter.felles.søknad.UnsupportedVersionException
import tools.jackson.core.JsonGenerator
import tools.jackson.core.JsonParser
import tools.jackson.databind.DeserializationContext
import tools.jackson.databind.JsonNode
import tools.jackson.databind.SerializationContext
import tools.jackson.databind.ValueDeserializer
import tools.jackson.databind.ValueSerializer
import tools.jackson.databind.annotation.JsonDeserialize
import tools.jackson.databind.annotation.JsonSerialize
import no.nav.familie.kontrakter.ba.søknad.v10.BarnetrygdSøknad as BarnetrygdSøknadV10
import no.nav.familie.kontrakter.ba.søknad.v7.Søknad as BarnetrygdSøknadV7
import no.nav.familie.kontrakter.ba.søknad.v8.Søknad as BarnetrygdSøknadV8
import no.nav.familie.kontrakter.ba.søknad.v9.BarnetrygdSøknad as BarnetrygdSøknadV9

class VersjonertBarnetrygdSøknadSerializer : ValueSerializer<VersjonertBarnetrygdSøknad>() {
    override fun serialize(
        value: VersjonertBarnetrygdSøknad,
        jsonGenerator: JsonGenerator,
        serializers: SerializationContext,
    ) {
        jsonGenerator.writePOJO(value.barnetrygdSøknad)
    }
}

class VersjonertBarnetrygdSøknadDeserializer : ValueDeserializer<VersjonertBarnetrygdSøknad>() {
    /**
     * @throws MissingVersionException `kontraktVersjon` ikke finnes i JSON-string.
     * @throws UnsupportedVersionException dersom `kontraktVersjon` ikke er støttet.
     */
    override fun deserialize(
        p: JsonParser,
        ctxt: DeserializationContext,
    ): VersjonertBarnetrygdSøknad {
        val node: JsonNode = p.readValueAsTree()
        val versjon =
            node.get("kontraktVersjon")?.asInt()
                ?: throw MissingVersionException("JSON-string mangler feltet 'kontraktVersjon' og kan ikke deserialiseres. $node")

        return when (versjon) {
            7 -> VersjonertBarnetrygdSøknadV7(barnetrygdSøknad = ctxt.readTreeAsValue(node, BarnetrygdSøknadV7::class.java))
            8 -> VersjonertBarnetrygdSøknadV8(barnetrygdSøknad = ctxt.readTreeAsValue(node, BarnetrygdSøknadV8::class.java))
            9 -> VersjonertBarnetrygdSøknadV9(barnetrygdSøknad = ctxt.readTreeAsValue(node, BarnetrygdSøknadV9::class.java))
            10 -> VersjonertBarnetrygdSøknadV10(barnetrygdSøknad = ctxt.readTreeAsValue(node, BarnetrygdSøknadV10::class.java))
            else -> throw UnsupportedVersionException("Mangler implementasjon for versjon: $versjon av BarnetrygdSøknad.")
        }
    }
}

@JsonSerialize(using = VersjonertBarnetrygdSøknadSerializer::class)
@JsonDeserialize(using = VersjonertBarnetrygdSøknadDeserializer::class)
sealed class VersjonertBarnetrygdSøknad(
    open val barnetrygdSøknad: BaSøknadBase,
)

// Egen sealed class for versjoner av barnetrygdsøknad vi støtter ved mottak. Dette vil være de 2 siste versjonene til enhver tid.
sealed class StøttetVersjonertBarnetrygdSøknad(
    override val barnetrygdSøknad: BaSøknadBase,
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

data class VersjonertBarnetrygdSøknadV10(
    override val barnetrygdSøknad: BarnetrygdSøknadV10,
) : StøttetVersjonertBarnetrygdSøknad(barnetrygdSøknad = barnetrygdSøknad)
