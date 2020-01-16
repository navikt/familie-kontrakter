package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Aktivitet(val hvordanErArbeidssituasjonen: Spørsmål<List<String>>,
                     val arbeidsforhold: List<Arbeidsgiver>?,
                     val selvstendig: Selvstendig?,
                     val virksomhet: Virksomhet?,
                     val arbeidssøker: Arbeidssøker?,
                     val underUtdanning: UnderUtdanning?)

