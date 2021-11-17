package no.nav.familie.kontrakter.ef.iverksett


data class VergeDto(val ident: String, val navn: String, val vergetype: Vergetype)
enum class Vergetype(val navn: String) {
    VOKSEN("Verge for voksen")
}
