package no.nav.familie.kontrakter.felles.oppgave

import java.time.LocalDate

data class OpprettOppgaveRequest(val ident: OppgaveIdentV2?,
                                 val enhetsnummer: String?,
                                 val saksId: String?,
                                 val journalpostId: String? = null,
                                 val tema: Tema,
                                 val oppgavetype: Oppgavetype,
                                 val behandlingstema: String?,
                                 val tilordnetRessurs: String? = null,
                                 val fristFerdigstillelse: LocalDate,
                                 val aktivFra: LocalDate = LocalDate.now(),
                                 val beskrivelse: String,
                                 val prioritet: OppgavePrioritet = OppgavePrioritet.NORM,
                                 val behandlingstype: String? = null)

enum class Oppgavetype(val value: String) {
    BehandleSak("BEH_SAK"),
    Journalføring("JFR"),
    GodkjenneVedtak("GOD_VED"),
    BehandleUnderkjentVedtak("BEH_UND_VED"),
    Fordeling("FDR"),
    BehandleReturpost("RETUR"),
    BehandleSED("BEH_SED"),
    BehandleUderkjentVedtak("BEH_UND_VED"),
    FordelingSED("FDR_SED"),
    Fremlegg("FREM"),
    Generell("GEN"),
    InnhentDokumentasjon("INNH_DOK"),
    JournalføringUtgående("JFR_UT"),
    KontaktBruker("KONT_BRUK"),
    KontrollerUtgåendeSkannetDokument("KON_UTG_SCA_DOK"),
    SvarIkkeMottatt("SVAR_IK_MOT"),
    VurderDokument("VUR"),
    VurderHenvendelse("VURD_HENV"),
    VurderKonsekvensForYtelse("VUR_KONS_YTE"),
    VurderSvar("VUR_SVAR"),
}

enum class Behandlingstema(val value: String) {
    Barnetrygd("ab0270"),
    BarnetrygdEØS("ab0058"),
    OrdinærBarnetrygd("ab0180"),
    UtvidetBarnetrygd("ab0096"),
    Skolepenger("ab0177"),
    Barnetilsyn("ab0028"),
    Overgangsstønad("ab0071")
}

enum class Behandlingstype(val value: String) {
    Utland("ae0106")
}

enum class OppgavePrioritet {
    HOY,
    NORM,
    LAV;
}

enum class Enhetsmappe(val value: Long){
    SøknaderKlarTilBehandling(100000035),
    AvventerDokumentasjon(100000036),
    KlagerKlarTilBehandling(100000037),
    RevurderingKlarTilBehandling(100000038),
    Revurdering(100000039),
    OppfølgingAvSkolesaker(100024196),
    TilbakekrevingKlarTilBehandling(100000266),
    Flyttesaker(100024195),
    EØSMedlemskap(100025358),
    Corona(100025133);
}