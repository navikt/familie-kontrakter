package no.nav.familie.kontrakter.ba.søknad.v9

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.familie.kontrakter.felles.objectMapper
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test
import kotlin.test.assertNotNull

class HentVerdiForSøknadsfeltFraSøknadTest {

    @Test
    fun `skal hente ut verdi for spørsmål`() {
        // Arrange
        val versjonertBarnetrygdSøknad = lesSøknad("søknadMedUtenlandsOpphold.json")

        SøknadsFeltId.entries.forEach { søknadsFeltId ->
            // Act
            val verdiForSpørsmålSøker = versjonertBarnetrygdSøknad.søker.spørsmål.hentVerdiForSøknadsfelt(søknadsFeltId)
            val verdiForSpørsmålBarn =
                versjonertBarnetrygdSøknad.barn.map { it.spørsmål.hentVerdiForSøknadsfelt(søknadsFeltId) }

            // Assert
            assert((verdiForSpørsmålBarn + verdiForSpørsmålSøker).isNotEmpty())
        }
    }

    @Test
    fun `skal hente ut verdier fra nøstet data`() {
        // Arrange
        val versjonertBarnetrygdSøknad = lesSøknad("søknadMedUtenlandsOpphold.json")

        // Act
        val barnISøknad =
            versjonertBarnetrygdSøknad.barn.find { it.navn.bokmålsverdi() == "BLØT INNHEGNING" }
        val utenlandsOppholdÅrsak =
            barnISøknad?.utenlandsperioder?.first()?.bokmålsverdi()?.utenlandsoppholdÅrsak?.bokmålsverdi()

        // Assert
        assertNotNull(barnISøknad)
        assertEquals(
            utenlandsOppholdÅrsak,
            "Barnet har flyttet til Norge permanent de siste tolv månedene",
        )
    }

    @Test
    fun `tilBoolskSvar skal returnere true når verdi for spørsmål er JA eller ja`() {
        //Arrange
        val versjonertBarnetrygdSøknad = lesSøknad("søknadMedUtenlandsOpphold.json")
        val søknadsFeltId = SøknadsFeltId.BOR_PÅ_REGISTRERT_ADRESSE

        //Act
        val verdiForSpørsmål = versjonertBarnetrygdSøknad.søker.spørsmål.hentVerdiForSøknadsfelt(søknadsFeltId).tilBoolskSvar()

        //Assert
        assertEquals(verdiForSpørsmål, true)
    }

    @Test
    fun `tilBoolskSvar skal returnere false for NEI, andre verdier og null`() {
        // Act & Assert
        assertEquals(false, "NEI".tilBoolskSvar())
        assertEquals(false, "nei".tilBoolskSvar())
        assertEquals(false, 1234.tilBoolskSvar())
        assertEquals(false, null.tilBoolskSvar())
    }

    private fun lesSøknad(søknadFilnavn: String): BarnetrygdSøknad {
        val søknadJson = this::class.java.getResource(søknadFilnavn)?.readText()
            ?: throw IllegalArgumentException("Fant ingen søknad med navn $søknadFilnavn")
        val søknad = objectMapper.readValue<BarnetrygdSøknad>(søknadJson)
        return søknad
    }
}
