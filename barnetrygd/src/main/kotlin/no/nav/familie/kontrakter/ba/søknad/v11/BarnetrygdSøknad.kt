package no.nav.familie.kontrakter.ba.søknad.v11

import no.nav.familie.kontrakter.ba.søknad.v10.Barn
import no.nav.familie.kontrakter.ba.søknad.v10.Søker
import no.nav.familie.kontrakter.ba.søknad.v4.Locale
import no.nav.familie.kontrakter.ba.søknad.v4.SpørsmålId
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadsfelt
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadstype
import no.nav.familie.kontrakter.felles.søknad.BaDokumentasjonsbehov
import no.nav.familie.kontrakter.felles.søknad.BaFellesDokumentasjonsbehov
import no.nav.familie.kontrakter.felles.søknad.BaSøknadBase
import no.nav.familie.kontrakter.felles.søknad.BaSøknaddokumentasjon
import no.nav.familie.kontrakter.felles.søknad.BaSøknadsvedlegg

data class BarnetrygdSøknad(
    override val kontraktVersjon: Int,
    override val søker: Søker,
    override val barn: List<Barn>,
    override val dokumentasjon: List<Søknaddokumentasjon>,
    override val søknadstype: Søknadstype,
    val antallEøsSteg: Int,
    val finnesPersonMedAdressebeskyttelse: Boolean,
    val spørsmål: Map<SpørsmålId, Søknadsfelt<Any>>,
    val teksterUtenomSpørsmål: Map<SpørsmålId, Map<Locale, String>>,
    val originalSpråk: Locale,
) : BaSøknadBase

data class Søknaddokumentasjon(
    override val dokumentasjonsbehov: Dokumentasjonsbehov,
    override val harSendtInn: Boolean,
    override val opplastedeVedlegg: List<Søknadsvedlegg>,
    val dokumentasjonSpråkTittel: Map<Locale, String>,
) : BaSøknaddokumentasjon

enum class Dokumentasjonsbehov : BaDokumentasjonsbehov {
    AVTALE_DELT_BOSTED,
    VEDTAK_OPPHOLDSTILLATELSE,
    ADOPSJON_DATO,
    BEKREFTELSE_FRA_BARNEVERN_FOSTERHJEM,
    BEKREFTELSE_FRA_BARNEVERN_BEREDSKAPSHJEM,
    BOR_FAST_MED_SØKER,
    SEPARERT_SKILT_ENKE,
    MEKLINGSATTEST,
    ANNEN_DOKUMENTASJON,
    ;

    override fun tilFellesDokumentasjonsbehov(): BaFellesDokumentasjonsbehov =
        when (this) {
            AVTALE_DELT_BOSTED -> BaFellesDokumentasjonsbehov.AvtaleDeltBosted
            VEDTAK_OPPHOLDSTILLATELSE -> BaFellesDokumentasjonsbehov.VedtakOppholdstillatelse
            ADOPSJON_DATO -> BaFellesDokumentasjonsbehov.AdopsjonDato
            BEKREFTELSE_FRA_BARNEVERN_FOSTERHJEM -> BaFellesDokumentasjonsbehov.BekreftelseFraBarnevernFosterhjem
            BEKREFTELSE_FRA_BARNEVERN_BEREDSKAPSHJEM -> BaFellesDokumentasjonsbehov.BekreftelseFraBarnevernBeredskapshjem
            BOR_FAST_MED_SØKER -> BaFellesDokumentasjonsbehov.BorFastMedSøker
            SEPARERT_SKILT_ENKE -> BaFellesDokumentasjonsbehov.SeparertSkiltEnke
            MEKLINGSATTEST -> BaFellesDokumentasjonsbehov.Meklingsattest
            ANNEN_DOKUMENTASJON -> BaFellesDokumentasjonsbehov.AnnenDokumentasjon
        }
}

data class Søknadsvedlegg(
    override val dokumentId: String,
    override val navn: String,
    override val tittel: Dokumentasjonsbehov,
) : BaSøknadsvedlegg
