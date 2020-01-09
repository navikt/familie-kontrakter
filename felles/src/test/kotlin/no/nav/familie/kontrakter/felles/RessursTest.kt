package no.nav.familie.kontrakter.felles;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class RessursTest {
    private LocalDate date = LocalDate.of(2019, 11, 30);

    @Test
    public void skal_lagre_object_på_ressurs_og_hente_opp_igjen() {

        Ressurs<TestObject> ressurs = Ressurs.Companion.success(new TestObject("tekst", 42L, date), "OK");

        TestObject result = ressurs.getData();
        assertEquals(result.nummer, 42);
        assertEquals(result.tekst, "tekst");
        assertEquals(result.date, date);
    }

    @Test
    public void skal_konvertere_success_til_json_string() {
        Ressurs ressurs = Ressurs.Companion.success(new TestObject("tekst", 42L, date), "OK");
        assertEquals(ressurs.toJson(), "{\"data\":{\"tekst\":\"tekst\",\"nummer\":42,\"date\":\"2019-11-30\"},\"status\":\"SUKSESS\",\"melding\":\"OK\",\"stacktrace\":null}");
    }

    @Test
    public void skal_konvertere_stacktrace_to_data() {
        Ressurs ressurs = Ressurs.Companion.failure("Dette er errormeldingen", new RuntimeException("Dette er feilkoden"));

        Assertions.assertTrue(ressurs.getStacktrace().contains("java.lang.RuntimeException: Dette er feilkoden\n" +
                "\tat no.nav.familie.kontrakter.felles.RessursTest.skal_konvertere_stacktrace_to_data"));
    }

    static class TestObject {
        private String tekst;
        private long nummer;
        private LocalDate date;

        public TestObject() {
        }

        public TestObject(String tekst, long nummer, LocalDate date) {
            this.tekst = tekst;
            this.nummer = nummer;
            this.date = date;
        }
    }
}
