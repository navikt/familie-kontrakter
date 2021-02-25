package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class Barn(val navn: Søknadsfelt<String>? = null,
                val fødselsnummer: Søknadsfelt<Fødselsnummer>? = null,
                val harSkalHaSammeAdresse: Søknadsfelt<Boolean>,
                val ikkeRegistrertPåSøkersAdresseBeskrivelse: Søknadsfelt<String>?,
                val erBarnetFødt: Søknadsfelt<Boolean>,
                val fødselTermindato: Søknadsfelt<LocalDate>? = null,
                val terminbekreftelse: Søknadsfelt<Dokumentasjon>? = null,
                val annenForelder: Søknadsfelt<AnnenForelder>? = null,
                val samvær: Søknadsfelt<Samvær>? = null,
                val skalHaBarnepass: Søknadsfelt<Boolean>? = null,
                val særligeTilsynsbehov: Søknadsfelt<String>? = null,
                val barnepass: Søknadsfelt<Barnepass>? = null,
                val lagtTilManuelt: Boolean? = false,
                val skalBarnetBoHosSøker: Søknadsfelt<String>? = null)

/**
 * skalHaBarnepass, barnepass gjelder Barnetilsyn
 */
