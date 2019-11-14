package no.nav.familie.ks.kontrakter.sak;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RessursTest {
    private LocalDate date = LocalDate.of(2019,11,30);
    @Test
    public void skal_lagre_object_på_ressurs_og_hente_opp_igjen() {

        Ressurs ressurs = Ressurs.Companion.success(new TestObject("tekst", 42L, date), "OK");

        TestObject result = ressurs.convert(TestObject.class);
        Assert.assertEquals(result.nummer, 42);
        Assert.assertEquals(result.tekst, "tekst");
        Assert.assertEquals(result.date, date);
    }

    @Test
    public void skal_konvertere_til_json_string() {
        Ressurs ressurs = Ressurs.Companion.success(new TestObject("tekst", 42L, date), "OK");
        Assert.assertEquals(ressurs.toJson(), "{\"data\":{\"tekst\":\"tekst\",\"nummer\":42,\"date\":\"2019-11-30\"},\"status\":\"SUKSESS\",\"melding\":\"OK\",\"errorMelding\":null}");

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
