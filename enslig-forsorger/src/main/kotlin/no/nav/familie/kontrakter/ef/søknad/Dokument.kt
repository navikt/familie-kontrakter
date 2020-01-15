package no.nav.familie.kontrakter.ef.søknad

import kotlinx.serialization.Serializable

@Serializable
data class Dokument(val fil: Fil,
                    val tittel: String)
