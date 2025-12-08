package no.nav.familie.kontrakter.felles.søknad

import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls

interface BaksSøknadBase {
    val kontraktVersjon: Int
    val søker: BaksSøknadPersonBase
    val barn: List<BaksSøknadPersonBase>

    fun personerISøknad(): List<String> = listOf(søker.fnr).plus(barn.map { it.fnr })
}

interface BaSøknadBase : BaksSøknadBase {
    val dokumentasjon: List<BaSøknaddokumentasjon>
    val søknadstype: BaSøknadstype
}

interface BaSøknadstype {
    fun tilFellesSøknadstype(): BaFellesSøknadstype
}

sealed interface BaFellesSøknadstype {
    object Ordinær : BaFellesSøknadstype

    object Utvidet : BaFellesSøknadstype

    object IkkeSatt : BaFellesSøknadstype

    data class UkjentSøknadstype(
        val ukjentSøknadstype: String,
    ) : BaFellesSøknadstype
}

interface BaksSøknadPersonBase {
    val ident: Søknadsfelt<String>

    val fnr: String
        get() = ident.verdi.values.first()
}

interface BaSøknaddokumentasjon {
    val dokumentasjonsbehov: BaDokumentasjonsbehov
    val harSendtInn: Boolean
    val opplastedeVedlegg: List<BaSøknadsvedlegg>
}

interface BaSøknadsvedlegg {
    val dokumentId: String
    val navn: String
    val tittel: BaDokumentasjonsbehov
}

interface BaDokumentasjonsbehov {
    fun tilFellesDokumentasjonsbehov(): BaFellesDokumentasjonsbehov
}

sealed interface BaFellesDokumentasjonsbehov {
    object AdopsjonDato : BaFellesDokumentasjonsbehov

    object AvtaleDeltBosted : BaFellesDokumentasjonsbehov

    object VedtakOppholdstillatelse : BaFellesDokumentasjonsbehov

    object BekreftelseFraBarnevern : BaFellesDokumentasjonsbehov

    object BorFastMedSøker : BaFellesDokumentasjonsbehov

    object SeparertSkiltEnke : BaFellesDokumentasjonsbehov

    object Meklingsattest : BaFellesDokumentasjonsbehov

    object AnnenDokumentasjon : BaFellesDokumentasjonsbehov
}

typealias Locale = String

data class Søknadsfelt<T>(
    val label: Map<Locale, String>,
    // I Spring Boot 4.x vil deserialisering av null verdier i Map føre til feil uten denne annotasjonen. Tidligere har vi tillatt null verdier.
    // For å slippe en stor endring i kontrakten, setter vi nå at null verdier skal deserialiseres til Nulls.SET, som vil sette verdien til null i stedet for å kaste feil.
    @param:JsonSetter(contentNulls = Nulls.SET)
    val verdi: Map<Locale, T>,
)

class MissingVersionException(
    msg: String,
) : RuntimeException(msg)

class UnsupportedVersionException(
    msg: String,
) : RuntimeException(msg)
