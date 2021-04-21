package no.nav.familie.kontrakter.felles.dokarkiv.v2

import no.nav.familie.kontrakter.felles.dokarkiv.Dokumenttype
import javax.validation.constraints.NotEmpty

class Dokument(@field:NotEmpty val dokument: ByteArray,
               @field:NotEmpty val filtype: Filtype,
               val filnavn: String? = null,
               val tittel: String? = null,
               @field:NotEmpty val dokumenttype: Dokumenttype)

