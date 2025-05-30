package no.nav.familie.kontrakter.felles.saksbehandler

import java.util.UUID

class Saksbehandler(
    val azureId: UUID,
    val navIdent: String,
    val fornavn: String,
    val etternavn: String,
    val enhet: String,
    val enhetsnavn: String = "",
)

data class SaksbehandlerGruppe(
    val id: String,
    val displayName: String?,
)

data class SaksbehandlerGrupper(
    val value: List<SaksbehandlerGruppe>,
)
