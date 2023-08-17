package no.nav.familie.kontrakter.felles.saksbehandler

import java.util.UUID

class Saksbehandler(
    val azureId: UUID,
    val navIdent: String,
    val fornavn: String,
    val etternavn: String,
    val enhet: String,
)
