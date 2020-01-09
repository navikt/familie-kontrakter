package no.nav.familie.kontrakter.felles

import no.nav.familie.kontrakter.felles.Ressurs.Companion.failure
import no.nav.familie.kontrakter.felles.Ressurs.Companion.success
import org.junit.Assert
import org.junit.Test
import org.junit.jupiter.api.Assertions
import java.time.LocalDate

class RessursTest {
    private val date = LocalDate.of(2019, 11, 30)
    @Test
    fun `skal lagre object på ressurs og hente opp igjen`() {
        val (result) = success(TestObject("tekst", 42L, date), "OK")
        Assert.assertEquals(result?.nummer, 42L)
        Assert.assertEquals(result?.tekst, "tekst")
        Assert.assertEquals(result?.date, date)
    }

    @Test
    fun `skal konvertere success til json string`() {
        val ressurs: Ressurs<*> = success(TestObject("tekst", 42L, date), "OK")
        Assert.assertEquals(
            ressurs.toJson(),
            "{\"data\":{\"tekst\":\"tekst\",\"nummer\":42,\"date\":\"2019-11-30\"}," +
                    "\"status\":\"SUKSESS\",\"melding\":\"OK\",\"stacktrace\":null}"
        )
    }

    @Test
    fun `skal konvertere stacktrace to data`() {
        val (_, _, _, stacktrace) =
            failure<Any>("Dette er errormeldingen", RuntimeException("Dette er feilkoden"))
        Assertions.assertTrue(
            stacktrace!!.contains(
                "java.lang.RuntimeException: Dette er feilkoden" +
                        System.getProperty("line.separator") +
                        "\tat no.nav.familie.kontrakter.felles.RessursTest.skal konvertere stacktrace to data"
            )
        )
    }

    internal class TestObject(
        val tekst: String,
        val nummer: Long,
        val date: LocalDate?
    )
}