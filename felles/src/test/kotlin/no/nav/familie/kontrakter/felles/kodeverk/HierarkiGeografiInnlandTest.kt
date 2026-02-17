package no.nav.familie.kontrakter.felles.kodeverk

import no.nav.familie.kontrakter.felles.jsonMapper
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HierarkiGeografiInnlandTest {
    @Test
    fun `skal deserialisere geografi hierarki korrekt`() {
        val geografiHierarkiJsonString =
            requireNotNull(
                this::class.java.getResourceAsStream("/geografiHierarki.json"),
            ) { "Missing test resource geografiHierarki.json" }
                .bufferedReader(Charsets.UTF_8)
                .use { it.readText() }

        val hierarki = jsonMapper.readValue(geografiHierarkiJsonString, HierarkiGeografiInnlandDto::class.java)

        // Fylker
        val fylker = hierarki.norgeNode.fylker
        assertEquals(2, fylker.size)

        val rogaland = requireNotNull(fylker.firstOrNull { it.kode == "11" }) { "Mangler fylke 11" }
        val møreOgRomsdal = requireNotNull(fylker.firstOrNull { it.kode == "15" }) { "Mangler fylke 15" }

        assertEquals("Rogaland", rogaland.navn)
        assertEquals("Møre og Romsdal", møreOgRomsdal.navn)

        // Kommuner
        assertEquals(1, rogaland.kommuner.size)
        assertEquals(1, møreOgRomsdal.kommuner.size)

        val stavanger = requireNotNull(rogaland.kommuner.firstOrNull { it.kode == "1103" }) { "Mangler kommune 1103" }
        val molde = requireNotNull(møreOgRomsdal.kommuner.firstOrNull { it.kode == "1506" }) { "Mangler kommune 1506" }

        assertEquals("Stavanger", stavanger.navn)
        assertEquals("Molde", molde.navn)

        // Bydeler
        assertEquals(2, stavanger.bydeler.size)
        val hundvåg = requireNotNull(stavanger.bydeler.firstOrNull { it.kode == "110301" }) { "Mangler bydel 110301" }
        val tasta = requireNotNull(stavanger.bydeler.firstOrNull { it.kode == "110302" }) { "Mangler bydel 110302" }
        assertEquals("Hundvåg", hundvåg.navn)
        assertEquals("Tasta", tasta.navn)

        // Molde har ingen bydeler -> tom liste (ikke null)
        assert(molde.bydeler.isEmpty())
    }
}
