package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Aktivitet(val hvordanErArbeidssituasjonen: Spørsmål<List<String>>,
                     val arbeidsforhold: List<Arbeidsgiver>? = null,
                     val selvstendig: Selvstendig? = null,
                     val virksomhet: Virksomhet? = null,
                     val arbeidssøker: Arbeidssøker? = null,
                     val underUtdanning: UnderUtdanning? = null)

