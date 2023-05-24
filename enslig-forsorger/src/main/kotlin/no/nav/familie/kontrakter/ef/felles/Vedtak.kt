package no.nav.familie.kontrakter.ef.felles

enum class Vedtaksresultat(val visningsnavn: String) {
    INNVILGET(visningsnavn = "Innvilget"),
    OPPHØRT(visningsnavn = "Opphørt"),
    AVSLÅTT(visningsnavn = "Avslått"),
}

enum class BehandlingType {
    FØRSTEGANGSBEHANDLING,
    REVURDERING,
    KLAGE,
}

enum class BehandlingÅrsak {
    KLAGE,
    NYE_OPPLYSNINGER,
    SANKSJON_1_MND,
    SØKNAD,
    MIGRERING,
    G_OMREGNING,
    KORRIGERING_UTEN_BREV,
    PAPIRSØKNAD,
    SATSENDRING,
}

enum class OpphørÅrsak {
    PERIODE_UTLØPT,
}

enum class TilkjentYtelseStatus {
    IKKE_KLAR,
    OPPRETTET,
    SENDT_TIL_IVERKSETTING,
    AKTIV,
    AVSLUTTET,
}

enum class Vilkårsresultat(val beskrivelse: String) {
    OPPFYLT("Vilkåret er oppfylt når alle delvilkår er oppfylte"),
    AUTOMATISK_OPPFYLT("Delvilkår er oppfylt med automatisk beregning"),
    IKKE_OPPFYLT("Vilkåret er ikke oppfylt hvis alle delvilkår er oppfylt eller ikke oppfylt, men minimum 1 ikke oppfylt"),
    IKKE_AKTUELL("Hvis søknaden/pdl data inneholder noe som gjør att delvilkåret ikke må besvares"),
    IKKE_TATT_STILLING_TIL("Init state, eller att brukeren ikke svaret på hele delvilkåret"),
    SKAL_IKKE_VURDERES("Saksbehandleren kan sette att ett delvilkår ikke skal vurderes"),
    ;

    fun oppfyltEllerIkkeOppfylt() = this == OPPFYLT || this == IKKE_OPPFYLT
}

enum class VilkårType(val beskrivelse: String) {

    FORUTGÅENDE_MEDLEMSKAP("§15-2 Forutgående medlemskap"),
    LOVLIG_OPPHOLD("§15-3 Lovlig opphold"),

    MOR_ELLER_FAR("§15-4 Mor eller far"),

    SIVILSTAND("§15-4 Sivilstand"),
    SAMLIV("§15-4 Samliv"),
    ALENEOMSORG("§15-4 Aleneomsorg"),
    NYTT_BARN_SAMME_PARTNER("§15-4 Nytt barn samme partner"),
    SAGT_OPP_ELLER_REDUSERT("Sagt opp eller redusert stilling"),
    AKTIVITET("Aktivitet"),
    TIDLIGERE_VEDTAKSPERIODER("Tidligere vedtaksperioder"),

    AKTIVITET_ARBEID("Aktivitet"),
    INNTEKT("§15-10 Inntekt"),
    ALDER_PÅ_BARN("Alder på barn"),
    DOKUMENTASJON_TILSYNSUTGIFTER("Dokumentasjon av tilsynsutgifter"),

    // Skolepenger
    RETT_TIL_OVERGANGSSTØNAD("Er vilkårene for rett til overgangsstønad oppfylt?"),
    DOKUMENTASJON_AV_UTDANNING("Dokumentasjon av utdanning"),
    ER_UTDANNING_HENSIKTSMESSIG("Er utdanning hensiktsmessig?"),
}

enum class AvslagÅrsak {
    VILKÅR_IKKE_OPPFYLT,
    BARN_OVER_ÅTTE_ÅR,
    STØNADSTID_OPPBRUKT,
    MANGLENDE_OPPLYSNINGER,
    MINDRE_INNTEKTSENDRINGER,
}
