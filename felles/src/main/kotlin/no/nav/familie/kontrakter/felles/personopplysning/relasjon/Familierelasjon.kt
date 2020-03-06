package no.nav.familie.kontrakter.felles.personopplysning.relasjon

import no.nav.familie.kontrakter.felles.personopplysning.PersonIdent
import java.time.LocalDate

class Familierelasjon(val personIdent: PersonIdent,
                      val relasjonsrolle: RelasjonsRolleType,
                      val fødselsdato: LocalDate,
                      val harSammeBosted: Boolean) {

    override fun toString(): String {
        return (javaClass.simpleName
                + "<relasjon=" + relasjonsrolle
                + ", fødselsdato=" + fødselsdato
                + ">")
    }

}