package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Medlemskapsdetaljer(val bosattNorgeSisteÅrene: Spørsmål<Boolean>,
                               val utenlandsopphold: List<Utenlandsopphold>?,
                               val flyktningstatus: Spørsmål<Boolean>?,
                               val flyktningdokumentasjon: Dokument?)
