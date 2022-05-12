package no.nav.familie.kontrakter.ef.iverksett

enum class SvarId {

    // Felles
    JA,
    NEI,

    // Aleneomsorg
    SAMME_HUS_OG_FÆRRE_ENN_4_BOENHETER,
    SAMME_HUS_OG_FLERE_ENN_4_BOENHETER_MEN_VURDERT_NÆRT,
    SELVSTENDIGE_BOLIGER_SAMME_GÅRDSTUN,
    SELVSTENDIGE_BOLIGER_SAMME_TOMT,
    NÆRMESTE_BOLIG_ELLER_REKKEHUS_I_SAMMEGATE,
    TILSTØTENDE_BOLIGER_ELLER_REKKEHUS_I_SAMMEGATE,

    // Forutgående medlemskap
    MEDLEM_MER_ENN_5_ÅR_AVBRUDD_MINDRE_ENN_10_ÅR,
    MEDLEM_MER_ENN_7_ÅR_AVBRUDD_MER_ENN_10ÅR,
    I_LANDET_FOR_GJENFORENING_ELLER_GIFTE_SEG,
    ANDRE_FORELDER_MEDLEM_SISTE_5_ÅR,
    ANDRE_FORELDER_MEDLEM_MINST_5_ÅR_AVBRUDD_MINDRE_ENN_10_ÅR,
    ANDRE_FORELDER_MEDLEM_MINST_7_ÅR_AVBRUDD_MER_ENN_10_ÅR,
    TOTALVURDERING_OPPFYLLER_FORSKRIFT,

    // Opphold
    ARBEID_NORSK_ARBEIDSGIVER,
    UTENLANDSOPPHOLD_MINDRE_ENN_6_UKER,

    // Sivilstand
    GJENLEVENDE_IKKE_RETT_TIL_YTELSER,
    GJENLEVENDE_OVERTAR_OMSORG,

    // Aktivitet i arbeid
    ER_I_ARBEID,
    ETABLERER_EGEN_VIRKSOMHET,
    HAR_FORBIGÅENDE_SYKDOM,

    // Alder på barn
    TRENGER_MER_TILSYN_ENN_JEVNALDRENDE,
    FORSØRGER_HAR_LANGVARIG_ELLER_UREGELMESSIG_ARBEIDSTID,

    // Inntekt
    NOEN_MÅNEDER_OVERSTIGER_6G
}