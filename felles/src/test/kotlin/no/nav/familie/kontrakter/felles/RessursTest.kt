package no.nav.familie.kontrakter.felles

import no.nav.familie.kontrakter.felles.Ressurs.Companion.failure
import no.nav.familie.kontrakter.felles.Ressurs.Companion.success
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import tools.jackson.databind.json.JsonMapper
import java.time.LocalDate

class RessursTest {
    private val date = LocalDate.of(2019, 11, 30)

    @Test
    fun `skal lagre object på ressurs og hente opp igjen`() {
        val (result) = success(TestObject("tekst", 42L, date), "OK")
        Assertions.assertEquals(result?.nummer, 42L)
        Assertions.assertEquals(result?.tekst, "tekst")
        Assertions.assertEquals(result?.date, date)
    }

    @Test
    fun `skal konvertere success til json string`() {
        val ressurs: Ressurs<*> = success(TestObject("tekst", 42L, date), "OK")
        Assertions.assertEquals(
            ressurs.toJson(),
            "{\"data\":{\"tekst\":\"tekst\",\"nummer\":42,\"date\":\"2019-11-30\"}," +
                "\"status\":\"SUKSESS\",\"melding\":\"OK\",\"frontendFeilmelding\":null,\"stacktrace\":null,\"callId\":null}",
        )
    }

    @Test
    fun `skal konvertere success til json string med vanlig objektmapper`() {
        val ressurs: Ressurs<*> = success("a", "OK")
        Assertions.assertEquals(
            "{\"data\":\"a\",\"status\":\"SUKSESS\",\"melding\":\"OK\",\"frontendFeilmelding\":null,\"stacktrace\":null,\"callId\":null}",
            JsonMapper()
                .writeValueAsString(ressurs),
        )
    }

    @Test
    fun `skal konvertere stacktrace to data`() {
        val (_, _, _, _, stacktrace) =
            failure<Any>(errorMessage = "Dette er errormeldingen", error = RuntimeException("Dette er feilkoden"))
        Assertions.assertTrue(
            stacktrace!!.contains(
                "java.lang.RuntimeException: Dette er feilkoden" +
                    System.getProperty("line.separator") +
                    "\tat no.nav.familie.kontrakter.felles.RessursTest.skal konvertere stacktrace to data",
            ),
        )
    }

    internal class TestObject(
        val tekst: String,
        val nummer: Long,
        val date: LocalDate?,
    )
}
