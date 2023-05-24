package no.nav.familie.kontrakter.ba

@Deprecated(
    "Byttet ut med v4 da EØS ikke er en egen søknadstype",
    ReplaceWith("no.nav.familie.kontrakter.ba.søknad.v4.Søknadstype"),
)
enum class Søknadstype(val tittel: String, val søknadskode: String) {
    IKKE_SATT("SØKNADSTYPE MANGLER", "SØKNADSTYPE MANGLER"),
    ORDINÆR("Søknad om barnetrygd ordinær", "NAV 33-00.07"),
    UTVIDET("Søknad om utvidet barnetrygd", "NAV 33-00.09"),
    EØS("Tilleggsskjema ved krav om utbetaling av barnetrygd og/eller kontantstøtte på grunnlag av regler om eksport etter EØS-avtalen", "NAV 34-00.15"),
}
