package no.nav.familie.kontrakter.ef.søknad

data class ForelderDto(val kanIkkeOppgiAnnenForelderFar: Spørsmål<Boolean>,
                       val ikkeOppgittAnnenForelderBegrunnelse: Spørsmål<String>,
                       val bosattNorge: Spørsmål<Boolean>,
                       val norskPerson: PersonMinimumDto
)
