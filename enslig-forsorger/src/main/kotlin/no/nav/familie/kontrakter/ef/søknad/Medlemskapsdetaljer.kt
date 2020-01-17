package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Medlemskapsdetaljer(val oppholderDuDegINorge: Spørsmål<Boolean>,
                               val bosattNorgeSisteÅrene: Spørsmål<Boolean>,
                               val utenlandsopphold: List<Utenlandsopphold>? = null,
                               val flyktningstatus: Spørsmål<Boolean>? = null,
                               val flyktningdokumentasjon: Dokument? = null)
