package no.nav.familie.kontrakter.felles.dokarkiv

import javax.validation.constraints.NotEmpty

@Deprecated("Bruk v2")
class Dokument(@field:NotEmpty val dokument: ByteArray,
               @field:NotEmpty val filType: FilType,
               val filnavn: String? = null,
               val tittel: String? = null,
               @field:NotEmpty val dokumentType: Dokumenttype)
