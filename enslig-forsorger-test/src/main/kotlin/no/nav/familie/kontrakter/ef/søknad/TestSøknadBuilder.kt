package no.nav.familie.kontrakter.ef.søknad

import no.nav.familie.util.FnrGenerator
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month

object Testsøknad {

    val søknadOvergangsstønad: SøknadOvergangsstønad = TestSøknadBuilder.Builder().build().søknadOvergangsstønad
    val søknadSkolepenger: SøknadSkolepenger = TestSøknadBuilder.Builder().build().søknadSkolepenger
    val søknadBarnetilsyn: SøknadBarnetilsyn = TestSøknadBuilder.Builder().build().søknadBarnetilsyn

}

class TestSøknadBuilder private constructor(

        val søknadOvergangsstønad: SøknadOvergangsstønad,
        val søknadSkolepenger: SøknadSkolepenger,
        val søknadBarnetilsyn: SøknadBarnetilsyn,

        val personalia: Personalia,
        val innsendingsdetaljer: Innsendingsdetaljer,
        val sivilstandsdetaljer: Sivilstandsdetaljer,
        val medlemskapsdetaljer: Medlemskapsdetaljer,
        val bosituasjon: Bosituasjon,
        val sivilstandsplaner: Sivilstandsplaner,
        val barn: List<Barn>,
        val aktivitet: Aktivitet,
        val situasjon: Situasjon,
        val stønadsstart: Stønadsstart

) {

    /**
     * En builder med defaultverdier for 'Testsøknad', men som kan "overlagres" om man ønsker andre verdier
     */
    class Builder {

        private lateinit var personalia: Personalia
        private lateinit var innsendingsdetaljer: Innsendingsdetaljer
        private lateinit var sivilstandsdetaljer: Sivilstandsdetaljer
        private lateinit var medlemskapsdetaljer: Medlemskapsdetaljer
        private lateinit var bosituasjon: Bosituasjon
        private lateinit var sivilstandsplaner: Sivilstandsplaner
        private lateinit var barn: List<Barn>
        private lateinit var aktivitet: Aktivitet
        private lateinit var situasjon: Situasjon
        private lateinit var stønadsstart: Stønadsstart

        init {
            setPersonalia()
            setInnsendingsdetaljer()
            setSivilstandsdetaljer()
            setMedlemskapsdetaljer()
            setBosituasjon()
            setSivilstandsplaner()
            setBarn()
            setAktivitet()
            setSituasjon()
            setStønadstart()
        }

        fun setPersonalia(navn: String, fødselsnummer: String): Builder {
            this.setPersonalia(NavnOgFnr(navn, fødselsnummer))
            return this
        }

        fun setPersonalia(navnOgFnr: NavnOgFnr? = null, adresse: Adresse = defaultAdresse()): Builder {

            this.personalia = Personalia(
                    Søknadsfelt("Fødselsnummer", Fødselsnummer(navnOgFnr?.fødselsnummer
                                                               ?: FnrGenerator.generer())),
                    Søknadsfelt("Navn", navnOgFnr?.navn ?: "Kari Nordmann"),
                    Søknadsfelt("Statsborgerskap", "Norsk"),
                    Søknadsfelt("Adresse", adresse),
                    Søknadsfelt("Telefonnummer", "12345678"),
                    Søknadsfelt("Sivilstand", "Ugift"))

            return this
        }

        fun setInnsendingsdetaljer(datoMottatt: LocalDateTime = LocalDateTime.of(2020, 5, 5, 11, 32)): Builder {
            this.innsendingsdetaljer = defaultInnsendingsdetaljer(datoMottatt)
            return this
        }

        fun setSivilstandsdetaljer(erUformeltGift: Boolean = true,
                                   erUformeltGiftDokumentasjon: String = "giftIUtlandetDokumentasjon",
                                   erUformeltSeparertEllerSkilt: Boolean = true,
                                   erUformeltSeparertEllerSkiltDokumentasjon: String = "separertEllerSkiltIUtlandetDokumentasjon",
                                   søktOmSkilsmisseSeparasjon: Boolean = true,
                                   datoSøktSeparasjon: LocalDate = LocalDate.of(2015, 12, 23),
                                   separasjonsbekreftelse: String = "Skilsmisse- eller separasjonsbevilling",
                                   årsakEnslig: String = "Trives best alene",
                                   samlivsbruddsdokumentasjon: String = "Erklæring om samlivsbrudd",
                                   samlivsbruddsdato: LocalDate = LocalDate.of(2014, 10, 3),
                                   fraflytningsdato: LocalDate = LocalDate.of(2014, 10, 4),
                                   endringSamværsordningDato: LocalDate = LocalDate.of(2013, 4, 17),
                                   tidligereSamboerdetaljer: PersonMinimum = personMinimum()): Builder {

            this.sivilstandsdetaljer = Sivilstandsdetaljer(
                    Søknadsfelt("Er du gift uten at dette er formelt registrert eller godkjent i Norge?", erUformeltGift),
                    dokumentfelt(erUformeltGiftDokumentasjon),
                    Søknadsfelt("Er du separert eller skilt uten at dette er formelt registrert eller godkjent i Norge?",
                                erUformeltSeparertEllerSkilt),
                    dokumentfelt(erUformeltSeparertEllerSkiltDokumentasjon),
                    Søknadsfelt("Har dere søkt om separasjon, søkt om skilsmisse eller reist sak for domstolen?",
                                søktOmSkilsmisseSeparasjon),
                    Søknadsfelt("Når søkte dere eller reiste sak?", datoSøktSeparasjon),
                    dokumentfelt(separasjonsbekreftelse),
                    Søknadsfelt("Hva er grunnen til at du er alene med barn?", årsakEnslig),
                    dokumentfelt(samlivsbruddsdokumentasjon),
                    Søknadsfelt("Dato for samlivsbrudd", samlivsbruddsdato),
                    Søknadsfelt("Når flyttet dere fra hverandre?", fraflytningsdato),
                    Søknadsfelt("Når skjedde endringen / når skal endringen skje?", endringSamværsordningDato),
                    Søknadsfelt("Om den tidligere samboern din", tidligereSamboerdetaljer))

            return this
        }

        fun setMedlemskapsdetaljer(oppholderDuDegINorge: Boolean = true,
                                   bosattNorgeSisteÅrene: Boolean = true,
                                   utenlandsopphold: List<Utenlandsopphold> = defaultUtenlandsopphold()): Builder {

            this.medlemskapsdetaljer = Medlemskapsdetaljer(
                    Søknadsfelt("Oppholder du deg i Norge?", oppholderDuDegINorge),
                    Søknadsfelt("Har du bodd i Norge de siste tre årene?", bosattNorgeSisteÅrene),
                    Søknadsfelt("", utenlandsopphold))

            return this
        }

        fun setBosituasjon(delerDuBolig: String = "Ja, jeg har samboer og lever i et ekteskapslignende forhold",
                           samboerdetaljer: PersonMinimum = personMinimum(),
                           sammenflyttingsdato: LocalDate = LocalDate.of(2018, 8, 12),
                           datoFlyttetFraHverandre: LocalDate = LocalDate.of(2019, 8, 12)): Builder {

            this.bosituasjon = Bosituasjon(
                    Søknadsfelt("Deler du bolig med andre voksne?", delerDuBolig),
                    Søknadsfelt("Om samboeren din", samboerdetaljer),
                    Søknadsfelt("Når flyttet dere sammen?", sammenflyttingsdato),
                    Søknadsfelt("Når flyttet dere fra hverandre?", datoFlyttetFraHverandre))

            return this
        }

        fun setSivilstandsplaner(
                harPlaner: Boolean = true,
                fraDato: LocalDate = LocalDate.of(2021, 4, 15),
                vordendeSamboerEktefelle: PersonMinimum = personMinimum()): Builder {

            this.sivilstandsplaner = Sivilstandsplaner(
                    Søknadsfelt("Har du konkrete planer om å gifte deg eller bli samboer", harPlaner),
                    Søknadsfelt("Når skal dette skje?", fraDato),
                    Søknadsfelt("Hvem skal du gifte deg eller bli samboer med?", vordendeSamboerEktefelle))

            return this
        }

        fun setBarn(barn: List<NavnOgFnr>): Builder {
            this.barn = barn.map { defaultBarn(it) }.toList()
            return this
        }

        fun setBarn(navn: String = "Lykkeliten",
                    fødselsnummer: Fødselsnummer = Fødselsnummer(FnrGenerator.generer()),
                    harSkalHaSammeAdresse: Boolean = true,
                    ikkeRegistrertPåSøkersAdresseBeskrivelse: String = "Fordi",
                    erBarnetFødt: Boolean = false,
                    fødselTermindato: LocalDate = LocalDate.of(2020, 5, 16),
                    annenForelder: AnnenForelder = AnnenForelder(person = Søknadsfelt("personalia", personMinimum())),
                    samvær: Samvær = defaultSamvær()): Builder {

            this.barn = listOf(Barn(Søknadsfelt("Navn", navn),
                                    Søknadsfelt("Fødselsnummer", fødselsnummer),
                                    Søknadsfelt("Har samme adresse som søker", harSkalHaSammeAdresse),
                                    Søknadsfelt("ikkeRegistrertPåSøkersAdresseBeskrivelse",
                                                ikkeRegistrertPåSøkersAdresseBeskrivelse),
                                    Søknadsfelt("Er barnet født?", erBarnetFødt),
                                    Søknadsfelt("Termindato", fødselTermindato),
                                    dokumentfelt("Bekreftelse på ventet fødselsdato"),
                                    Søknadsfelt("Barnets andre forelder", annenForelder),
                                    Søknadsfelt("samvær", samvær)))

            return this
        }

        fun setAktivitet(hvordanErArbeidssituasjonen: List<String> =
                                 listOf(
                                         "Jeg er hjemme med barn under 1 år (vises kun hvis har barn under 1 år)",
                                         "Jeg er i arbeid",
                                         "Jeg er selvstendig næringsdrivende eller frilanser"),
                         arbeidsforhold: List<Arbeidsgiver> = defaultArbeidsgiver(),
                         selvstendig: Søknadsfelt<Selvstendig>? = null, // deprecated
                         firmaer: List<Selvstendig> = listOf(defaultSelvstendig()),
                         virksomhet: Virksomhet = defaultVirksomhet(),
                         arbeidssøker: Arbeidssøker = defaultArbeidssøker(),
                         underUtdanning: UnderUtdanning = defaultUtdanning(),
                         aksjeselskap: List<Aksjeselskap> = defaultAksjeselskap()): Builder {

            this.aktivitet = Aktivitet(
                    Søknadsfelt("Hvordan er arbeidssituasjonen din?", hvordanErArbeidssituasjonen),
                    Søknadsfelt("Om arbeidsforholdet ditt", arbeidsforhold),
                    selvstendig,
                    Søknadsfelt("Selvstendig næringsdrivende", firmaer),
                    Søknadsfelt("Om virksomheten du etablerer", virksomhet),
                    Søknadsfelt("Når du er arbeidssøker", arbeidssøker),
                    Søknadsfelt("Utdanningen du skal ta", underUtdanning),
                    Søknadsfelt("Eget AS", aksjeselskap)
            )
            return this
        }

        fun setSituasjon(oppstartNyJobb: LocalDate = LocalDate.of(2045, 12, 16),
                         oppstartUtdanning: LocalDate = LocalDate.of(2025, 7, 28),
                         oppsigelseReduksjonTidspunkt: LocalDate = LocalDate.of(2014, 1, 12)): Builder {

            this.situasjon = Situasjon(
                    Søknadsfelt("Gjelder noe av dette deg?",
                                listOf("Barnet mitt er sykt",
                                       "Jeg har søkt om barnepass, men ikke fått plass enda",
                                       "Jeg har barn som har behov for særlig tilsyn på grunn av fysiske, psykiske eller store sosiale problemer"),
                                listOf("Alternativ 1", "Alternativ 2", "Alternativ 3")),
                    dokumentfelt("Legeerklæring"),
                    dokumentfelt("Legeattest for egen sykdom eller sykt barn"),
                    dokumentfelt("Avslag på søknad om barnehageplass, skolefritidsordning e.l."),
                    dokumentfelt("Dokumentasjon av særlig tilsynsbehov"),
                    dokumentfelt("Dokumentasjon av studieopptak"),
                    dokumentfelt("Dokumentasjon av lærlingekontrakt"),
                    Søknadsfelt("Når skal du starte i ny jobb?", oppstartNyJobb),
                    dokumentfelt("Dokumentasjon av jobbtilbud"),
                    Søknadsfelt("Når skal du starte utdanningen?", oppstartUtdanning),
                    Søknadsfelt("Har du sagt opp jobben eller redusert arbeidstiden de siste 6 månedene?",
                                "Ja, jeg har sagt opp jobben eller tatt frivillig permisjon (ikke foreldrepermisjon)"),
                    Søknadsfelt("Hvorfor sa du opp?", "Sjefen var dum"),
                    Søknadsfelt("Når sa du opp?", oppsigelseReduksjonTidspunkt),
                    dokumentfelt("Dokumentasjon av arbeidsforhold"))

            return this
        }

        fun setStønadstart(month: Month = Month.AUGUST, fraÅr: Int = 2018, søkerFraBestemtMåned: Boolean = true): Builder {

            this.stønadsstart = Stønadsstart(
                    Søknadsfelt("Fra måned", month),
                    Søknadsfelt("Fra år", fraÅr),
                    Søknadsfelt("Søker du stønad fra et bestemt tidspunkt", søkerFraBestemtMåned))

            return this
        }

        fun build(): TestSøknadBuilder {

            val søknadOvergangsstønad =
                    SøknadOvergangsstønad(Søknadsfelt("Søker", personalia),
                                          Søknadsfelt("innsendingsdetaljer", innsendingsdetaljer),
                                          Søknadsfelt("Detaljer om sivilstand", sivilstandsdetaljer),
                                          Søknadsfelt("Opphold i Norge", medlemskapsdetaljer),
                                          Søknadsfelt("Bosituasjonen din", bosituasjon),
                                          Søknadsfelt("Sivilstandsplaner", sivilstandsplaner),
                                          Søknadsfelt("Barn fra folkeregisteret", barn),
                                          Søknadsfelt("Arbeid, utdanning og andre aktiviteter", aktivitet),
                                          Søknadsfelt("Mer om situasjonen din", situasjon),
                                          Søknadsfelt("Når søker du stønad fra?", stønadsstart))

            val søknadBarnetilsyn = SøknadBarnetilsyn(Søknadsfelt("Søker", personalia),
                                                      Søknadsfelt("innsendingsdetaljer", innsendingsdetaljer),
                                                      Søknadsfelt("Detaljer om sivilstand", sivilstandsdetaljer),
                                                      Søknadsfelt("Opphold i Norge", medlemskapsdetaljer),
                                                      Søknadsfelt("Bosituasjonen din", bosituasjon),
                                                      Søknadsfelt("Sivilstandsplaner", sivilstandsplaner),
                                                      Søknadsfelt("Barn fra folkeregisteret", barn),
                                                      Søknadsfelt("Arbeid, utdanning og andre aktiviteter", aktivitet),
                                                      Søknadsfelt("Når søker du stønad fra?", stønadsstart),
                                                      defaultBarnetilsynDokumentasjon())

            val søknadSkolepenger = SøknadSkolepenger(Søknadsfelt("Søker", personalia),
                                                      Søknadsfelt("Barn fra folkeregisteret", barn),
                                                      Søknadsfelt("innsendingsdetaljer", innsendingsdetaljer),
                                                      Søknadsfelt("Detaljer om sivilstand", sivilstandsdetaljer),
                                                      Søknadsfelt("Opphold i Norge", medlemskapsdetaljer),
                                                      Søknadsfelt("Bosituasjonen din", bosituasjon),
                                                      Søknadsfelt("Sivilstandsplaner", sivilstandsplaner),
                                                      Søknadsfelt("Utdanningen du skal ta", defaultUtdanning()),
                                                      SkolepengerDokumentasjon(dokumentfelt("utdanningsutgifter")))

            val testSøknad = TestSøknadBuilder(
                    søknadOvergangsstønad,
                    søknadSkolepenger,
                    søknadBarnetilsyn,
                    personalia,
                    innsendingsdetaljer,
                    sivilstandsdetaljer,
                    medlemskapsdetaljer,
                    bosituasjon,
                    sivilstandsplaner,
                    barn,
                    aktivitet,
                    situasjon,
                    stønadsstart)

            return testSøknad
        }

        private fun personMinimum(fødselsdato: LocalDate = LocalDate.of(1992, 2, 18)): PersonMinimum {
            return PersonMinimum(
                    Søknadsfelt("Navn", "Bob Burger"),
                    null,
                    Søknadsfelt("Fødselsdato", fødselsdato))
        }

        private fun dokumentfelt(navn: String) =
                Søknadsfelt("Dokument",
                            Dokumentasjon(Søknadsfelt("Har sendt inn tidligere", false), listOf(Dokument("vedlegg1", navn))))

        private fun defaultBarn(navnOgFnr: NavnOgFnr? = null): Barn {
            return Barn(Søknadsfelt("Navn", navnOgFnr?.navn ?: "Lykkeliten"),
                        Søknadsfelt("Fødselsnummer", Fødselsnummer(navnOgFnr?.fødselsnummer ?: FnrGenerator.generer())),
                        Søknadsfelt("Har samme adresse som søker", true),
                        Søknadsfelt("ikkeRegistrertPåSøkersAdresseBeskrivelse", "Fordi"),
                        Søknadsfelt("Er barnet født?", false),
                        Søknadsfelt("Termindato", LocalDate.of(2020, 5, 16)),
                        dokumentfelt("Bekreftelse på ventet fødselsdato"),
                        Søknadsfelt("Barnets andre forelder",
                                    AnnenForelder(person = Søknadsfelt("personalia", personMinimum()))),
                        Søknadsfelt("samvær",
                                    Samvær(Søknadsfelt("Har du og den andre forelderen skriftlig avtale om delt bosted for barnet?",
                                                       true),
                                           dokumentfelt("Avtale om delt bosted for barna"),
                                           Søknadsfelt("Har den andre forelderen samvær med barnet",
                                                       "Ja, men ikke mer enn vanlig samværsrett"),
                                           Søknadsfelt("Har dere skriftlig samværsavtale for barnet?",
                                                       "Ja, men den beskriver ikke når barnet er sammen med hver av foreldrene"),
                                           dokumentfelt("Avtale om samvær"),
                                           dokumentfelt("Annen forelder samarbeider ikke om folkeregistrert adresse"),
                                           Søknadsfelt("Hvordan praktiserer dere samværet?",
                                                       "Litt hver for oss"),
                                           Søknadsfelt("Bor du og den andre forelderen til [barnets navn] i samme hus/blokk, gårdstun, kvartal eller vei?",
                                                       "ja"),
                                           Søknadsfelt("borAnnenForelderISammeHusBeskrivelse",
                                                       "Bor i utleiedel"),
                                           Søknadsfelt("Har du bodd sammen med den andre forelderen til [barnets fornavn] før?",
                                                       true),
                                           Søknadsfelt("Når flyttet dere fra hverandre?",
                                                       LocalDate.of(2018, 7, 21)),
                                           dokumentfelt("Erklæring om samlivsbrudd"),
                                           Søknadsfelt("Hvor mye er du sammen med den andre forelderen til barnet?",
                                                       "Vi møtes også uten at barnet er til stede"),
                                           Søknadsfelt("Beskriv  hvor mye er du sammen med den andre forelderen til barnet?",
                                                       "Vi sees stadig vekk"))))
        }

        private fun defaultInnsendingsdetaljer(
                datoMottatt: LocalDateTime): Innsendingsdetaljer {
            return Innsendingsdetaljer(Søknadsfelt("Dato mottatt", datoMottatt))
        }

        private fun defaultSamvær(): Samvær {
            return Samvær(Søknadsfelt("Har du og den andre forelderen skriftlig avtale om delt bosted for barnet?",
                                      true),
                          dokumentfelt("Avtale om delt bosted for barna"),
                          Søknadsfelt("Har den andre forelderen samvær med barnet",
                                      "Ja, men ikke mer enn vanlig samværsrett"),
                          Søknadsfelt("Har dere skriftlig samværsavtale for barnet?",
                                      "Ja, men den beskriver ikke når barnet er sammen med hver av foreldrene"),
                          dokumentfelt("Avtale om samvær"),
                          dokumentfelt("Annen forelder samarbeider ikke om folkeregistrert adresse"),
                          Søknadsfelt("Hvordan praktiserer dere samværet?",
                                      "Litt hver for oss"),
                          Søknadsfelt("Bor du og den andre forelderen til [barnets navn] i samme hus/blokk, gårdstun, kvartal eller vei?",
                                      "ja"),
                          Søknadsfelt("borAnnenForelderISammeHusBeskrivelse",
                                      "Bor i utleiedel"),
                          Søknadsfelt("Har du bodd sammen med den andre forelderen til [barnets fornavn] før?",
                                      true),
                          Søknadsfelt("Når flyttet dere fra hverandre?",
                                      LocalDate.of(2018, 7, 21)),
                          dokumentfelt("Erklæring om samlivsbrudd"),
                          Søknadsfelt("Hvor mye er du sammen med den andre forelderen til barnet?",
                                      "Vi møtes også uten at barnet er til stede"),
                          Søknadsfelt("Beskriv  hvor mye er du sammen med den andre forelderen til barnet?",
                                      "Vi sees stadig vekk"))
        }

        private fun defaultUtenlandsopphold(): List<Utenlandsopphold> {
            return listOf(Utenlandsopphold(
                    Søknadsfelt("Fra", LocalDate.of(2012, 12, 4)),
                    Søknadsfelt("Til", LocalDate.of(2012, 12, 18)),
                    Søknadsfelt("Hvorfor bodde du i utlandet?", "Granca, Granca, Granca")))
        }

        private fun defaultArbeidsgiver(): List<Arbeidsgiver> {
            return listOf(Arbeidsgiver(Søknadsfelt("Navn på arbeidsgiveren", "Palpatine"),
                                       Søknadsfelt("Hvor mye jobber du?", 15),
                                       Søknadsfelt("Er stillingen fast eller midlertidig?",
                                                   "Fast"),
                                       Søknadsfelt("Har du en sluttdato?", true),
                                       Søknadsfelt("Når skal du slutte?",
                                                   LocalDate.of(2020, 11, 18))))
        }

        private fun defaultSelvstendig(): Selvstendig {
            return Selvstendig(Søknadsfelt("Navn på firma", "Bobs burgers"),
                               Søknadsfelt("Organisasjonsnummer", "987654321"),
                               Søknadsfelt("Når etablerte du firmaet?",
                                           LocalDate.of(2018, 4, 5)),
                               Søknadsfelt("Hvor mye jobber du?", 150),
                               Søknadsfelt("Hvordan ser arbeidsuken din ut?",
                                           "Veldig tung"))
        }

        private fun defaultVirksomhet(): Virksomhet {
            return Virksomhet(Søknadsfelt("Beskriv virksomheten", "Den kommer til å revolusjonere verden"),
                              dokumentfelt("Etablerer egen virksomhet dokumentasjon"))
        }

        private fun defaultArbeidssøker(): Arbeidssøker {
            return Arbeidssøker(Søknadsfelt("Er du registrert som arbeidssøker hos NAV?", true),
                                Søknadsfelt("Er du villig til å ta imot tilbud om arbeid eller arbeidsmarkedstiltak?",
                                            true),
                                Søknadsfelt("Kan du begynne i arbeid senest én uke etter at du har fått tilbud om jobb?",
                                            true),
                                Søknadsfelt("Har du eller kan du skaffe barnepass senest innen en uke etter at du har fått tilbud om jobb eller arbeidsmarkedstiltak?",
                                            false),
                                Søknadsfelt("Hvor ønsker du å søke arbeid?",
                                            "Kun i bodistriktet mitt, ikke mer enn 1 times reisevei"),
                                Søknadsfelt("Ønsker du å stå som arbeidssøker til minst 50% stilling?",
                                            true))
        }

        private fun defaultAksjeselskap(): List<Aksjeselskap> {
            return listOf(Aksjeselskap(Søknadsfelt("Navn", "Fima abc"),
                                       Søknadsfelt("arbeidsmengde", 50)))
        }

        private fun defaultUtdanning(): UnderUtdanning {
            return UnderUtdanning(Søknadsfelt("Skole/utdanningssted", "UiO"),
                                  Søknadsfelt("Bakoverkompatibel Utdanning",
                                              TidligereUtdanning(Søknadsfelt("Linje/kurs/grad",
                                                                             "Profesjonsstudium Informatikk"),
                                                                 Søknadsfelt("Når skal du være elev/student?",
                                                                             MånedÅrPeriode(Month.APRIL,
                                                                                            2020,
                                                                                            Month.JANUARY,
                                                                                            2021)
                                                                 ))),
                                  Søknadsfelt("Utdanning",
                                              GjeldendeUtdanning(Søknadsfelt("Linje/kurs/grad",
                                                                             "Profesjonsstudium Informatikk"),
                                                                 Søknadsfelt("Når skal du være elev/student?",
                                                                             Datoperiode(LocalDate.of(1999, 1, 1),
                                                                                         LocalDate.of(2004, 10, 12))
                                                                 ))),
                                  Søknadsfelt("Er utdanningen offentlig eller privat?",
                                              "Offentlig"),
                                  Søknadsfelt("Heltid, eller deltid", "Deltid"),
                                  Søknadsfelt("Hvor mye skal du studere?", 300),
                                  Søknadsfelt("Hva er målet med utdanningen?",
                                              "Økonomisk selvstendighet"),
                                  Søknadsfelt("Har du tatt utdanning etter grunnskolen?", true),
                                  Søknadsfelt("Tidligere Utdanning",
                                              listOf(TidligereUtdanning(Søknadsfelt("Linje/kurs/grad",
                                                                                    "Master Fysikk"),
                                                                        Søknadsfelt("Når var du elev/student?",
                                                                                    MånedÅrPeriode(Month.JANUARY,
                                                                                                   1999,
                                                                                                   Month.OCTOBER,
                                                                                                   2004))))
                                  )
            )
        }

        private fun defaultAdresse(): Adresse {
            return Adresse("Jerpefaret 5C", "1440", "Drøbak", "Norge")
        }

        private fun defaultBarnetilsynDokumentasjon() = BarnetilsynDokumentasjon(dokumentfelt("barnepassordningFaktura"),
                                                                                 dokumentfelt("avtaleBarnepasser"),
                                                                                 dokumentfelt("arbeidstid"),
                                                                                 dokumentfelt("roterendeArbeidstid"),
                                                                                 dokumentfelt("spesielleBehov"))

    }
}

data class NavnOgFnr(val navn: String, val fødselsnummer: String)
