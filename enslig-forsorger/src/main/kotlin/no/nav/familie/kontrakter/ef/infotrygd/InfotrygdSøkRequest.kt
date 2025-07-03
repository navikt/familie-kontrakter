package no.nav.familie.kontrakter.ef.infotrygd

/**
 * @param personIdenter alle identer til personen
 */
data class InfotrygdSøkRequest(
    val personIdenter: Set<String>,
)
