package no.nav.familie.kontrakter.felles.journalpost

enum class AvsenderMottakerIdType{
    NULL,
    FNR,
    ORGNR,
    UKJENT
}

data class AvsenderMottaker(val id: String?, val type: AvsenderMottakerIdType?,
                            val navn: String?, val land: String?, val erLikBruker: Boolean)