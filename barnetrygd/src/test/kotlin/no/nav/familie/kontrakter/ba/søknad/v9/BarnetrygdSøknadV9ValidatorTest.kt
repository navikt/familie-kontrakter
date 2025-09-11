package no.nav.familie.kontrakter.ba.søknad.v9

import no.nav.familie.kontrakter.ba.søknad.VersjonertBarnetrygdSøknadV9
import no.nav.familie.kontrakter.ba.søknad.v4.SpørsmålId
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadsfelt
import no.nav.familie.kontrakter.ba.søknad.v8.Barn
import no.nav.familie.kontrakter.ba.søknad.v8.Søker
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import no.nav.familie.kontrakter.felles.søknad.Søknadsfelt as FellesSøknadsfelt

class BarnetrygdSøknadV9ValidatorTest {
    @Test
    fun `validate should return empty list when all fields are valid`() {
        val søknad = createValidSøknad()
        val validator = BarnetrygdSøknadV9Validator()

        val errors = validator.validate(søknad)

        assertTrue(errors.isEmpty(), "Expected no validation errors")
    }

    @Test
    fun `validate should return errors when label exceeds max length`() {
        val søknad = createSøknadWithInvalidLabel()
        val validator = BarnetrygdSøknadV9Validator()

        val errors = validator.validate(søknad)

        assertEquals(1, errors.size, "Expected one validation error")
        assertEquals("spørsmål.invalidLabel.label", errors[0].objectPath)
        assertEquals("nb", errors[0].locale)
        assertTrue(errors[0].errorMessage.contains("Label exceeds maximum length"))
    }

    @Test
    fun `validate should return errors when string value exceeds max length`() {
        val søknad = createSøknadWithInvalidStringValue()
        val validator = BarnetrygdSøknadV9Validator()

        val errors = validator.validate(søknad)

        assertEquals(1, errors.size, "Expected one validation error")
        assertEquals("spørsmål.invalidValue.verdi", errors[0].objectPath)
        assertEquals("nb", errors[0].locale)
        assertTrue(errors[0].errorMessage.contains("String value exceeds maximum length"))
    }

    private fun createValidSøknad(): VersjonertBarnetrygdSøknadV9 {
        val spørsmål =
            mapOf<SpørsmålId, Søknadsfelt<Any>>(
                "validQuestion" to
                    Søknadsfelt(
                        label = mapOf("nb" to "Valid label"),
                        verdi = mapOf("nb" to "Valid value"),
                    ),
            )

        val søker =
            Søker(
                ident =
                    FellesSøknadsfelt(
                        label = mapOf("nb" to "Fødselsnummer"),
                        verdi = mapOf("nb" to "12345678910"),
                    ),
                harEøsSteg = false,
                navn =
                    FellesSøknadsfelt(
                        label = mapOf("nb" to "Navn"),
                        verdi = mapOf("nb" to "Test Testesen"),
                    ),
                statsborgerskap =
                    FellesSøknadsfelt(
                        label = mapOf("nb" to "Statsborgerskap"),
                        verdi = mapOf("nb" to listOf("NOR")),
                    ),
                adresse =
                    FellesSøknadsfelt(
                        label = mapOf("nb" to "Adresse"),
                        verdi = mapOf("nb" to null),
                    ),
                adressebeskyttelse = false,
                sivilstand =
                    FellesSøknadsfelt(
                        label = mapOf("nb" to "Sivilstand"),
                        verdi = mapOf("nb" to no.nav.familie.kontrakter.ba.søknad.v1.SIVILSTANDTYPE.UGIFT),
                    ),
                spørsmål = mapOf(),
            )

        val barn =
            listOf(
                Barn(
                    ident =
                        FellesSøknadsfelt(
                            label = mapOf("nb" to "Fødselsnummer"),
                            verdi = mapOf("nb" to "12345678911"),
                        ),
                    harEøsSteg = false,
                    navn =
                        FellesSøknadsfelt(
                            label = mapOf("nb" to "Navn"),
                            verdi = mapOf("nb" to "Barn Barnesen"),
                        ),
                    registrertBostedType =
                        FellesSøknadsfelt(
                            label = mapOf("nb" to "Bosted"),
                            verdi = mapOf("nb" to no.nav.familie.kontrakter.ba.søknad.v5.RegistrertBostedType.REGISTRERT_SOKERS_ADRESSE),
                        ),
                    spørsmål = mapOf(),
                ),
            )

        val barnetrygdSøknad =
            BarnetrygdSøknad(
                kontraktVersjon = 9,
                søker = søker,
                barn = barn,
                antallEøsSteg = 0,
                søknadstype = no.nav.familie.kontrakter.ba.søknad.v4.Søknadstype.ORDINÆR,
                finnesPersonMedAdressebeskyttelse = false,
                spørsmål = spørsmål,
                dokumentasjon = listOf(),
                teksterUtenomSpørsmål = mapOf(),
                originalSpråk = "nb",
            )

        return VersjonertBarnetrygdSøknadV9(barnetrygdSøknad)
    }

    private fun createSøknadWithInvalidLabel(): VersjonertBarnetrygdSøknadV9 {
        val søknad = createValidSøknad()
        val barnetrygdSøknad = søknad.barnetrygdSøknad

        // Create a string that exceeds 200 characters
        val longString = "a".repeat(201)

        val updatedSpørsmål = barnetrygdSøknad.spørsmål.toMutableMap()
        updatedSpørsmål["invalidLabel"] =
            Søknadsfelt(
                label = mapOf("nb" to longString),
                verdi = mapOf("nb" to "Valid value"),
            )

        val updatedBarnetrygdSøknad = barnetrygdSøknad.copy(spørsmål = updatedSpørsmål)

        return VersjonertBarnetrygdSøknadV9(updatedBarnetrygdSøknad)
    }

    private fun createSøknadWithInvalidStringValue(): VersjonertBarnetrygdSøknadV9 {
        val søknad = createValidSøknad()
        val barnetrygdSøknad = søknad.barnetrygdSøknad

        // Create a string that exceeds 200 characters
        val longString = "a".repeat(201)

        val updatedSpørsmål = barnetrygdSøknad.spørsmål.toMutableMap()
        updatedSpørsmål["invalidValue"] =
            Søknadsfelt(
                label = mapOf("nb" to "Valid label"),
                verdi = mapOf("nb" to longString),
            )

        val updatedBarnetrygdSøknad = barnetrygdSøknad.copy(spørsmål = updatedSpørsmål)

        return VersjonertBarnetrygdSøknadV9(updatedBarnetrygdSøknad)
    }
}
