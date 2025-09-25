package no.nav.familie.kontrakter.felles.kodeverk

import no.nav.familie.kontrakter.felles.objectMapper
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class HierarkiGeografiInnlandTest {
    val testData =
        requireNotNull(
            this::class.java.getResourceAsStream("/geografiHierarki.json"),
        ) { "Missing test resource GeografiHierarki.json" }.bufferedReader(Charsets.UTF_8).use { it.readText() }

    val testTre = objectMapper.readTree(testData)
    val hierarki: HierarkiGeografiInnlandDto = objectMapper.treeToValue(testTre, HierarkiGeografiInnlandDto::class.java)

    private val fylker = hierarki.norgeNode.fylker
    private val rogaland = fylker["11"]
    private val stavanger = rogaland?.undernoder?.get("1103")
    private val hundvåg = stavanger?.undernoder?.get("110301")
    private val tasta = stavanger?.undernoder?.get("110302")
    private val møreOgRomsdal = fylker["15"]
    private val molde = møreOgRomsdal?.undernoder?.get("1506")

    @Test
    fun `norgeNode og fylker skal returnere riktig node`() {
        val norgeNode = hierarki.norgeNode

        assert(norgeNode.fylker.size == 2)
        assert(norgeNode.fylker.containsKey("11"))
        assert(norgeNode.fylker.containsKey("15"))
    }

    @Test
    fun `skal kunne hente ut fylker`() {
        assertEquals("Rogaland", rogaland?.navn)
        assertEquals("Møre og Romsdal", møreOgRomsdal?.navn)
    }

    @Test
    fun `skal kunne hente ut kommuner`() {
        assertEquals(1, rogaland?.undernoder?.size)
        assertEquals(1, møreOgRomsdal?.undernoder?.size)

        assertEquals("Stavanger", stavanger?.navn)
        assertEquals("Molde", molde?.navn)
    }

    @Test
    fun `skal kunne hente ut bydeler`() {
        assertEquals(2, stavanger?.undernoder?.size)

        assertEquals("Hundvåg", hundvåg?.navn)
        assertEquals("Tasta", tasta?.navn)
    }

    @Test
    fun `skal ha null undernoder for kommuner uten bydeler`() {
        val fylker = hierarki.norgeNode.fylker
        val møreOgRomsdal = fylker["15"]
        val molde = møreOgRomsdal?.undernoder?.get("1506")
        assertNull(molde?.undernoder)
    }
}
