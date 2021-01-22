package no.nav.familie.kontrakter.felles.journalpost

enum class AvsenderMottakerIdType{
    FNR,
    HPRNR,
    NULL,
    ORGNR,
    UKJENT,
    UTL_ORG
}

data class AvsenderMottaker(val id: String?, val type: AvsenderMottakerIdType?,
                            val navn: String?, val land: String?, val erLikBruker: Boolean)