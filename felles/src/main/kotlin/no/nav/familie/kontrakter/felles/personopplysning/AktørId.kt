package no.nav.familie.kontrakter.felles.personopplysning

import java.util.regex.Pattern

/**
 * Id som genereres fra NAV Aktør Register. Denne iden benyttes til interne forhold i Nav og vil ikke endres f.eks. dersom bruker
 * går fra DNR til FNR i Folkeregisteret. Tilsvarende vil den kunne referere personer som har ident fra et utenlandsk system.
 */
data class AktørId(val id: String) {

    init {
        require(VALID.matcher(id).matches()) {
            // skal ikke skje, funksjonelle feilmeldinger håndteres ikke her.
            "Ugyldig aktørId, støtter kun A-Z/0-9/:/-/_ tegn. Var: " + id.replace(INVALID.pattern().toRegex(),
                                                                                  "?") +
            " (vasket)"
        }
    }

    companion object {
        private const val CHARS = "a-z0-9_:-"
        private const val VALID_REGEXP = "^(-?[1-9]|[a-z0])[$CHARS]*$"
        private const val INVALID_REGEXP = "[^$CHARS]+"
        private val VALID = Pattern.compile(VALID_REGEXP, Pattern.CASE_INSENSITIVE)
        private val INVALID = Pattern.compile(INVALID_REGEXP, Pattern.DOTALL or Pattern.CASE_INSENSITIVE)
    }
}