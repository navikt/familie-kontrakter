package no.nav.familie.kontrakter.felles.søknad

interface BaksSøknadBase {
    val kontraktVersjon: Int
    val søker: BaksSøknadPersonBase
    val barn: List<BaksSøknadPersonBase>

    fun personerISøknad(): List<String> = listOf(søker.fnr).plus(barn.map { it.fnr })
}

interface BaksSøknadPersonBase {
    val ident: Søknadsfelt<String>

    val fnr: String
        get() = ident.verdi.values.first()
}

typealias Locale = String

data class Søknadsfelt<T>(
    val label: Map<Locale, String>,
    val verdi: Map<Locale, T>,
)

class UnsupportedVersionException(
    msg: String,
) : RuntimeException(msg)

class MissingVersionImplementationException(
    msg: String,
) : RuntimeException(msg)
