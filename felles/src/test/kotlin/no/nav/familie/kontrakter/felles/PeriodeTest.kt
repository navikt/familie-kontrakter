package no.nav.familie.kontrakter.felles

import io.kotest.assertions.throwables.shouldThrowMessage
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.YearMonth

internal class PeriodeTest {

    @Test
    fun `inneholder returnere true hvis måned er fullt inne i perioden`() {
        val periode = Periode(YearMonth.of(2019, 1), YearMonth.of(2019, 5))

        val inneholder = periode.inneholder(YearMonth.of(2019, 1))

        inneholder shouldBe true
    }

    @Test
    fun `inneholder returnere true hvis måned ikke fullt inne i perioden`() {
        val periode = Periode(LocalDate.of(2019, 1, 2), LocalDate.of(2019, 5, 1))

        val inneholder = periode.inneholder(YearMonth.of(2019, 1))

        inneholder shouldBe false
    }

    @Test
    fun `snitt returnerer lik periode for like perioder`() {
        val periode1 = Periode(YearMonth.of(2019, 1), YearMonth.of(2019, 5))
        val periode2 = Periode(YearMonth.of(2019, 1), YearMonth.of(2019, 5))

        val snitt = periode1.snitt(periode2)

        snitt shouldBe periode1
    }

    @Test
    fun `snitt returnerer null for periode uten overlap`() {
        val periode1 = Periode(YearMonth.of(2019, 1), YearMonth.of(2019, 5))
        val periode2 = Periode(YearMonth.of(2018, 1), YearMonth.of(2018, 12))

        val snitt = periode1.snitt(periode2)

        snitt shouldBe null
    }

    @Test
    fun `snitt returnerer lik periode uansett hvilken periode som ligger til grunn`() {
        val periode1 = Periode(YearMonth.of(2019, 1), YearMonth.of(2019, 5))
        val periode2 = Periode(YearMonth.of(2019, 3), YearMonth.of(2019, 12))

        val snitt1til2 = periode1.snitt(periode2)
        val snitt2til1 = periode2.snitt(periode1)

        snitt1til2 shouldBe snitt2til1
        snitt1til2 shouldBe Periode(YearMonth.of(2019, 3), YearMonth.of(2019, 5))
    }

    @Test
    fun `inneholder returnerer true for periode som helt inneholder innsendt periode`() {
        val periode1 = Periode(YearMonth.of(2019, 1), YearMonth.of(2019, 3))
        val periode2 = Periode(YearMonth.of(2019, 1), YearMonth.of(2019, 1))

        val inneholder = periode1.inneholder(periode2)

        inneholder shouldBe true
    }

    @Test
    fun `inneholder returnerer false for periode som stikker utenfor innsendt periode`() {
        val periode1 = Periode(YearMonth.of(2019, 1), YearMonth.of(2019, 3))
        val periode2 = Periode(LocalDate.of(2019, 2, 1), LocalDate.of(2019, 4, 1))

        val inneholder = periode1.inneholder(periode2)

        inneholder shouldBe false
    }

    @Test
    fun `omsluttesAv returnerer true for periode som helt omsluttes av innsendt periode`() {
        val periode1 = Periode(YearMonth.of(2019, 1), YearMonth.of(2019, 1))
        val periode2 = Periode(YearMonth.of(2019, 1), YearMonth.of(2019, 3))

        val inneholder = periode1.omsluttesAv(periode2)

        inneholder shouldBe true
    }

    @Test
    fun `omsluttesAv returnerer false for periode som nesten omsluttes av innsendt periode`() {
        val periode1 = Periode(LocalDate.of(2019, 2, 1), LocalDate.of(2019, 4, 1))
        val periode2 = Periode(YearMonth.of(2019, 1), YearMonth.of(2019, 3))

        val inneholder = periode1.omsluttesAv(periode2)

        inneholder shouldBe false
    }

    @Test
    fun `overlapperIStartenAv returnerer true hvis denne perioden overlapper i starten av perioden som sendes inn`() {
        val periodeSomOverlapperStarten = Periode(YearMonth.of(2019, 1), YearMonth.of(2019, 1))
        val periode = Periode(YearMonth.of(2019, 1), YearMonth.of(2019, 3))

        val overlapperIStartenAv = periodeSomOverlapperStarten.overlapperIStartenAv(periode)

        overlapperIStartenAv shouldBe true
    }

    @Test
    fun `overlapperIStartenAv returnerer false hvis denne perioden er lik den som sendes inn`() {
        val periodeSomErLik = Periode(YearMonth.of(2019, 1), YearMonth.of(2019, 3))
        val periode = Periode(YearMonth.of(2019, 1), YearMonth.of(2019, 3))

        val overlapperIStartenAv = periodeSomErLik.overlapperIStartenAv(periode)

        overlapperIStartenAv shouldBe false
    }

    @Test
    fun `overlapperIStartenAv returnerer false hvis denne perioden er før den som sendes inn`() {
        val periodeSomErFør = Periode(YearMonth.of(2018, 9), YearMonth.of(2018, 12))
        val periode = Periode(YearMonth.of(2019, 1), YearMonth.of(2019, 3))

        val overlapperIStartenAv = periodeSomErFør.overlapperIStartenAv(periode)

        overlapperIStartenAv shouldBe false
    }

    @Test
    fun `overlapperIStartenAv returnerer false hvis denne perioden starter etter den som sendes inn`() {
        val periodeSomErInneI = Periode(LocalDate.of(2018, 9, 2), LocalDate.of(2018, 9, 25))
        val periode = Periode(YearMonth.of(2018, 9), YearMonth.of(2018, 9))

        val overlapperIStartenAv = periodeSomErInneI.overlapperIStartenAv(periode)

        overlapperIStartenAv shouldBe false
    }

    @Test
    fun `overlapperISluttenAv returnerer true hvis denne perioden overlapper i slutten av perioden som sendes inn`() {
        val periodeSomOverlapperSlutten = Periode(YearMonth.of(2019, 3), YearMonth.of(2019, 3))
        val periode = Periode(YearMonth.of(2019, 1), YearMonth.of(2019, 3))

        val overlapperISluttenAv = periodeSomOverlapperSlutten.overlapperISluttenAv(periode)

        overlapperISluttenAv shouldBe true
    }

    @Test
    fun `overlapperISluttenAv returnerer false hvis denne perioden er lik den som sendes inn`() {
        val periodeSomErLik = Periode(YearMonth.of(2019, 1), YearMonth.of(2019, 3))
        val periode = Periode(YearMonth.of(2019, 1), YearMonth.of(2019, 3))

        val overlapperISluttenAv = periodeSomErLik.overlapperISluttenAv(periode)

        overlapperISluttenAv shouldBe false
    }

    @Test
    fun `overlapperISluttenAv returnerer false hvis denne perioden er etter den som sendes inn`() {
        val periodeSomErEtter = Periode(YearMonth.of(2019, 4), YearMonth.of(2019, 4))
        val periode = Periode(YearMonth.of(2019, 1), YearMonth.of(2019, 3))

        val overlapperISluttenAv = periodeSomErEtter.overlapperISluttenAv(periode)

        overlapperISluttenAv shouldBe false
    }

    @Test
    fun `overlapperISluttenAv returnerer false hvis denne perioden slutter før den som sendes inn`() {
        val periodeSomErInneI = Periode(LocalDate.of(2018, 9, 2), LocalDate.of(2018, 9, 29))
        val periode = Periode(YearMonth.of(2018, 9), YearMonth.of(2018, 9))

        val overlapperISluttenAv = periodeSomErInneI.overlapperISluttenAv(periode)

        overlapperISluttenAv shouldBe false
    }

    @Test
    fun `lengdeIHeleMåneder feiler for perioder som ikke er hele måneder`() {
        val periode = Periode(LocalDate.of(2018, 9, 2), LocalDate.of(2020, 5, 31))

        shouldThrowMessage(
            "Forsøk på å beregne lengde i hele måneder for en periode som ikke er hele måneder: 2018-09-02 - 2020-05-31"
        ) {
            periode.lengdeIHeleMåneder()
        }
    }

    @Test
    fun `lengdeIHeleMåneder returnerer korrekt antall måneder`() {
        val periode = Periode(YearMonth.of(2015, 9), YearMonth.of(2028, 3))

        val lengdeIHeleMåneder = periode.lengdeIHeleMåneder()

        lengdeIHeleMåneder shouldBe 151
    }
}
