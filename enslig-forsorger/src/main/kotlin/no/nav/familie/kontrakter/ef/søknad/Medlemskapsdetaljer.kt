package no.nav.familie.kontrakter.ef.søknad

data class Medlemskapsdetaljer(val oppholderDuDegINorge: Søknadsfelt<Boolean>,
                               val bosattNorgeSisteÅrene: Søknadsfelt<Boolean>,
                               val utenlandsopphold: Søknadsfelt<List<Utenlandsopphold>>? = null,
                               val flyktningstatus: Søknadsfelt<Boolean>? = null,
                               val flyktningdokumentasjon: Søknadsfelt<Dokument>? = null)
