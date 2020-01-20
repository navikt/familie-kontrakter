package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Medlemskapsdetaljer(val bosattNorgeSisteÅrene: Felt<Boolean>,
                               val utenlandsopphold: Felt<List<Utenlandsopphold>>?,
                               val flyktningstatus: Felt<Boolean>?,
                               val flyktningdokumentasjon: Felt<Dokument>?)
