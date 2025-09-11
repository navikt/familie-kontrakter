package no.nav.familie.kontrakter.ba.søknad.v9

import no.nav.familie.kontrakter.ba.søknad.VersjonertBarnetrygdSøknadV9
import no.nav.familie.kontrakter.ba.søknad.v4.Locale
import no.nav.familie.kontrakter.ba.søknad.v4.SpørsmålId
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadsfelt
import no.nav.familie.kontrakter.ba.søknad.v8.Barn
import no.nav.familie.kontrakter.ba.søknad.v8.Søker
import no.nav.familie.kontrakter.felles.søknad.Søknadsfelt as FellesSøknadsfelt

/**
 * Validator for VersjonertBarnetrygdSøknadV9.
 * Validates that:
 * - Each label in SøknadsFelt is maximum 200 characters in length
 * - Each string value in SøknadsFelt is maximum 200 characters in length
 */
class BarnetrygdSøknadV9Validator {
    /**
     * Represents a validation error in the input.
     *
     * @param objectPath Path to the object that failed validation
     * @param locale The locale of the value that failed validation
     * @param errorMessage Description of the validation error
     */
    data class ValidationError(
        val objectPath: String,
        val locale: Locale,
        val errorMessage: String,
    )

    /**
     * Validates a VersjonertBarnetrygdSøknadV9 instance.
     *
     * @param søknad The søknad to validate
     * @return List of validation errors, empty if no errors
     */
    fun validate(søknad: VersjonertBarnetrygdSøknadV9): List<ValidationError> {
        val errors = mutableListOf<ValidationError>()

        // Get the BarnetrygdSøknad from VersjonertBarnetrygdSøknadV9
        val barnetrygdSøknad = søknad.barnetrygdSøknad

        // Validate spørsmål map
        validateV4SpørsmålMap(barnetrygdSøknad.spørsmål, "spørsmål", errors)

        // Validate søker
        validateSøker(barnetrygdSøknad.søker, errors)

        // Validate barn
        barnetrygdSøknad.barn.forEachIndexed { index, barn ->
            validateBarn(barn, "barn[$index]", errors)
        }

        return errors
    }

    private fun validateV4SpørsmålMap(
        spørsmålMap: Map<SpørsmålId, Søknadsfelt<Any>>,
        basePath: String,
        errors: MutableList<ValidationError>,
    ) {
        spørsmålMap.forEach { (spørsmålId, søknadsfelt) ->
            validateV4Søknadsfelt(søknadsfelt, "$basePath.$spørsmålId", errors)
        }
    }

    private fun validateFellesSpørsmålMap(
        spørsmålMap: Map<String, FellesSøknadsfelt<Any>>,
        basePath: String,
        errors: MutableList<ValidationError>,
    ) {
        spørsmålMap.forEach { (spørsmålId, søknadsfelt) ->
            validateFellesSøknadsfelt(søknadsfelt, "$basePath.$spørsmålId", errors)
        }
    }

    private fun validateSøker(
        søker: Søker,
        errors: MutableList<ValidationError>,
    ) {
        validateFellesSøknadsfelt(søker.navn, "søker.navn", errors)
        validateFellesSøknadsfelt(søker.ident, "søker.ident", errors)

        // Validate søker's spørsmål map
        validateFellesSpørsmålMap(søker.spørsmål, "søker.spørsmål", errors)
    }

    private fun validateBarn(
        barn: Barn,
        basePath: String,
        errors: MutableList<ValidationError>,
    ) {
        validateFellesSøknadsfelt(barn.navn, "$basePath.navn", errors)
        validateFellesSøknadsfelt(barn.ident, "$basePath.ident", errors)

        // Validate barn's spørsmål map
        validateFellesSpørsmålMap(barn.spørsmål, "$basePath.spørsmål", errors)
    }

    private fun validateV4Søknadsfelt(
        søknadsfelt: Søknadsfelt<Any>,
        path: String,
        errors: MutableList<ValidationError>,
    ) {
        // Validate label length
        søknadsfelt.label.forEach { (locale, label) ->
            if (label.length > 200) {
                errors.add(
                    ValidationError(
                        objectPath = "$path.label",
                        locale = locale,
                        errorMessage = "Label exceeds maximum length of 200 characters (actual: ${label.length})",
                    ),
                )
            }
        }

        // Validate string values length
        søknadsfelt.verdi.forEach { (locale, value) ->
            if (value is String && value.length > 200) {
                errors.add(
                    ValidationError(
                        objectPath = "$path.verdi",
                        locale = locale,
                        errorMessage = "String value exceeds maximum length of 200 characters (actual: ${value.length})",
                    ),
                )
            }
        }
    }

    private fun validateFellesSøknadsfelt(
        søknadsfelt: FellesSøknadsfelt<*>,
        path: String,
        errors: MutableList<ValidationError>,
    ) {
        // Validate label length
        søknadsfelt.label.forEach { (locale, label) ->
            if (label.length > 200) {
                errors.add(
                    ValidationError(
                        objectPath = "$path.label",
                        locale = locale,
                        errorMessage = "Label exceeds maximum length of 200 characters (actual: ${label.length})",
                    ),
                )
            }
        }

        // Validate string values length
        søknadsfelt.verdi.forEach { (locale, value) ->
            if (value is String && value.length > 200) {
                errors.add(
                    ValidationError(
                        objectPath = "$path.verdi",
                        locale = locale,
                        errorMessage = "String value exceeds maximum length of 200 characters (actual: ${value.length})",
                    ),
                )
            }
        }
    }
}
