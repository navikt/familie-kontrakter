package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Medlemskapsdetaljer(val oppholderDuDegINorge: Felt<Boolean>,
                               val bosattNorgeSisteÅrene: Felt<Boolean>,
                               val utenlandsopphold: Felt<List<Utenlandsopphold>>? = null,
                               val flyktningstatus: Felt<Boolean>? = null,
                               val flyktningdokumentasjon: Felt<Dokument>? = null)
