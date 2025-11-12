package no.nav.familie.kontrakter.ks.søknad

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
import no.nav.familie.kontrakter.ks.søknad.v1.KontantstøtteSøknad as KontantstøtteSøknadV1
import no.nav.familie.kontrakter.ks.søknad.v2.KontantstøtteSøknad as KontantstøtteSøknadV2
import no.nav.familie.kontrakter.ks.søknad.v3.KontantstøtteSøknad as KontantstøtteSøknadV3
import no.nav.familie.kontrakter.ks.søknad.v4.KontantstøtteSøknad as KontantstøtteSøknadV4
import no.nav.familie.kontrakter.ks.søknad.v5.KontantstøtteSøknad as KontantstøtteSøknadV5
import no.nav.familie.kontrakter.ks.søknad.v6.KontantstøtteSøknad as KontantstøtteSøknadV6

class VersjonertKontantStøtteSerializer : JsonSerializer<VersjonertKontantstøtteSøknad>() {
    override fun serialize(
        value: VersjonertKontantstøtteSøknad,
        jsonGenerator: JsonGenerator,
        serializers: SerializerProvider,
    ) {
        jsonGenerator.writePOJO(value.kontantstøtteSøknad)
    }
}

class VersjonertKontantstøtteSøknadDeserializer : JsonDeserializer<VersjonertKontantstøtteSøknad>() {
    /**
     * @throws MissingVersionException `kontraktVersjon` ikke finnes i JSON-string.
     * @throws UnsupportedVersionException dersom `kontraktVersjon` ikke er støttet.
     */
    override fun deserialize(
        p: JsonParser,
        ctxt: DeserializationContext,
    ): VersjonertKontantstøtteSøknad {
        val node: JsonNode = p.codec.readTree(p)
        val versjon =
            node.get("kontraktVersjon")?.asInt()
                ?: throw MissingVersionException("JSON-string mangler feltet 'kontraktVersjon' og kan ikke deserialiseres. $node")

        return when (versjon) {
            1 -> VersjonertKontantstøtteSøknadV1(kontantstøtteSøknad = p.codec.treeToValue(node, KontantstøtteSøknadV1::class.java))
            2 -> VersjonertKontantstøtteSøknadV2(kontantstøtteSøknad = p.codec.treeToValue(node, KontantstøtteSøknadV2::class.java))
            3 -> VersjonertKontantstøtteSøknadV3(kontantstøtteSøknad = p.codec.treeToValue(node, KontantstøtteSøknadV3::class.java))
            4 -> VersjonertKontantstøtteSøknadV4(kontantstøtteSøknad = p.codec.treeToValue(node, KontantstøtteSøknadV4::class.java))
            5 -> VersjonertKontantstøtteSøknadV5(kontantstøtteSøknad = p.codec.treeToValue(node, KontantstøtteSøknadV5::class.java))
            6 -> VersjonertKontantstøtteSøknadV6(kontantstøtteSøknad = p.codec.treeToValue(node, KontantstøtteSøknadV6::class.java))
            else -> throw UnsupportedVersionException("Mangler implementasjon for versjon: $versjon av KontantstøtteSøknad.")
        }
    }
}

@JsonSerialize(using = VersjonertKontantStøtteSerializer::class)
@JsonDeserialize(using = VersjonertKontantstøtteSøknadDeserializer::class)
sealed class VersjonertKontantstøtteSøknad(
    open val kontantstøtteSøknad: BaksSøknadBase,
)

// Egen sealed class for versjoner av kontantstøttesøknad vi støtter ved mottak. Dette vil være de 2 siste versjonene til enhver tid.
sealed class StøttetVersjonertKontantstøtteSøknad(
    override val kontantstøtteSøknad: BaksSøknadBase,
) : VersjonertKontantstøtteSøknad(kontantstøtteSøknad = kontantstøtteSøknad)

data class VersjonertKontantstøtteSøknadV1(
    override val kontantstøtteSøknad: KontantstøtteSøknadV1,
) : VersjonertKontantstøtteSøknad(kontantstøtteSøknad = kontantstøtteSøknad)

data class VersjonertKontantstøtteSøknadV2(
    override val kontantstøtteSøknad: KontantstøtteSøknadV2,
) : VersjonertKontantstøtteSøknad(kontantstøtteSøknad = kontantstøtteSøknad)

data class VersjonertKontantstøtteSøknadV3(
    override val kontantstøtteSøknad: KontantstøtteSøknadV3,
) : VersjonertKontantstøtteSøknad(kontantstøtteSøknad = kontantstøtteSøknad)

data class VersjonertKontantstøtteSøknadV4(
    override val kontantstøtteSøknad: KontantstøtteSøknadV4,
) : StøttetVersjonertKontantstøtteSøknad(kontantstøtteSøknad = kontantstøtteSøknad)

data class VersjonertKontantstøtteSøknadV5(
    override val kontantstøtteSøknad: KontantstøtteSøknadV5,
) : StøttetVersjonertKontantstøtteSøknad(kontantstøtteSøknad = kontantstøtteSøknad)

data class VersjonertKontantstøtteSøknadV6(
    override val kontantstøtteSøknad: KontantstøtteSøknadV6,
) : StøttetVersjonertKontantstøtteSøknad(kontantstøtteSøknad = kontantstøtteSøknad)
