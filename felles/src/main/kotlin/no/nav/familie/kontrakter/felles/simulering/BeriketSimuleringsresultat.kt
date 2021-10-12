package no.nav.familie.ef.iverksett.økonomi.simulering

import no.nav.familie.kontrakter.felles.simulering.DetaljertSimuleringResultat

data class BeriketSimuleringsresultat(
        val detaljer: DetaljertSimuleringResultat,
        val oppsummering: Simuleringsoppsummering)
