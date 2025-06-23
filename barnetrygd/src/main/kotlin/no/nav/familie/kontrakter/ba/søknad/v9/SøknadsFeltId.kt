package no.nav.familie.kontrakter.ba.søknad.v9

// Legger inn felter ved behov, støtter ikke alle felter
enum class SøknadsFeltId(val verdiIKontrakt: String) {
    BOR_PÅ_REGISTRERT_ADRESSE("borPåRegistrertAdresse"),
    VÆRT_I_NORGE_I_TOLV_MÅNEDER("værtINorgeITolvMåneder"),
    PLANLEGGER_Å_BO_I_NORGE_12_MND_BARN("planleggerÅBoINorge12Mnd"),
    PLANLEGGER_Å_BO_I_NORGE_12_MND_SØKER("planleggerÅBoINorgeTolvMnd"),
    UTENLANDSOPPHOLD_ÅRSAK("utenlandsoppholdÅrsak"),
    OPPHOLDSLAND("oppholdsland"),
    OPPHOLDSLAND_FRA_DATO("oppholdslandFraDato"),
    OPPHOLDSLAND_TIL_DATO("oppholdslandTilDato"),
    ER_ADOPTERT_FRA_UTLAND("erAdoptertFraUtland"),
    BODD_MINDRE_ENN_12_MND_I_NORGE("boddMindreEnn12MndINorge"),
    ER_BARN_ADOPTERT_FRA_UTLAND("erBarnAdoptertFraUtland"),
}
