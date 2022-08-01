package no.nav.familie.kontrakter.ef.infotrygd

import no.nav.familie.kontrakter.felles.ef.StønadType
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * @param personIdenter alle identer til personen
 */
data class InfotrygdPerioderArenaRequest(
    val personIdenter: Set<String>,
    val fomDato: LocalDate? = null,
    val tomDato: LocalDate? = null
)

data class InfotrygdPerioderArenaResponse(val perioder: List<InfotrygdArenaPeriode>)

data class InfotrygdArenaPeriode(
    val personIdent: String,
    val fomDato: LocalDate,
    val tomDato: LocalDate,
    val beløp: Float,
    val opphørsdato: LocalDate? = null
)

data class InfotrygdPeriodeRequest(
    val personIdenter: Set<String>,
    val stønadstyper: Set<StønadType>
)

data class InfotrygdPeriodeResponse(
    val overgangsstønad: List<InfotrygdPeriode>,
    val barnetilsyn: List<InfotrygdPeriode>,
    val skolepenger: List<InfotrygdPeriode>
)

/**
 * @param kodeOvergangsstønad er i prinsipp det vi kaller periodetype i ny løsning
 */
data class InfotrygdPeriode(
    val personIdent: String,
    val sakstype: InfotrygdSakstype,
    val kode: InfotrygdEndringKode,
    val kodeOvergangsstønad: InfotrygdOvergangsstønadKode?,
    val aktivitetstype: InfotrygdAktivitetstype?,
    val brukerId: String,
    val stønadId: Long,
    val vedtakId: Long,
    val vedtakstidspunkt: LocalDateTime,
    val engangsbeløp: Int,
    val inntektsgrunnlag: Int,
    val inntektsreduksjon: Int,
    val samordningsfradrag: Int,
    val utgifterBarnetilsyn: Int,
    val månedsbeløp: Int,
    val startDato: LocalDate,
    @Deprecated("Bruk stønadsperiode!", ReplaceWith("stønadsperiode.fomDato")) val stønadFom: LocalDate? = null,
    @Deprecated("Bruk stønadsperiode!", ReplaceWith("stønadsperiode.tomDato")) val stønadTom: LocalDate? = null,
    val stønadsperiode: no.nav.familie.kontrakter.felles.Periode? = null,
    val opphørsdato: LocalDate?,
    val barnIdenter: List<String> = emptyList()
) {
    init {
        require(stønadsperiode != null || (stønadFom != null && stønadTom != null)) { "Periode mangler verdi!" }
    }

    fun periode(): no.nav.familie.kontrakter.felles.Periode = stønadsperiode ?: no.nav.familie.kontrakter.felles.Periode(
        this.stønadFom!!,
        this.stønadTom!!
    )
}

@Suppress("unused")
enum class InfotrygdEndringKode(val infotrygdKode: String, val beskrivelse: String) {

    ANNULERT("AN", "Annullert"),
    ENDRING_BEREGNINGSGRUNNLAG("E", "Endring i beregningsgrunnlag"),
    FØRSTEGANGSVEDTAK("F", "Førstegangsvedtak"),
    G_REGULERING("G", "G-regulering"),
    NY("NY", "Ny"),
    OPPHØRT("O", "Opphørt"),
    SATSENDRING("S", "Satsendring"),
    UAKTUELL("UA", "Uaktuell"),
    OVERTFØRT_NY_LØSNING("OO", "Overf ny løsning");
}

@Suppress("unused")
enum class InfotrygdSakstype(val infotrygdKode: String, val beskrivelse: String) {

    KLAGE("K", "Klage"),
    MASKINELL_G_OMREGNING("MG", "Maskinell G-omregning"),
    REVURDERING("R", "Revurdering"),
    GRUNNBELØP_OMREGNING("GO", "Grunnbeløp omregning"),
    KONVERTERING("KO", "Konvertering"),
    MASKINELL_SATSOMREGNING("MS", "Maskinell satsomregning"),
    ANKE("A", "Anke"),
    SØKNAD("S", "Søknad"),
    SØKNAD_ØKNING_ENDRING("SØ", "Søknad om økning/endring")
}

@Suppress("unused")
enum class InfotrygdOvergangsstønadKode(val infotrygdKode: String, val beskrivelse: String) {

    BARN_UNDER_1_3_ÅR("1", "Barn under 1 år / 3 år (gamle tilfeller)"),
    YRKESRETTET_AKTIVITET_BARN_FYLT_1_3_ÅR("2", "Er i yrkesrettet aktivitet - barn har fylt 1 år / 3 år (gamle tilfeller)"),
    UNNTAK_FRA_KRAV_TIL_YRKESRETTET_AKTIVITET(
        "3",
        "Unntak fra krav til yrkesr. aktivitet når barn har fylt 1 år / år (gamle tilfeller)"
    ),
    UTVIDELSE_NØDVENDIG_UTDANNING("4", "Utvidelse på grunn av nødvendig utdanning jf 15-6. 3. ledd"),
    PÅVENTE_SKOLESTART_ARBEID_TILSYNSPLASS("5", "I påvente av skolestart/arbeid/tilsynsplass 15-6. 4. ledd"),
    YRKESRETTET_AKTIVITET("6", "Er i yrkesrettet aktivitet - i omstillingstid"),
    FORBIGÅENDE_SYKDOM("7", "Forbig. sykdom hos forsørger eller barnet 15-6. 6. ledd"),
    SÆRLIG_TILSSYNSKREVENDE_BARN("8", "Har særlig tilssynskrevende barn"),
    ETABLERER_EGEN_VIRKSOMHET("9", "Etablerer egen virksomhet"),
    FORTSATT_INNVILGET_TROSS_VARSEL_OM_OPPHØR_PGA_SAMBOER("10", "Fortsatt innvilget tro");
}

@Suppress("unused")
enum class InfotrygdAktivitetstype(val infotrygdKode: String, val beskrivelse: String) {

    I_ARBEID("A", "I arbeid"),
    I_UTDANNING("U", "I utdanning"),
    TILMELDT_SOM_REELL_ARBEIDSSØKER("S", "Tilmeldt som reell arbeidssøker"),
    KURS("K", "Kurs o.l."),
    BRUKERKONTAKT("B", "Brukerkontakt"),
    IKKE_I_AKTIVITET("N", "Ikke i aktivitet");
}
