package no.nav.familie.kontrakter.felles.abstraction

import org.junit.Test
import org.springframework.util.LinkedMultiValueMap
import kotlin.test.assertEquals

internal class QueryUtilKtTest {

    @Test
    fun `toQueryParams gjør lister om til én string`() {
        val queryParams: LinkedMultiValueMap<String, String> = toQueryParams(Testdata())

        assertEquals(listOf("1","2","3","4","5"), queryParams["list"])
    }

    data class Testdata(val int: Int = 5,
                        val string: String = "Fem",
                        val list: List<Int> = listOf(1, 2, 3, 4, 5))
}