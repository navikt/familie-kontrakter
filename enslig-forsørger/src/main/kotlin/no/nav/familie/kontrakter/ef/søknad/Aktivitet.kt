package no.nav.familie.kontrakter.ef.søknad

data class Aktivitet(val hvordanErArbeidssituasjonen: Spørsmål<List<String>>,
                     val arbeidsforhold: List<Arbeidsgiver>,
                     val selvstendig: Selvstendig,
                     val virksomhet: Virksomhet,
                     val arbeidssøker: Arbeidssøker,
                     val underUtdanning: UnderUtdanning)

