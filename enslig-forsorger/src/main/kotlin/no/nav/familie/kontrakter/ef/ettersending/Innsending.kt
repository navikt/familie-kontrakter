package no.nav.familie.kontrakter.ef.ettersending

data class Innsending(val beskrivelse: String,
                      val dokumenttype: String,
                      val vedlegg: no.nav.familie.kontrakter.ef.søknad.Dokument
)
