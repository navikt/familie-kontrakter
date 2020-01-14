package no.nav.familie.kontrakter.ef.søknad

data class UnderUtdanning(val skoleUtdanningssted: String,
                          val utdanning: Utdanning,
                          val utdanningEtterGrunnskolen: Spørsmål<Boolean>,
                          val tidligereUtdanninger: List<Utdanning>)