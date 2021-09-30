package no.nav.familie.kontrakter.ef.infotrygd

import no.nav.familie.kontrakter.ef.felles.StønadType
import java.time.LocalDate

/**
 * @param personIdenter alle identer til personen
 */
data class InfotrygdPerioderArenaRequest(val personIdenter: Set<String>,
                                         val fomDato: LocalDate? = null,
                                         val tomDato: LocalDate? = null)

data class InfotrygdPerioderArenaResponse(val perioder: List<InfotrygdArenaPeriode>)

data class InfotrygdArenaPeriode(val personIdent: String,
                                 val fomDato: LocalDate,
                                 val tomDato: LocalDate,
                                 val beløp: Float,
                                 val opphørsdato: LocalDate? = null)

data class InfotrygdPeriodeRequest(val personIdenter: Set<String>,
                                   val stønadstyper: Set<StønadType>)

data class InfotrygdPeriodeResponse(val overgangsstønad: List<InfotrygdPeriode>,
                                    val barnetilstyn: List<InfotrygdPeriode>,
                                    val skolepenger: List<InfotrygdPeriode>)

data class InfotrygdPeriode(val personIdent: String,
                            val kode: InfotrygdEndringKode,
                            val brukerId: String,
                            val stønadId: Long,
                            val vedtakId: Long,
                            val stønadBeløp: Int,
                            val inntektsreduksjon: Int,
                            val samordningsfradrag: Int,
                            val beløp: Int,
                            val startDato: LocalDate,
                            val stønadFom: LocalDate,
                            val stønadTom: LocalDate,
                            val opphørsdato: LocalDate?)

@Suppress("unused")
enum class InfotrygdEndringKode(val kode: String, val beskrivelse: String) {

    ANNULERT("AN", "Annullert"),
    ENDRING_BEREGNINGSGRUNNLAG("E", "Endring i beregningsgrunnlag"),
    FØRSTEGANGSVEDTAK("F", "Førstegangsvedtak"),
    G_REGULERING("G", "G-regulering"),
    NY("NY", "Ny"),
    OPPHØRT("O", "Opphørt"),
    SATSENDRING("S", "Satsendring"),
    UAKTUELL("UA", "Uaktuell"),
    OVERTFØRT_NY_LØSNING("OO", "Overf ny løsning")
}
