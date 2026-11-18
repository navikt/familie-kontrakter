package no.nav.familie.kontrakter.felles.personopplysning

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

class AdresselikhetTest {
    private val vegadresse =
        Vegadresse(
            matrikkelId = 123L,
            husnummer = "1",
            husbokstav = "A",
            bruksenhetsnummer = "H0101",
            adressenavn = "Testveien",
            kommunenummer = "0301",
            tilleggsnavn = null,
            postnummer = "0001",
        )
    private val matrikkeladresse =
        Matrikkeladresse(
            matrikkelId = 123L,
            bruksenhetsnummer = "H0101",
            tilleggsnavn = "Testadresse",
            postnummer = "0001",
            kommunenummer = "0301",
        )

    @Test
    fun `skal anse vegadresser med samme matrikkelId og bruksenhetsnummer som like uavhengig av andre felter`() {
        // Arrange
        val annen =
            vegadresse.copy(
                husnummer = "2",
                husbokstav = "B",
                adressenavn = "Annen vei",
                kommunenummer = "2100",
                tilleggsnavn = "Annet navn",
                postnummer = "9170",
            )

        // Act & Assert
        assertEquals(vegadresse, annen)
        assertEquals(annen, vegadresse)
        assertEquals(vegadresse.hashCode(), annen.hashCode())
        assertEquals(1, setOf(vegadresse, annen).size)
    }

    @Test
    fun `skal anse matrikkeladresser med samme matrikkelId og bruksenhetsnummer som like uavhengig av andre felter`() {
        // Arrange
        val annen = matrikkeladresse.copy(tilleggsnavn = "Annet navn", postnummer = "9170", kommunenummer = "2100")

        // Act & Assert
        assertEquals(matrikkeladresse, annen)
        assertEquals(annen, matrikkeladresse)
        assertEquals(matrikkeladresse.hashCode(), annen.hashCode())
        assertEquals(1, setOf(matrikkeladresse, annen).size)
    }

    @Test
    fun `skal ikke anse adresser med ulike matrikkelIder som like`() {
        // Act & Assert
        assertNotEquals(vegadresse, vegadresse.copy(matrikkelId = 456L))
        assertNotEquals(matrikkeladresse, matrikkeladresse.copy(matrikkelId = 456L))
    }

    @Test
    fun `skal ikke anse adresser med ulike bruksenhetsnumre som like`() {
        // Act & Assert
        assertNotEquals(vegadresse, vegadresse.copy(bruksenhetsnummer = "H0201"))
        assertNotEquals(matrikkeladresse, matrikkeladresse.copy(bruksenhetsnummer = "H0201"))
        assertNotEquals(vegadresse, vegadresse.copy(bruksenhetsnummer = null))
        assertNotEquals(matrikkeladresse, matrikkeladresse.copy(bruksenhetsnummer = null))
    }

    @Test
    fun `skal tillate manglende bruksenhetsnummer hos begge adresser`() {
        // Arrange
        val vegadresseUtenBruksenhet = vegadresse.copy(bruksenhetsnummer = null)
        val matrikkeladresseUtenBruksenhet = matrikkeladresse.copy(bruksenhetsnummer = null)

        // Act & Assert
        assertEquals(vegadresseUtenBruksenhet, vegadresseUtenBruksenhet.copy(adressenavn = "Annen vei"))
        assertEquals(matrikkeladresseUtenBruksenhet, matrikkeladresseUtenBruksenhet.copy(tilleggsnavn = "Annet navn"))
        assertEquals(vegadresseUtenBruksenhet.hashCode(), vegadresseUtenBruksenhet.copy().hashCode())
        assertEquals(matrikkeladresseUtenBruksenhet.hashCode(), matrikkeladresseUtenBruksenhet.copy().hashCode())
    }

    @Test
    fun `skal ikke anse forskjellige adresseobjekter uten matrikkelId som like`() {
        // Arrange
        val vegadresseUtenId = vegadresse.copy(matrikkelId = null)
        val matrikkeladresseUtenId = matrikkeladresse.copy(matrikkelId = null)

        // Act & Assert
        assertNotEquals(vegadresseUtenId, vegadresseUtenId.copy())
        assertNotEquals(matrikkeladresseUtenId, matrikkeladresseUtenId.copy())
        assertNotEquals(
            vegadresseUtenId.copy(bruksenhetsnummer = null),
            vegadresseUtenId.copy(bruksenhetsnummer = null)
        )
        assertNotEquals(
            matrikkeladresseUtenId.copy(bruksenhetsnummer = null),
            matrikkeladresseUtenId.copy(bruksenhetsnummer = null)
        )
        assertNotEquals(vegadresseUtenId, vegadresse)
        assertNotEquals(vegadresse, vegadresseUtenId)
        assertNotEquals(matrikkeladresseUtenId, matrikkeladresse)
        assertNotEquals(matrikkeladresse, matrikkeladresseUtenId)
    }
}
