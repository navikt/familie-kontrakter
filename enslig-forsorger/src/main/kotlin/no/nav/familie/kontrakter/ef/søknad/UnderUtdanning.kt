package no.nav.familie.kontrakter.ef.søknad

data class UnderUtdanning(val skoleUtdanningssted: Søknadsfelt<String>,
                          val utdanning: Søknadsfelt<Utdanning>,
                          val offentligEllerPrivat: Søknadsfelt<String>,
                          val heltidEllerDeltid: Søknadsfelt<String>,
                          val hvorMyeSkalDuStudere: Søknadsfelt<Int>,
                          val hvaErMåletMedUtdanningen: Søknadsfelt<String>,
                          val utdanningEtterGrunnskolen: Søknadsfelt<Boolean>,
                          val tidligereUtdanninger: Søknadsfelt<List<Utdanning>>? = null)
