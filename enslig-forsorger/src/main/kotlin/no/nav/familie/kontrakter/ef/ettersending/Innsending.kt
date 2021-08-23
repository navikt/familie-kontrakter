package no.nav.familie.kontrakter.ef.ettersending

import no.nav.familie.kontrakter.ef.søknad.Dokument

data class Innsending(val beskrivelse: String,
                      val dokumenttype: String,
                      val vedlegg: List<Dokument>)
