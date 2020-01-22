
package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class KommendeBarn(val navn: Søknadsfelt<String>,
                        val fnr: Søknadsfelt<Fødselsnummer>? = null,
                        val erBarnetFødt: Søknadsfelt<Boolean>,
                        val terminbekreftelse: Søknadsfelt<Dokument>? = null,
                        val fødselTermindato: Søknadsfelt<LocalDate>,
                        val skalBarnetBoHosSøker: Søknadsfelt<Boolean>,
                        val annenForelder: Søknadsfelt<Forelder>? = null,
                        val samvær: Søknadsfelt<Samvær>? = null)
