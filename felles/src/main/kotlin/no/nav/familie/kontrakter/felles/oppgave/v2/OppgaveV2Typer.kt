package no.nav.familie.kontrakter.felles.oppgave.v2

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Kategorisering(
    val tema: Kodeverk,
    val oppgavetype: Kodeverk,
    val behandlingstema: Kodeverk? = null,
    val behandlingstype: Kodeverk? = null,
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Kodeverk(
    val kode: String,
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Enhet(
    val nr: String,
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Mappe(
    val id: Long,
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Medarbeider(
    val navident: String,
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Bruker(
    val ident: String,
    val type: Brukertype,
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Arkivreferanse(
    val saksnr: String? = null,
    val journalpostId: String? = null,
)

enum class Prioritet {
    LAV,
    NORMAL,
    HOY,
    KRITISK,
}

enum class Brukertype {
    PERSON,
    ARBEIDSGIVER,
    SAMHANDLER,
}
