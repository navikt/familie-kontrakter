package no.nav.familie.kontrakter.ef.felles

enum class RegelId(val beskrivelse: String) {

    SLUTT_NODE("SLUTT_NODE"),

    // Medlemskap
    SØKER_MEDLEM_I_FOLKETRYGDEN("Har søker vært medlem i folketrygden i de siste 5 årene?"),
    MEDLEMSKAP_UNNTAK("Er unntak fra hovedreglen oppfylt?"),

    // Opphold
    BOR_OG_OPPHOLDER_SEG_I_NORGE("Bor og oppholder bruker og barna seg i Norge?"),
    OPPHOLD_UNNTAK("Er unntak fra hovedregelen oppfylt?"),

    // Samliv
    LEVER_IKKE_MED_ANNEN_FORELDER("Er vilkåret om å ikke leve sammen med den andre av barnets/barnas foreldre oppfylt?"),
    LEVER_IKKE_I_EKTESKAPLIGNENDE_FORHOLD("Er vilkåret om å ikke leve i et ekteskapslignende forhold i felles husholdning uten felles barn oppfylt?"),

    // Aleneomsorg
    SKRIFTLIG_AVTALE_OM_DELT_BOSTED(""),
    NÆRE_BOFORHOLD(""),
    MER_AV_DAGLIG_OMSORG(""),

    // Mor eller far
    OMSORG_FOR_EGNE_ELLER_ADOPTERTE_BARN("Har bruker omsorgen for egne/adopterte barn?"),

    // Sivilstand
    SAMLIVSBRUDD_LIKESTILT_MED_SEPARASJON("Kan samlivsbrudd likestilles med formell separasjon?"),
    SAMSVAR_DATO_SEPARASJON_OG_FRAFLYTTING("Er det samsvar mellom datoene for separasjon og fraflytting?"),
    KRAV_SIVILSTAND_PÅKREVD_BEGRUNNELSE("Er krav til sivilstand oppfylt?"),
    KRAV_SIVILSTAND_UTEN_PÅKREVD_BEGRUNNELSE("Er krav til sivilstand oppfylt?"),
    SIVILSTAND_UNNTAK("Er unntak fra hovedregelen oppfylt?"),

    // Nytt barn samme partner
    HAR_FÅTT_ELLER_VENTER_NYTT_BARN_MED_SAMME_PARTNER("Bor og oppholder bruker og barna seg i Norge?"),

    // Aktivitet
    FYLLER_BRUKER_AKTIVITETSPLIKT("Fyller bruker aktivitetsplikt, unntak for aktivitetsplikt eller har barn under 1 år?"),

    // Sagt opp arbeidsforhold
    SAGT_OPP_ELLER_REDUSERT("Har søker sagt opp jobben, tatt frivillig permisjon eller redusert arbeidstiden de siste 6 månedene før søknadstidspunktet?"),
    RIMELIG_GRUNN_SAGT_OPP("Hadde søker rimelig grunn til å si opp jobben eller redusere arbeidstiden?"),

    // Tidligere Stønadsperioder
    HAR_TIDLIGERE_MOTTATT_OVERGANSSTØNAD("Har søker tidligere mottatt overgangsstønad?"),
    HAR_TIDLIGERE_ANDRE_STØNADER_SOM_HAR_BETYDNING("Har søker tidligere mottatt andre stønader som har betydning for stønadstiden i §15-8 første og andre ledd?"),

    // Inntekt
    INNTEKT_LAVERE_ENN_INNTEKTSGRENSE("Har brukeren inntekt under 6 ganger grunnbeløpet?"),
    INNTEKT_SAMSVARER_MED_OS("Er inntekten i samsvar med den inntekten som er lagt til grunn ved beregning av overgangsstønad?"),

    // Aktivitet - arbeid
    ER_I_ARBEID_ELLER_FORBIGÅENDE_SYKDOM("Er brukeren i arbeid eller har forbigående sykdom?"),

    // Alder på barn
    HAR_ALDER_LAVERE_ENN_GRENSEVERDI("Har barnet fullført 4. skoleår?"),
    UNNTAK_ALDER("Oppfylles unntak etter å ha fullført 4. skoleår?"),

    // Dokumentasjon tilsynsutgifter
    HAR_DOKUMENTERTE_TILSYNSUTGIFTER("Har brukeren dokumenterte tilsynsutgifter?"),

    // Skolepenger
    RETT_TIL_OVERGANGSSTØNAD("Er vilkårene for rett til overgangsstønad oppfylt?"),
    DOKUMENTASJON_AV_UTDANNING("Er det dokumentert at bruker er under utdanning?"),
    NAVKONTOR_VURDERING("Har NAV kontoret vurdert at utdanning er nødvendig og hensiktsmessig?"),
    SAKSBEHANDLER_VURDERING("Er utdanningen nødvendig og hensiktsmessig?")
    ;
}
