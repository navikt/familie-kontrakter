package no.nav.familie.kontrakter.ba.søknad.v9

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.familie.kontrakter.felles.objectMapper
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test
import kotlin.test.assertNotNull

class HentVerdiForSøknadsfeltFraSøknadTest {
    @Test
    fun `skal hente ut true verdi for søknadsfeltId PLANLEGGER_Å_BO_I_NORGE_12_MND_SØKER for søker`() {
        // Arrange
        val versjonertBarnetrygdSøknad = lesSøknad("søknadMedUtenlandsOpphold.json")

        // Act
        val verdiForSpørsmålSøker =
            versjonertBarnetrygdSøknad.søker.spørsmål
                .hentVerdiForSøknadsfelt(SøknadsFeltId.PLANLEGGER_Å_BO_I_NORGE_12_MND_SØKER)
                .tilBoolskSvar()

        // Assert
        assertEquals(verdiForSpørsmålSøker, true)
    }

    @Test
    fun `skal hente ut true verdi for søknadsfeltId PLANLEGGER_Å_BO_I_NORGE_12_MND_BARN for barn`() {
        // Arrange
        val versjonertBarnetrygdSøknad = lesSøknad("søknadMedUtenlandsOpphold.json")

        // Act
        val verdiForSpørsmål =
            versjonertBarnetrygdSøknad.barn.map {
                it.spørsmål.hentVerdiForSøknadsfelt(SøknadsFeltId.PLANLEGGER_Å_BO_I_NORGE_12_MND_BARN).tilBoolskSvar()
            }

        // Assert
        verdiForSpørsmål.forEach {
            assertEquals(it, true)
        }
    }

    @Test
    fun `skal hente ut false verdi for søknadsfeltId ER_ADOPTERT_FRA_UTLAND for barn`() {
        // Arrange
        val versjonertBarnetrygdSøknad = lesSøknad("søknadMedUtenlandsOpphold.json")

        // Act
        val verdiForSpørsmål =
            versjonertBarnetrygdSøknad.barn.map {
                it.spørsmål.hentVerdiForSøknadsfelt(SøknadsFeltId.ER_ADOPTERT_FRA_UTLAND).tilBoolskSvar()
            }

        // Assert
        verdiForSpørsmål.forEach {
            assertEquals(it, false)
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
            barnISøknad
                ?.utenlandsperioder
                ?.first()
                ?.bokmålsverdi()
                ?.utenlandsoppholdÅrsak
                ?.bokmålsverdi()

        // Assert
        assertNotNull(barnISøknad)
        assertEquals(
            utenlandsOppholdÅrsak,
            "Barnet har flyttet til Norge permanent de siste tolv månedene",
        )
    }

    @Test
    fun `tilBoolskSvar skal returnere true når verdi for spørsmål er JA eller ja`() {
        // Arrange
        val versjonertBarnetrygdSøknad = lesSøknad("søknadMedUtenlandsOpphold.json")
        val søknadsFeltId = SøknadsFeltId.BOR_PÅ_REGISTRERT_ADRESSE

        // Act
        val verdiForSpørsmål =
            versjonertBarnetrygdSøknad.søker.spørsmål
                .hentVerdiForSøknadsfelt(søknadsFeltId)
                .tilBoolskSvar()

        // Assert
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
        val søknadJson =
            this::class.java.getResource(søknadFilnavn)?.readText()
                ?: throw IllegalArgumentException("Fant ingen søknad med navn $søknadFilnavn")
        val søknad = objectMapper.readValue<BarnetrygdSøknad>(søknadJson)
        return søknad
    }
}
