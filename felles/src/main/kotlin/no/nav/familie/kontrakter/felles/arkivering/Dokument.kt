package no.nav.familie.kontrakter.felles.arkivering

import javax.validation.constraints.NotEmpty

class Dokument(@field:NotEmpty val dokument: ByteArray,
               @field:NotEmpty val filType: FilType,
               val filnavn: String?,
               val tittel: String?,
               @field:NotEmpty val dokumentType: String)
