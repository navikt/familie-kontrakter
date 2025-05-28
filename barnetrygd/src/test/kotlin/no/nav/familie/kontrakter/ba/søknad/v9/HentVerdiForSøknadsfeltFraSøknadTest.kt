package no.nav.familie.kontrakter.ba.søknad.v9

import com.fasterxml.jackson.module.kotlin.readValue
import no.nav.familie.kontrakter.ba.søknad.lagBarnetrygdSøknadV9
import no.nav.familie.kontrakter.ba.søknad.v9.SøknadsFeltId.VÆRT_I_NORGE_I_TOLV_MÅNEDER
import no.nav.familie.kontrakter.felles.objectMapper
import no.nav.familie.kontrakter.felles.søknad.Søknadsfelt
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test
import kotlin.test.assertNotNull

class HentVerdiForSøknadsfeltFraSøknadTest {

    @Test
    fun `skal hente ut verdi til spørsmål`() {
        // Arrange
        val tomSøknad = lagBarnetrygdSøknadV9("12345678901", "23456789012")
        val søknad = tomSøknad
            .copy(
                søker = tomSøknad.søker.copy(
                    spørsmål = mapOf(
                        "værtINorgeITolvMåneder" to Søknadsfelt(
                            label = mapOf("nb" to "Har du oppholdt deg sammenhengende i Norge de siste tolv månedene?"),
                            verdi = mapOf("nb" to "JA")
                        )
                    )
                )
            )


        // Act
        val verdiForSpørsmål = søknad.søker.spørsmål.hentVerdiForSøknadsfelt(VÆRT_I_NORGE_I_TOLV_MÅNEDER)

        // Assert
        assertEquals(verdiForSpørsmål, "JA")
    }


    @Test
    fun `skal hente ut verdier fra nøstet data`() {
        // Arrange
        val søknadJson = this::class.java.getResource("søknadMedUtenlandsOpphold.json").readText()
        val versjonertBarnetrygdSøknad = objectMapper.readValue<BarnetrygdSøknad>(søknadJson)

        // Act
        val barnISøknad =
            versjonertBarnetrygdSøknad.barn.find { it.navn.bokmålsverdi() == "BLØT INNHEGNING" }
        val utenlandsOppholdÅrsak =
            barnISøknad?.utenlandsperioder?.first()?.bokmålsverdi()?.utenlandsoppholdÅrsak?.bokmålsverdi()

        // Assert
        assertNotNull(barnISøknad)
        assertEquals(
            utenlandsOppholdÅrsak, "Barnet har flyttet til Norge permanent de siste tolv månedene"
        )
    }
}



