package no.nav.familie.kontrakter.ba.søknad

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import no.nav.familie.kontrakter.felles.søknad.BaksSøknadBase
import no.nav.familie.kontrakter.felles.søknad.MissingVersionException
import no.nav.familie.kontrakter.felles.søknad.UnsupportedVersionException
import no.nav.familie.kontrakter.ba.søknad.v7.Søknad as BarnetrygdSøknadV7
import no.nav.familie.kontrakter.ba.søknad.v8.Søknad as BarnetrygdSøknadV8
import no.nav.familie.kontrakter.ba.søknad.v9.BarnetrygdSøknad as BarnetrygdSøknadV9

class VersjonertBarnetrygdSøknadDeserializer : JsonDeserializer<VersjonertBarnetrygdSøknad>() {
    /**
     * @throws MissingVersionException dersom `kontraktVersjon` ikke er støttet.
     * @throws UnsupportedVersionException `kontraktVersjon` ikke finnes i JSON-string.
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
            7 -> VersjonertBarnetrygdSøknadV7(baksSøknadBase = p.codec.treeToValue(node, BarnetrygdSøknadV7::class.java))
            8 -> VersjonertBarnetrygdSøknadV8(baksSøknadBase = p.codec.treeToValue(node, BarnetrygdSøknadV8::class.java))
            9 -> VersjonertBarnetrygdSøknadV9(baksSøknadBase = p.codec.treeToValue(node, BarnetrygdSøknadV9::class.java))
            else -> throw UnsupportedVersionException("Mangler implementasjon for versjon: $versjon av BarnetrygdSøknad.")
        }
    }
}

@JsonDeserialize(using = VersjonertBarnetrygdSøknadDeserializer::class)
sealed class VersjonertBarnetrygdSøknad(
    open val baksSøknadBase: BaksSøknadBase,
)

data class VersjonertBarnetrygdSøknadV7(
    override val baksSøknadBase: BarnetrygdSøknadV7,
) : VersjonertBarnetrygdSøknad(baksSøknadBase = baksSøknadBase)

data class VersjonertBarnetrygdSøknadV8(
    override val baksSøknadBase: BarnetrygdSøknadV8,
) : VersjonertBarnetrygdSøknad(baksSøknadBase = baksSøknadBase)

data class VersjonertBarnetrygdSøknadV9(
    override val baksSøknadBase: BarnetrygdSøknadV9,
) : VersjonertBarnetrygdSøknad(baksSøknadBase = baksSøknadBase)
