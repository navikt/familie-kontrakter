package main.kotlin.no.nav.familie.ba

enum class Søknadstype(val tittel: String) {
    IKKE_SATT("SØKNADSTYPE MANGLER"),
    ORDINÆR("Søknad om barnetrygd ordinær - NAV 33-00.07"),
    UTVIDET("Søknad om utvidet barnetrygd - NAV 33-00.09"),
    EØS("Tilleggsskjema ved krav om utbetaling av barnetrygd og/eller kontantstøtte på grunnlag av regler om eksport etter EØS-avtalen - NAV 34-00.15")
}
