package no.nav.familie.kontrakter.felles.journalpost

data class TilgangsstyrtJournalpost(
    val journalpost: Journalpost,
    val journalpostTilgang: JournalpostTilgang,
)

data class JournalpostTilgang(
    val harTilgang: Boolean,
    val begrunnelse: String? = null,
)
