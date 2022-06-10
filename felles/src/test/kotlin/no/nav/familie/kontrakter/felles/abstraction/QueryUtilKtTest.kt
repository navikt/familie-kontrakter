package no.nav.familie.kontrakter.felles.abstraction

import org.junit.Test
import org.springframework.util.LinkedMultiValueMap
import kotlin.test.assertEquals
import kotlin.test.assertFalse

internal class QueryUtilKtTest {

    @Test
    fun `toQueryParams ivaretar lister som lister`() {
        val queryParams: LinkedMultiValueMap<String, String> = toQueryParams(Testdata())

        assertEquals(listOf("1", "2", "3", "4", "5"), queryParams["list"])
    }

    @Test
    fun `toQueryParams filtrerer vekk tomme lister`() {
        val queryParams: LinkedMultiValueMap<String, String> = toQueryParams(Testdata(list = listOf()))

        assertFalse { queryParams.containsKey("list") }
    }

    data class Testdata(
        val int: Int = 5,
        val string: String = "Fem",
        val list: List<Int> = listOf(1, 2, 3, 4, 5)
    )
}
