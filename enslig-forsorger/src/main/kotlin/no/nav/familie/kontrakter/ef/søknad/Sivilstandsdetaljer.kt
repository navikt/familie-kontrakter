package no.nav.familie.kontrakter.ef.søknad

import java.time.LocalDate

data class Sivilstandsdetaljer(val erUformeltGift: Søknadsfelt<Boolean>? = null,
                               val erUformeltGiftDokumentasjon: Søknadsfelt<Dokument>? = null,
                               val erUformeltSeparertEllerSkilt: Søknadsfelt<Boolean>? = null,
                               val erUformeltSeparertEllerSkiltDokumentasjon: Søknadsfelt<Dokument>? = null,
                               val søktOmSkilsmisseSeparasjon: Søknadsfelt<Boolean>? = null,
                               val datoSøktSeparasjon: Søknadsfelt<LocalDate>? = null,
                               val separasjonsbekreftelse: Søknadsfelt<Dokument>? = null,
                               val årsakEnslig: Søknadsfelt<String>? = null,
                               val samlivsbruddsdokumentasjon: Søknadsfelt<Dokument>? = null,
                               val samlivsbruddsdato: Søknadsfelt<LocalDate>? = null,
                               val fraflytningsdato: Søknadsfelt<LocalDate>? = null,
                               val endringSamværsordningDato: Søknadsfelt<LocalDate>? = null)
