package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Aktivitet(val hvordanErArbeidssituasjonen: Felt<List<String>>,
                     val arbeidsforhold: Felt<List<Arbeidsgiver>>?,
                     val selvstendig: Felt<Selvstendig>?,
                     val virksomhet: Felt<Virksomhet>?,
                     val arbeidssøker: Felt<Arbeidssøker>?,
                     val underUtdanning: Felt<UnderUtdanning>?)

