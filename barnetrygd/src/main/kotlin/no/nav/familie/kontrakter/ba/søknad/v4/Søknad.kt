package no.nav.familie.kontrakter.ba.søknad.v4

import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls
import no.nav.familie.kontrakter.ba.søknad.v1.SIVILSTANDTYPE
import no.nav.familie.kontrakter.ba.søknad.v1.SøknadAdresse
import no.nav.familie.kontrakter.felles.søknad.BaFellesSøknadstype
import no.nav.familie.kontrakter.felles.søknad.BaSøknadstype
import java.time.LocalDate

typealias Locale = String
typealias SpørsmålId = String

data class Søknadsfelt<T>(
    val label: Map<Locale, String>,
    // I Spring Boot 4.x vil deserialisering av null verdier i Map føre til feil uten denne annotasjonen. Tidligere har vi tillatt null verdier.
    // For å slippe en stor endring i kontrakten, setter vi nå at null verdier skal deserialiseres til Nulls.SET, som vil sette verdien til null i stedet for å kaste feil.
    @param:JsonSetter(contentNulls = Nulls.SET)
    val verdi: Map<Locale, T>,
)

enum class Søknadstype(
    val tittel: String,
    val søknadskode: String,
) : BaSøknadstype {
    IKKE_SATT("SØKNADSTYPE MANGLER", "SØKNADSTYPE MANGLER"),
    ORDINÆR("Søknad om barnetrygd ordinær", "NAV 33-00.07"),
    UTVIDET("Søknad om utvidet barnetrygd", "NAV 33-00.09"),
    ;

    override fun tilFellesSøknadstype(): BaFellesSøknadstype =
        when (this) {
            IKKE_SATT -> BaFellesSøknadstype.IkkeSatt
            ORDINÆR -> BaFellesSøknadstype.Ordinær
            UTVIDET -> BaFellesSøknadstype.Utvidet
        }
}

@Deprecated("Bruk v5", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v5.Søknad"))
data class Søknad(
    val søknadstype: Søknadstype,
    val søker: Søker,
    val barn: List<Barn>,
    val spørsmål: Map<SpørsmålId, Søknadsfelt<Any>>,
    val dokumentasjon: List<Søknaddokumentasjon>,
    val teksterUtenomSpørsmål: Map<SpørsmålId, Map<Locale, String>>,
    val originalSpråk: Locale,
)

@Deprecated("Bruk v7", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v7.Dokumentasjonsbehov"))
enum class Dokumentasjonsbehov {
    AVTALE_DELT_BOSTED,
    VEDTAK_OPPHOLDSTILLATELSE,
    ADOPSJON_DATO,
    BEKREFTELSE_FRA_BARNEVERN,
    BOR_FAST_MED_SØKER,
    ANNEN_DOKUMENTASJON,
    SEPARERT_SKILT_ENKE,
    MEKLINGSATTEST,
    EØS_SKJEMA,
}

@Deprecated("Bruk v7", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v7.Søknadsvedlegg"))
data class Søknadsvedlegg(
    val dokumentId: String,
    val navn: String,
    val tittel: Dokumentasjonsbehov,
)

@Deprecated("Bruk v7", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v7.Søknaddokumentasjon"))
data class Søknaddokumentasjon(
    val dokumentasjonsbehov: Dokumentasjonsbehov,
    val harSendtInn: Boolean,
    val opplastedeVedlegg: List<Søknadsvedlegg>,
    val dokumentasjonSpråkTittel: Map<Locale, String>,
)

data class NåværendeSamboer(
    val navn: Søknadsfelt<String>,
    val ident: Søknadsfelt<String>,
    val fødselsdato: Søknadsfelt<String>,
    val samboerFraDato: Søknadsfelt<LocalDate>,
)

data class TidligereSamboer(
    val navn: Søknadsfelt<String>,
    val ident: Søknadsfelt<String>,
    val fødselsdato: Søknadsfelt<String>,
    val samboerFraDato: Søknadsfelt<LocalDate>,
    val samboerTilDato: Søknadsfelt<LocalDate>,
)

data class Utenlandsopphold(
    val utenlandsoppholdÅrsak: Søknadsfelt<String>,
    val oppholdsland: Søknadsfelt<String>,
    val oppholdslandTilDato: Søknadsfelt<String?>,
    val oppholdslandFraDato: Søknadsfelt<String?>,
)

data class Søker(
    val ident: Søknadsfelt<String>,
    val navn: Søknadsfelt<String>,
    val statsborgerskap: Søknadsfelt<List<String>>,
    val adresse: Søknadsfelt<SøknadAdresse>,
    val sivilstand: Søknadsfelt<SIVILSTANDTYPE>,
    val spørsmål: Map<String, Søknadsfelt<Any>>,
    val nåværendeSamboer: Søknadsfelt<NåværendeSamboer>?,
    val tidligereSamboere: List<Søknadsfelt<TidligereSamboer>>,
    val utenlandsperioder: List<Søknadsfelt<Utenlandsopphold>> = listOf(),
)

@Deprecated("Bruk v5", replaceWith = ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v5.Barn"))
data class Barn(
    val ident: Søknadsfelt<String>,
    val navn: Søknadsfelt<String>,
    val borMedSøker: Søknadsfelt<Boolean>,
    val alder: Søknadsfelt<String>,
    val spørsmål: Map<String, Søknadsfelt<Any>>,
)
