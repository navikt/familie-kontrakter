package no.nav.familie.kontrakter.ef.infotrygd

import no.nav.familie.kontrakter.ef.felles.StønadType
import java.time.LocalDate

@Suppress("unused")
data class InfotrygdSakResponse(
        val saker: List<InfotrygdSak>
)

data class InfotrygdSak(
    val personIdent: String,
    val id: Long? = null,
    val saksnr: String? = null,
    val saksblokk: String? = null,
    val registrertDato: LocalDate? = null,
    val mottattDato: LocalDate? = null,
    val kapittelnr: String? = null,
    val stønadType: StønadType,
    val undervalg: InfotrygdSakUndervalg? = null,
    val type: InfotrygdSakType? = null,
    val nivå: InfotrygdSakNivå? = null,
    val resultat: InfotrygdSakResultat,
    val vedtaksdato: LocalDate? = null,
    val iverksattdato: LocalDate? = null,
    val årsakskode: String? = null,
    val behandlendeEnhet: String? = null,
    val registrertAvEnhet: String? = null,
    val tkNr: String? = null,
    val region: String? = null,
)

@Suppress("unused")
enum class InfotrygdSakType(val infotrygdKode: String, val beskrivelse: String) {

    ANKE("A", "Anke"),
    DISPENSASJON_FORELDELSE("DF", "Dispensasjon foreldelse"),
    DOKUMENTINNSYN("DI", "Dokumentinnsyn"),
    ETTERLYSE_GIROKORT("EG", "Etterlyse girokort"),
    FORESPØRSEL("FS", "Forespørsel"),
    GRUNNBELØP_OMREGNING_OVERGANGSSTØNAD("GO", "Grunnbeløp omregning (manuell G-omregning) Overgangsstønad"),
    INFORMASJONSSAK("I", "Informasjonssak"),
    JOURNALSAK("J", "Journalsak"),
    JOURNALSAK_PRIVATPERSON("JP", "Journalsak fra privatperson"),
    JOURNALSAK_TRYGDEKONTOR("JT", "Journalsak fra trygdekontor"),
    JOURNALSAK_UTENL("JU", "Journalsak fra utenl trm"), // 0
    KLAGE("K", "Klage"),
    KLAGE_AVREGNING("KA", "Klage avregning"),
    KLAGE_ETTERGIVELSE("KE", "Klage ettergivelse"),
    KONVERTERING("KO", "Konvertering, de som ble lagt inn da rutinen ble lagt over til DB2"),
    KONTROLLSAK("KS", "Kontrollsak"),
    KLAGE_TILBAKEBETALING("KT", "Klage tilbakebetaling"),
    MASKINELL_G_OMREGNING("MG", "Maskinell G-omregning (Årlig G-reg. overgangsstønad)"),
    MASKINELL_SATSOMREGNING("MS", "Maskinell Satsomregning (Årlig satsendring Barnetilsyn)"),
    REVURDERING("R", "Revurdering"),
    SØKNAD("S", "Søknad"),
    SØKNAD_ETTERGIVELSE("SE", "Søknad om ettergivelse"),
    STRAFFERETTSLIG_VURDERING("SV", "Strafferettslig vurdering"),
    SØKNAD_ØKNING_ENDRING("SØ", "Søknad om økning/endring"),
    TILBAKEBETALINGSSAK("T", "Tilbakebetalingssak"),
    TILBAKEBETALING_AVREGNING("TA", "Tilbakebetaling avregning"),
    TILBAKEBETALING_ENDRING("TE", "Tilbakebetaling endring"),
    TIPSUTREDNING("TU", "Tipsutredning"),
    UTBETALING_TIL_ANNEN("UA", "Utbetaling til annen"),
    VURDERING_UTESTENGING("VU", "Vurdering utestenging");

}

@Suppress("unused")
enum class InfotrygdSakResultat(val infotrygdKode: String, val beskrivelse: String) {
    ÅPEN_SAK("", "Åpen sak"), // Denne er alltså blank, den har ikke verdiet blank
    AVSLAG("A", "Avslag"),
    AVSLAG_GODKJENT("AG", "Avslag godkjent"),
    AVVIST_KLAGE("AK", "Avvist klage"),
    ANNULLERING("AN", "Annullering"),
    ADVARSEL("AV", "Advarsel"),
    DELVIS_GODKJENT("DG", "Delvis godkjent"),
    DELVIS_INNVILGET("DI", "Delvis innvilget"),
    DELVIS_TILBAKEBETALE("DT", "Delvis tilbakebetale"),
    FERDIG_BEHANDLET("FB", "Ferdig behandlet"),
    FORTSATT_INNVILGET("FI", "Fortsatt innvilget"),
    GODKJENT("GK", "Godkjent"),
    HENLAGT_TRUKKET_TILBAKE("H", "Henlagt / trukket tilbake"),
    HENLAGT_BORTFALT("HB", "Henlagt / bortfalt"),
    INNVILGET("I", "Innvilget"),
    IKKE_BEHANDLET("IB", "Ikke behandlet"),
    INNVILGET_NY_SITUASJON("IN", "Innvilget ny situasjon"),
    IKKE_STRAFFBART("IS", "Ikke straffbart"),
    IKKE_TILBAKEBETALE("IT", "Ikke tilbakebetale"),
    IU("IU", ""), // TODO
    KLAGE("K", "Klage"),
    MIDLERTIDIG_OPPHØRT("MO", "Midlertidig opphørt"),
    HJEMVIST_FOR_NY_BEHANDLING("NB", "Hjemvist for ny behandling"),
    OPPHØRT("O", "Opphørt"),
    POLITIANMELDELSE("PA", "Politianmeldelse"),
    REDUSERT("R", "Redusert"),
    TILBAKEBETALE("TB", "Tilbakebetale"),
    TVANGSGEBYR_FASTHOLDES("TF", "Tvangsgebyr fastholdes"),
    TIPS_OPPFØLGING("TO", "Tips oppfølging"),
    VU("VU", ""), // TODO
    ØKNING("Ø", "Økning")
    ;
}

@Suppress("unused")
enum class InfotrygdSakNivå(val infotrygdKode: String, val beskrivelse: String) {

    AN("AN", ""),
    FOLKETRYGDKONTORET_FOR_UTENLANDSSAKER("FFU", "Folketrygdkontoret for utenlandssaker"),
    HTF("HTF", ""),
    KLAGE_ANKE("KA", "Klage/anke"),
    KI("KI", ""),
    RIKSTRYGDEVERKET("RTV", "Rikstrygdeverket"),
    SFK("SFK", ""),
    NAV_KONTOR("TK", "NAV-kontor (trygdekontor)"),
    TRYGDERETTEN("TR", "Trygderetten"),
    ;
}

/*
Disse mappes til ulike verdier beroende på hvilken typ av stønad det gjelder
https://confluence.adeo.no/display/MODNAV/EF+i+Sak-rutinen#
 */
@Suppress("unused")
enum class InfotrygdSakUndervalg {
    AK,
    NY,
    OL,
    OR
}
