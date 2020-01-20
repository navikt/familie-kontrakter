package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Aktivitet(val hvordanErArbeidssituasjonen: Felt<List<String>>,
                     val arbeidsforhold: Felt<List<Arbeidsgiver>>? = null,
                     val selvstendig: Felt<Selvstendig>? = null,
                     val virksomhet: Felt<Virksomhet>? = null,
                     val arbeidssøker: Felt<Arbeidssøker>? = null,
                     val underUtdanning: Felt<UnderUtdanning>? = null)

