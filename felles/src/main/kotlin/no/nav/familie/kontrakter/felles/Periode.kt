package no.nav.familie.kontrakter.felles

import java.time.LocalDate
import java.time.YearMonth

data class Periode(
    val fomDato: LocalDate,
    val tomDato: LocalDate
) : Comparable<Periode> {

    val fomMåned = YearMonth.from(fomDato)
    val tomMåned = YearMonth.from(tomDato)

    constructor(fomMåned: YearMonth, tomMåned: YearMonth) : this(fomMåned.atDay(1), tomMåned.atEndOfMonth())

    constructor(måned: YearMonth) : this(måned.atDay(1), måned.atEndOfMonth())

    init {
        require(tomDato >= fomDato) { "Til-og-med før fra-og-med: $fomDato > $tomDato" }
    }

    infix fun inneholder(dato: LocalDate): Boolean {
        return dato in fomDato..tomDato
    }

    infix fun inneholder(måned: YearMonth): Boolean {
        return inneholder(Periode(måned.atDay(1), måned.atEndOfMonth()))
    }

    infix fun inneholder(annen: Periode): Boolean {
        return annen.fomDato >= this.fomDato && annen.tomDato <= this.tomDato
    }

    infix fun omsluttesAv(annen: Periode): Boolean {
        return annen.fomDato <= fomDato && annen.tomDato >= tomDato
    }

    infix fun overlapper(other: Periode): Boolean {
        return inneholder(other.fomDato) || inneholder(other.tomDato) || other.inneholder(fomDato)
    }

    infix fun snitt(annen: Periode): Periode? {
        return if (!overlapper(annen)) {
            null
        } else if (this == annen) {
            this
        } else {
            Periode(
                maxOf(fomDato, annen.fomDato),
                minOf(tomDato, annen.tomDato)
            )
        }
    }

    infix fun union(annen: Periode): Periode {
        return if (overlapper(annen) || this.påfølgesAv(annen) || annen.påfølgesAv(this)) {
            Periode(
                minOf(fomDato, annen.fomDato),
                maxOf(tomDato, annen.tomDato)
            )
        } else {
            error("Kan ikke lage union av perioder som $this og $annen som ikke overlapper eller direkte følger hverandre.")
        }
    }

    infix fun overlapperIStartenAv(annen: Periode) =
        fomDato <= annen.fomDato &&
            tomDato > annen.fomDato &&
            tomDato < annen.tomDato

    infix fun overlapperISluttenAv(annen: Periode) =
        fomDato > annen.fomDato &&
            fomDato < annen.tomDato &&
            tomDato >= annen.tomDato

    infix fun påfølgesAv(påfølgende: Periode): Boolean {
        return this.tomDato.plusDays(1) == påfølgende.fomDato
    }

    fun lengdeIHeleMåneder(): Long {
        require(fomDato == fomMåned.atDay(1) && tomDato == tomMåned.atEndOfMonth()) {
            "Forsøk på å beregne lengde i hele måneder for en periode som ikke er hele måneder: $fomDato - $tomDato"
        }
        return (tomMåned.year * 12 + tomMåned.monthValue) - (fomMåned.year * 12 + fomMåned.monthValue) + 1L
    }

    companion object {

        val COMPARATOR: Comparator<Periode> = Comparator.comparing(Periode::fomDato).thenComparing(Periode::tomDato)
    }

    override fun compareTo(other: Periode): Int {
        return COMPARATOR.compare(this, other)
    }
}

fun List<Periode>.erSammenhengende(): Boolean = this.sorted().foldIndexed(true) { index, acc, periode ->
    if (index == 0) {
        acc
    } else {
        val forrigePeriode = this[index - 1]
        when {
            forrigePeriode.påfølgesAv(periode) -> acc
            else -> false
        }
    }
}

fun List<Periode>.harOverlappende(): Boolean {
    return this.sorted()
        .zipWithNext { a, b ->
            a.overlapper(b)
        }.any { it }
}
