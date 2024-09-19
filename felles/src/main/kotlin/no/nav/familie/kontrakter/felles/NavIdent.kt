package no.nav.familie.kontrakter.felles

data class NavIdent(
    val ident: String,
) {
    init {
        if (ident.isBlank()) {
            throw IllegalArgumentException("Ident kan ikke være tom")
        }
    }
}
