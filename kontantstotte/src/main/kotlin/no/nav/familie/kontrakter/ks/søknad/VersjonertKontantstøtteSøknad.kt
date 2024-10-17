package no.nav.familie.kontrakter.ks.søknad

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import no.nav.familie.kontrakter.felles.søknad.BaksSøknadBase
import no.nav.familie.kontrakter.felles.søknad.MissingVersionImplementationException
import no.nav.familie.kontrakter.felles.søknad.UnsupportedVersionException
import no.nav.familie.kontrakter.ks.søknad.v1.KontantstøtteSøknad as KontantstøtteSøknadV1
import no.nav.familie.kontrakter.ks.søknad.v2.KontantstøtteSøknad as KontantstøtteSøknadV2
import no.nav.familie.kontrakter.ks.søknad.v3.KontantstøtteSøknad as KontantstøtteSøknadV3
import no.nav.familie.kontrakter.ks.søknad.v4.KontantstøtteSøknad as KontantstøtteSøknadV4
import no.nav.familie.kontrakter.ks.søknad.v5.KontantstøtteSøknad as KontantstøtteSøknadV5

class VersjonertKontantstøtteSøknadDeserializer : JsonDeserializer<VersjonertKontantstøtteSøknad>() {
    /**
     * @throws UnsupportedVersionException dersom `kontraktVersjon` ikke er støttet.
     * @throws MissingVersionImplementationException `kontraktVersjon` ikke finnes i JSON-string.
     */
    override fun deserialize(
        p: JsonParser,
        ctxt: DeserializationContext,
    ): VersjonertKontantstøtteSøknad {
        val node: JsonNode = p.codec.readTree(p)
        val versjon =
            node.get("kontraktVersjon")?.asInt()
                ?: throw UnsupportedVersionException("JSON-string mangler feltet 'kontraktVersjon' og kan ikke deserialiseres. $node")

        return when (versjon) {
            1 -> VersjonertKontantstøtteSøknadV1(baksSøknadBase = p.codec.treeToValue(node, KontantstøtteSøknadV1::class.java))
            2 -> VersjonertKontantstøtteSøknadV2(baksSøknadBase = p.codec.treeToValue(node, KontantstøtteSøknadV2::class.java))
            3 -> VersjonertKontantstøtteSøknadV3(baksSøknadBase = p.codec.treeToValue(node, KontantstøtteSøknadV3::class.java))
            4 -> VersjonertKontantstøtteSøknadV4(baksSøknadBase = p.codec.treeToValue(node, KontantstøtteSøknadV4::class.java))
            5 -> VersjonertKontantstøtteSøknadV5(baksSøknadBase = p.codec.treeToValue(node, KontantstøtteSøknadV5::class.java))
            else -> throw MissingVersionImplementationException("Mangler implementasjon for versjon: $versjon av KontantstøtteSøknad.")
        }
    }
}

@JsonDeserialize(using = VersjonertKontantstøtteSøknadDeserializer::class)
sealed class VersjonertKontantstøtteSøknad(
    open val baksSøknadBase: BaksSøknadBase,
)

data class VersjonertKontantstøtteSøknadV1(
    override val baksSøknadBase: KontantstøtteSøknadV1,
) : VersjonertKontantstøtteSøknad(baksSøknadBase = baksSøknadBase)

data class VersjonertKontantstøtteSøknadV2(
    override val baksSøknadBase: KontantstøtteSøknadV2,
) : VersjonertKontantstøtteSøknad(baksSøknadBase = baksSøknadBase)

data class VersjonertKontantstøtteSøknadV3(
    override val baksSøknadBase: KontantstøtteSøknadV3,
) : VersjonertKontantstøtteSøknad(baksSøknadBase = baksSøknadBase)

data class VersjonertKontantstøtteSøknadV4(
    override val baksSøknadBase: KontantstøtteSøknadV4,
) : VersjonertKontantstøtteSøknad(baksSøknadBase = baksSøknadBase)

data class VersjonertKontantstøtteSøknadV5(
    override val baksSøknadBase: KontantstøtteSøknadV5,
) : VersjonertKontantstøtteSøknad(baksSøknadBase = baksSøknadBase)
