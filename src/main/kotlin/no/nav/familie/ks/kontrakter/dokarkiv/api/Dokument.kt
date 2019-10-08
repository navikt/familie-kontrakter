package no.nav.familie.ks.kontrakter.dokarkiv.api

import javax.validation.constraints.NotEmpty

class Dokument(
    @param:NotEmpty
    @field:NotEmpty
    val dokument: ByteArray,

    @param:NotEmpty
    @field:NotEmpty
    val filType: FilType,

    val filnavn: String,

    @param:NotEmpty
    @field:NotEmpty
    val dokumentType: DokumentType
)
