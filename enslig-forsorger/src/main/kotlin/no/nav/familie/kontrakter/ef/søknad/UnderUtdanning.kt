package no.nav.familie.kontrakter.ef.søknad

data class UnderUtdanning(val skoleUtdanningssted: Søknadsfelt<String>,
                          val utdanning: Søknadsfelt<Utdanning>,
                          val offentligEllerPrivat: Søknadsfelt<String>,
                          val `Er utdanningen på heltid eller deltid?`: Søknadsfelt<String>,
                          val `Hvor mye skal du studere?`: Søknadsfelt<Int>,
                          val `Hva er målet med utdanningen?`: Søknadsfelt<String>,
                          val utdanningEtterGrunnskolen: Søknadsfelt<Boolean>,
                          val tidligereUtdanninger: Søknadsfelt<List<Utdanning>>? = null)
