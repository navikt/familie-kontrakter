package no.nav.familie.kontrakter.ef.søknad

import no.nav.familie.util.FnrGenerator
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month

object Testsøknad {

    val søknadOvergangsstønad: SøknadOvergangsstønad = TestsøknadBuilder.Builder().build().søknadOvergangsstønad
    val søknadSkolepenger: SøknadSkolepenger = TestsøknadBuilder.Builder().build().søknadSkolepenger
    val søknadBarnetilsyn: SøknadBarnetilsyn = TestsøknadBuilder.Builder().build().søknadBarnetilsyn
}

class TestsøknadBuilder private constructor(

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

        private lateinit var barnetilsynBarn: List<Barn>
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
                Søknadsfelt("Fødselsnummer", Fødselsnummer(navnOgFnr?.fødselsnummer ?: FnrGenerator.generer())),
                Søknadsfelt("Navn", navnOgFnr?.navn ?: "Kari Nordmann"),
                Søknadsfelt("Statsborgerskap", "Norsk"),
                Søknadsfelt("Adresse", adresse),
                Søknadsfelt("Sivilstand", "Ugift")
            )

            return this
        }

        fun setInnsendingsdetaljer(datoMottatt: LocalDateTime = LocalDateTime.of(2020, 5, 5, 11, 32)): Builder {
            this.innsendingsdetaljer = defaultInnsendingsdetaljer(datoMottatt)
            return this
        }

        fun setSivilstandsdetaljer(
            erUformeltGift: Boolean = true,
            erUformeltGiftDokumentasjon: String = "giftIUtlandetDokumentasjon",
            erUformeltSeparertEllerSkilt: Boolean = true,
            erUformeltSeparertEllerSkiltDokumentasjon: String = "separertEllerSkiltIUtlandetDokumentasjon",
            søktOmSkilsmisseSeparasjon: Boolean = true,
            datoSøktSeparasjon: LocalDate = LocalDate.of(2015, 12, 23),
            separasjonsbekreftelse: String = "Skilsmisse- eller separasjonsbevilling",
            årsakEnslig: EnumTekstverdiMedSvarId = EnumTekstverdiMedSvarId(
                "Trives best alene",
                "aleneFraFødsel"
            ),
            samlivsbruddsdokumentasjon: String = "Erklæring om samlivsbrudd",
            samlivsbruddsdato: LocalDate = LocalDate.of(2014, 10, 3),
            fraflytningsdato: LocalDate = LocalDate.of(2014, 10, 4),
            endringSamværsordningDato: LocalDate = LocalDate.of(2013, 4, 17),
            tidligereSamboerdetaljer: PersonMinimum = defaultPersonMinimum()
        ): Builder {

            this.sivilstandsdetaljer = Sivilstandsdetaljer(
                Søknadsfelt("Er du gift uten at dette er formelt registrert eller godkjent i Norge?", erUformeltGift),
                defaultDokumentfelt(erUformeltGiftDokumentasjon),
                Søknadsfelt(
                    "Er du separert eller skilt uten at dette er formelt registrert eller godkjent i Norge?",
                    erUformeltSeparertEllerSkilt
                ),
                defaultDokumentfelt(erUformeltSeparertEllerSkiltDokumentasjon),
                Søknadsfelt(
                    "Har dere søkt om separasjon, søkt om skilsmisse eller reist sak for domstolen?",
                    søktOmSkilsmisseSeparasjon
                ),
                Søknadsfelt("Når søkte dere eller reiste sak?", datoSøktSeparasjon),
                defaultDokumentfelt(separasjonsbekreftelse),
                Søknadsfelt(
                    label = "Hva er grunnen til at du er alene med barn?",
                    verdi = årsakEnslig.verdi,
                    svarId = årsakEnslig.svarId
                ),
                defaultDokumentfelt(samlivsbruddsdokumentasjon),
                Søknadsfelt("Dato for samlivsbrudd", samlivsbruddsdato),
                Søknadsfelt("Når flyttet dere fra hverandre?", fraflytningsdato),
                Søknadsfelt("Når skjedde endringen / når skal endringen skje?", endringSamværsordningDato),
                Søknadsfelt("Om den tidligere samboern din", tidligereSamboerdetaljer)
            )

            return this
        }

        fun setMedlemskapsdetaljer(
            oppholderDuDegINorge: Boolean = true,
            bosattNorgeSisteÅrene: Boolean = true,
            utenlandsopphold: List<Utenlandsopphold> = defaultUtenlandsopphold()
        ): Builder {

            this.medlemskapsdetaljer = Medlemskapsdetaljer(
                Søknadsfelt("Oppholder du deg i Norge?", oppholderDuDegINorge),
                Søknadsfelt("Har du bodd i Norge de siste tre årene?", bosattNorgeSisteÅrene),
                Søknadsfelt("", utenlandsopphold)
            )

            return this
        }

        fun setBosituasjon(
            delerDuBolig: EnumTekstverdiMedSvarId = EnumTekstverdiMedSvarId(
                "Ja, jeg har samboer og lever i et ekteskapslignende forhold",
                "harEkteskapsliknendeForhold"
            ),
            samboerdetaljer: PersonMinimum = defaultPersonMinimum(),
            sammenflyttingsdato: LocalDate = LocalDate.of(2018, 8, 12),
            datoFlyttetFraHverandre: LocalDate = LocalDate.of(2019, 8, 12)
        ): Builder {

            this.bosituasjon = Bosituasjon(
                Søknadsfelt(
                    label = "Deler du bolig med andre voksne?",
                    verdi = delerDuBolig.verdi,
                    svarId = delerDuBolig.svarId
                ),
                Søknadsfelt("Om samboeren din", samboerdetaljer),
                Søknadsfelt("Når flyttet dere sammen?", sammenflyttingsdato),
                Søknadsfelt("Når flyttet dere fra hverandre?", datoFlyttetFraHverandre)
            )

            return this
        }

        fun setSivilstandsplaner(
            harPlaner: Boolean = true,
            fraDato: LocalDate = LocalDate.of(2021, 4, 15),
            vordendeSamboerEktefelle: PersonMinimum = defaultPersonMinimum()
        ): Builder {

            this.sivilstandsplaner = Sivilstandsplaner(
                Søknadsfelt("Har du konkrete planer om å gifte deg eller bli samboer", harPlaner),
                Søknadsfelt("Når skal dette skje?", fraDato),
                Søknadsfelt("Hvem skal du gifte deg eller bli samboer med?", vordendeSamboerEktefelle)
            )

            return this
        }

        fun defaultBarn(
            navn: String = "Lykkeliten",
            fødselsnummer: String? = null,
            harSkalHaSammeAdresse: Boolean = true,
            ikkeRegistrertPåSøkersAdresseBeskrivelse: String = "Fordi",
            erBarnetFødt: Boolean = false,
            fødselTermindato: LocalDate = LocalDate.of(2020, 5, 16),
            annenForelder: AnnenForelder = defaultAnnenForelder(),
            samvær: Samvær = defaultSamvær(),
            skalHaBarnepass: Boolean = false,
            særligeTilsynsbehov: String = "Barnet mitt trenger ekstra oppfølging",
            barnepass: Barnepass? = null,
            lagtTilManuelt: Boolean = true,
            skalBoHosSøker: String? = "jaMenSamarbeiderIkke"

        ): Barn {
            return Barn(
                Søknadsfelt("Navn", navn),
                Søknadsfelt(
                    "Fødselsnummer",
                    fødselsnummer?.let { Fødselsnummer(it) } ?: Fødselsnummer(FnrGenerator.generer())
                ),
                Søknadsfelt("Har samme adresse som søker", harSkalHaSammeAdresse),
                Søknadsfelt(
                    "ikkeRegistrertPåSøkersAdresseBeskrivelse",
                    ikkeRegistrertPåSøkersAdresseBeskrivelse
                ),
                Søknadsfelt("Er barnet født?", erBarnetFødt),
                Søknadsfelt("Termindato", fødselTermindato),
                defaultDokumentfelt("Bekreftelse på ventet fødselsdato"),
                Søknadsfelt("Barnets andre forelder", annenForelder),
                Søknadsfelt("samvær", samvær),
                Søknadsfelt("Skal ha barnepass", skalHaBarnepass),
                Søknadsfelt("Særlige tilsynsbehov", særligeTilsynsbehov),
                barnepass?.let { Søknadsfelt("Barnepass", it) },
                lagtTilManuelt = lagtTilManuelt,
                Søknadsfelt(
                    "Skal barnet bo hos søker",
                    "Ja, men den andre forelderen samarbeider ikke",
                    null,
                    skalBoHosSøker
                )
            )
        }

        fun setBarn(barn: List<Barn> = listOf(defaultBarn())): Builder {
            this.barn = barn
            this.barnetilsynBarn = barn.map {
                it.copy(
                    skalHaBarnepass = Søknadsfelt("Skal ha barnepass", true),
                    barnepass = it.barnepass ?: Søknadsfelt(
                        "Barnepass",
                        defaultBarnepass(ordninger = listOf(defaultBarnepassordning()))
                    )
                )
            }

            return this
        }

        fun setAktivitet(
            hvordanErArbeidssituasjonen: List<EnumTekstverdiMedSvarId> =
                listOf(
                    EnumTekstverdiMedSvarId(
                        "Jeg er hjemme med barn under 1 år (vises kun hvis har barn under 1 år)",
                        "erHjemmeMedBarnUnderEttÅr"
                    ),
                    EnumTekstverdiMedSvarId("Jeg er i arbeid", "erArbeidstaker"),
                    EnumTekstverdiMedSvarId(
                        "Jeg er selvstendig næringsdrivende eller frilanser",
                        "erSelvstendigNæringsdriveneEllerFrilanser"
                    ),
                ),
            arbeidsforhold: List<Arbeidsgiver> = defaultArbeidsgiver(),
            selvstendig: Søknadsfelt<Selvstendig>? = null, // deprecated
            firmaer: List<Selvstendig> = listOf(defaultSelvstendig()),
            virksomhet: Virksomhet = defaultVirksomhet(),
            arbeidssøker: Arbeidssøker = defaultArbeidssøker(),
            underUtdanning: UnderUtdanning = defaultUtdanning(),
            aksjeselskap: List<Aksjeselskap> = defaultAksjeselskap()
        ): Builder {

            this.aktivitet = Aktivitet(
                Søknadsfelt(
                    "Hvordan er arbeidssituasjonen din?",
                    verdi = hvordanErArbeidssituasjonen.map { it.verdi },
                    svarId = hvordanErArbeidssituasjonen.map { it.svarId }
                ),
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

        fun setSituasjon(
            oppstartNyJobb: LocalDate = LocalDate.of(2045, 12, 16),
            oppstartUtdanning: LocalDate = LocalDate.of(2025, 7, 28),
            oppsigelseReduksjonTidspunkt: LocalDate = LocalDate.of(2014, 1, 12)
        ): Builder {

            this.situasjon = Situasjon(
                Søknadsfelt(
                    "Gjelder noe av dette deg?",
                    listOf(
                        "Barnet mitt er sykt",
                        "Jeg har søkt om barnepass, men ikke fått plass enda",
                        "Jeg har barn som har behov for særlig tilsyn på grunn av fysiske, psykiske eller store sosiale problemer"
                    ),
                    listOf("Alternativ 1", "Alternativ 2", "Alternativ 3"),
                    listOf("harSyktBarn", "harSøktBarnepassOgVenterEnnå", "harBarnMedSærligeBehov")
                ),
                defaultDokumentfelt("Legeerklæring"),
                defaultDokumentfelt("Legeattest for egen sykdom eller sykt barn"),
                defaultDokumentfelt("Avslag på søknad om barnehageplass, skolefritidsordning e.l."),
                defaultDokumentfelt("Dokumentasjon av særlig tilsynsbehov"),
                defaultDokumentfelt("Dokumentasjon av studieopptak"),
                defaultDokumentfelt("Dokumentasjon av lærlingekontrakt"),
                Søknadsfelt("Når skal du starte i ny jobb?", oppstartNyJobb),
                defaultDokumentfelt("Dokumentasjon av jobbtilbud"),
                Søknadsfelt("Når skal du starte utdanningen?", oppstartUtdanning),
                Søknadsfelt(
                    label = "Har du sagt opp jobben eller redusert arbeidstiden de siste 6 månedene?",
                    verdi = "Ja, jeg har sagt opp jobben eller tatt frivillig permisjon (ikke foreldrepermisjon)",
                    svarId = "sagtOpp"
                ),
                Søknadsfelt("Hvorfor sa du opp?", "Sjefen var dum"),
                Søknadsfelt("Når sa du opp?", oppsigelseReduksjonTidspunkt),
                defaultDokumentfelt("Dokumentasjon av arbeidsforhold")
            )

            return this
        }

        fun setStønadstart(month: Month = Month.AUGUST, fraÅr: Int = 2018, søkerFraBestemtMåned: Boolean = true): Builder {

            this.stønadsstart = Stønadsstart(
                Søknadsfelt("Fra måned", month),
                Søknadsfelt("Fra år", fraÅr),
                Søknadsfelt("Søker du stønad fra et bestemt tidspunkt", søkerFraBestemtMåned)
            )

            return this
        }

        fun build(): TestsøknadBuilder {

            val søknadOvergangsstønad =
                SøknadOvergangsstønad(
                    Søknadsfelt("Søker", personalia),
                    Søknadsfelt("innsendingsdetaljer", innsendingsdetaljer),
                    Søknadsfelt("Detaljer om sivilstand", sivilstandsdetaljer),
                    Søknadsfelt("Opphold i Norge", medlemskapsdetaljer),
                    Søknadsfelt("Bosituasjonen din", bosituasjon),
                    Søknadsfelt("Sivilstandsplaner", sivilstandsplaner),
                    Søknadsfelt("Barn fra folkeregisteret", barn),
                    Søknadsfelt("Arbeid, utdanning og andre aktiviteter", aktivitet),
                    Søknadsfelt("Mer om situasjonen din", situasjon),
                    Søknadsfelt("Når søker du stønad fra?", stønadsstart)
                )

            val søknadBarnetilsyn = SøknadBarnetilsyn(
                Søknadsfelt("Søker", personalia),
                Søknadsfelt("innsendingsdetaljer", innsendingsdetaljer),
                Søknadsfelt("Detaljer om sivilstand", sivilstandsdetaljer),
                Søknadsfelt("Opphold i Norge", medlemskapsdetaljer),
                Søknadsfelt("Bosituasjonen din", bosituasjon),
                Søknadsfelt("Sivilstandsplaner", sivilstandsplaner),
                Søknadsfelt("Barn fra folkeregisteret", barnetilsynBarn),
                Søknadsfelt("Arbeid, utdanning og andre aktiviteter", aktivitet),
                Søknadsfelt("Når søker du stønad fra?", stønadsstart),
                defaultBarnetilsynDokumentasjon()
            )

            val søknadSkolepenger = SøknadSkolepenger(
                personalia = Søknadsfelt("Søker", personalia),
                barn = Søknadsfelt("Barn fra folkeregisteret", barn),
                innsendingsdetaljer = Søknadsfelt(
                    "innsendingsdetaljer",
                    innsendingsdetaljer
                ),
                sivilstandsdetaljer = Søknadsfelt(
                    "Detaljer om sivilstand",
                    sivilstandsdetaljer
                ),
                medlemskapsdetaljer = Søknadsfelt("Opphold i Norge", medlemskapsdetaljer),
                bosituasjon = Søknadsfelt("Bosituasjonen din", bosituasjon),
                sivilstandsplaner = Søknadsfelt("Sivilstandsplaner", sivilstandsplaner),
                utdanning = Søknadsfelt("Utdanningen du skal ta", defaultUtdanning()),
                dokumentasjon = SkolepengerDokumentasjon(defaultDokumentfelt("utdanningsutgifter"))
            )

            val testSøknad = TestsøknadBuilder(
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
                stønadsstart
            )

            return testSøknad
        }

        fun defaultPersonMinimum(
            navn: String = "Bob Burger",
            fødselsdato: LocalDate = LocalDate.of(1992, 2, 18),
            fødselsnummer: String? = null,
            land: String? = null
        ): PersonMinimum {

            return PersonMinimum(
                Søknadsfelt("Navn", navn),
                fødselsnummer?.let { Søknadsfelt("fødselsnummer", Fødselsnummer(fødselsnummer)) },
                Søknadsfelt("Fødselsdato", fødselsdato),
                land?.let { Søknadsfelt("land", it) }
            )
        }

        fun defaultDokumentfelt(navn: String) =
            Søknadsfelt(
                "Dokument",
                Dokumentasjon(Søknadsfelt("Har sendt inn tidligere", false), listOf(Dokument("vedlegg1", navn)))
            )

        fun defaultAnnenForelder(
            personMinimum: PersonMinimum? = defaultPersonMinimum(),
            ikkeOppgittAnnenForelderBegrunnelse: String? = null,
            bosattINorge: Boolean? = null,
            land: String? = null
        ) = AnnenForelder(
            person = personMinimum?.let { Søknadsfelt("personalia", it) },
            ikkeOppgittAnnenForelderBegrunnelse = ikkeOppgittAnnenForelderBegrunnelse?.let {
                Søknadsfelt("Ikke oppgitt annen forelder begrunnelse", ikkeOppgittAnnenForelderBegrunnelse)
            },
            bosattNorge = bosattINorge?.let { Søknadsfelt("Bosatt i norge", it) },
            land = land?.let { Søknadsfelt("Land", it) }
        )

        fun defaultBarnepassordning(
            type: String = "barnehageOgLiknende",
            navn: String = "Dyrehagen barnehage",
            fraDato: LocalDate = LocalDate.of(2021, 1, 1),
            tilDato: LocalDate = LocalDate.of(2021, 6, 30),
            beløp: Double = 3200.0
        ): BarnepassOrdning = BarnepassOrdning(
            hvaSlagsBarnepassOrdning = Søknadsfelt(
                label = "Hva slags barnepassordning",
                verdi = "Barnehage og lignende",
                svarId = type
            ),
            navn = Søknadsfelt(label = "Navn på barnepassordning", verdi = navn),
            datoperiode = Søknadsfelt("Periode", Datoperiode(fra = fraDato, til = tilDato)),
            belop = Søknadsfelt(label = "Beløp", verdi = beløp)

        )

        fun defaultBarnepass(
            årsakSvarId: String? = "trengerMerPassEnnJevnaldrede",
            ordninger: List<BarnepassOrdning>
        ) = Barnepass(
            årsakBarnepass = årsakSvarId?.let {
                Søknadsfelt(
                    "Årsak barnepass",
                    "Trenger mer pass enn jevnaldrende",
                    null,
                    it
                )
            },
            barnepassordninger = Søknadsfelt("barnepassOrdninger", ordninger)
        )

        fun defaultInnsendingsdetaljer(
            datoMottatt: LocalDateTime
        ): Innsendingsdetaljer {
            return Innsendingsdetaljer(Søknadsfelt("Dato mottatt", datoMottatt))
        }

        fun defaultSamvær(
            spørsmålAvtaleOmDeltBosted: Boolean = true,
            skalAnnenForelderHaSamvær: String = "jaMerEnnVanlig",
            harDereSkriftligAvtaleOmSamvær: String = "jaIkkeKonkreteTidspunkter",
            hvordanPraktiseresSamværet: String = "Litt hver for oss",
            borAnnenForelderISammeHus: String = "ja",
            borAnnenForelderISammeHusBeskrivelse: String = "Har du bodd sammen med den andre forelderen til [barnets fornavn] før?",
            harDereTidligereBoddSammen: Boolean = true,
            nårFlyttetDereFraHverandre: LocalDate? = LocalDate.of(2018, 7, 21),
            hvorMyeErDuSammenMedAnnenForelder: String = "kunNårLeveres",
            beskrivSamværUtenBarn: String = "Vi sees stadig vekk"
        ): Samvær {
            return Samvær(
                Søknadsfelt(
                    "Har du og den andre forelderen skriftlig avtale om delt bosted for barnet?",
                    spørsmålAvtaleOmDeltBosted
                ),
                defaultDokumentfelt("Avtale om delt bosted for barna"),
                Søknadsfelt(
                    "Har den andre forelderen samvær med barnet",
                    "Ja, men ikke mer enn vanlig samværsrett",
                    null,
                    skalAnnenForelderHaSamvær
                ),
                Søknadsfelt(
                    "Har dere skriftlig samværsavtale for barnet?",
                    "Ja, men den beskriver ikke når barnet er sammen med hver av foreldrene",
                    null,
                    harDereSkriftligAvtaleOmSamvær
                ),
                defaultDokumentfelt("Avtale om samvær"),
                defaultDokumentfelt("Annen forelder samarbeider ikke om folkeregistrert adresse"),
                Søknadsfelt(
                    "Hvordan praktiserer dere samværet?",
                    hvordanPraktiseresSamværet
                ),
                Søknadsfelt(
                    "Bor du og den andre forelderen til [barnets navn] i samme hus/blokk, gårdstun, kvartal eller vei?",
                    "Litt hver for oss",
                    null,
                    borAnnenForelderISammeHus
                ),
                Søknadsfelt(
                    "borAnnenForelderISammeHusBeskrivelse", "Bor i utleiedel", null,
                    borAnnenForelderISammeHusBeskrivelse
                ),
                Søknadsfelt(
                    "Har du bodd sammen med den andre forelderen til [barnets fornavn] før?",
                    harDereTidligereBoddSammen
                ),
                nårFlyttetDereFraHverandre?.let { Søknadsfelt("Når flyttet dere fra hverandre?", it) },
                defaultDokumentfelt("Erklæring om samlivsbrudd"),
                Søknadsfelt(
                    "Hvor mye er du sammen med den andre forelderen til barnet?",
                    "Vi møtes også uten at barnet er til stede",
                    null,
                    hvorMyeErDuSammenMedAnnenForelder
                ),
                Søknadsfelt(
                    "Beskriv  hvor mye er du sammen med den andre forelderen til barnet?",
                    "Vi sees stadig vekk",
                    null,
                    beskrivSamværUtenBarn
                )
            )
        }

        private fun defaultUtenlandsopphold(): List<Utenlandsopphold> {
            return listOf(
                Utenlandsopphold(
                    Søknadsfelt("Fra", LocalDate.of(2012, 12, 4)),
                    Søknadsfelt("Til", LocalDate.of(2012, 12, 18)),
                    Søknadsfelt("Hvorfor bodde du i utlandet?", "Granca, Granca, Granca")
                )
            )
        }

        private fun defaultArbeidsgiver(): List<Arbeidsgiver> {
            return listOf(
                Arbeidsgiver(
                    Søknadsfelt("Navn på arbeidsgiveren", "Palpatine"),
                    Søknadsfelt("Hvor mye jobber du?", 15),
                    Søknadsfelt(
                        "Er stillingen fast eller midlertidig?",
                        "Fast"
                    ),
                    Søknadsfelt("Har du en sluttdato?", true),
                    Søknadsfelt(
                        "Når skal du slutte?",
                        LocalDate.of(2020, 11, 18)
                    )
                )
            )
        }

        private fun defaultSelvstendig(): Selvstendig {
            return Selvstendig(
                Søknadsfelt("Navn på firma", "Bobs burgers"),
                Søknadsfelt("Organisasjonsnummer", "987654321"),
                Søknadsfelt(
                    "Når etablerte du firmaet?",
                    LocalDate.of(2018, 4, 5)
                ),
                Søknadsfelt("Hvor mye jobber du?", 150),
                Søknadsfelt(
                    "Hvordan ser arbeidsuken din ut?",
                    "Veldig tung"
                )
            )
        }

        private fun defaultVirksomhet(): Virksomhet {
            return Virksomhet(
                Søknadsfelt("Beskriv virksomheten", "Den kommer til å revolusjonere verden"),
                defaultDokumentfelt("Etablerer egen virksomhet dokumentasjon")
            )
        }

        private fun defaultArbeidssøker(
            registrertArbeidssøker: Boolean = true,
            villigTilArbeid: Boolean = true,
            kanStarteNårSomHelst: Boolean = true,
            harBarnepassInnenEnUke: Boolean = true,
            hvorØnskerDuArbeid: String = "nærme",
            ønskerÅStåSomArbeidssøker: Boolean = true,
        ): Arbeidssøker {
            return Arbeidssøker(
                Søknadsfelt("Er du registrert som arbeidssøker hos NAV?", registrertArbeidssøker),
                Søknadsfelt(
                    "Er du villig til å ta imot tilbud om arbeid eller arbeidsmarkedstiltak?",
                    villigTilArbeid
                ),
                Søknadsfelt(
                    "Kan du begynne i arbeid senest én uke etter at du har fått tilbud om jobb?",
                    kanStarteNårSomHelst
                ),
                Søknadsfelt(
                    "Har du eller kan du skaffe barnepass senest innen en uke etter at du har fått tilbud om jobb eller arbeidsmarkedstiltak?",
                    harBarnepassInnenEnUke
                ),
                Søknadsfelt(
                    "Hvor ønsker du å søke arbeid?",
                    "Kun i bodistriktet mitt, ikke mer enn 1 times reisevei",
                    null, hvorØnskerDuArbeid
                ),
                Søknadsfelt(
                    "Ønsker du å stå som arbeidssøker til minst 50% stilling?",
                    ønskerÅStåSomArbeidssøker
                )
            )
        }

        private fun defaultAksjeselskap(): List<Aksjeselskap> {
            return listOf(
                Aksjeselskap(
                    Søknadsfelt("Navn", "Fima abc"),
                    Søknadsfelt("arbeidsmengde", 50)
                )
            )
        }

        private fun defaultUtdanning(): UnderUtdanning {
            return UnderUtdanning(
                skoleUtdanningssted = Søknadsfelt("Skole/utdanningssted", "UiO"),
                utdanning = Søknadsfelt(
                    "Bakoverkompatibel Utdanning",
                    TidligereUtdanning(
                        Søknadsfelt(
                            "Linje/kurs/grad",
                            "Profesjonsstudium Informatikk"
                        ),
                        Søknadsfelt(
                            "Når skal du være elev/student?",
                            MånedÅrPeriode(
                                Month.APRIL,
                                2020,
                                Month.JANUARY,
                                2021
                            )
                        )
                    )
                ),
                gjeldendeUtdanning = Søknadsfelt(
                    "Utdanning",
                    GjeldendeUtdanning(
                        Søknadsfelt(
                            "Linje/kurs/grad",
                            "Profesjonsstudium Informatikk"
                        ),
                        Søknadsfelt(
                            "Når skal du være elev/student?",
                            Datoperiode(
                                LocalDate.of(
                                    1999,
                                    1,
                                    1
                                ),
                                LocalDate.of(
                                    2004,
                                    10,
                                    12
                                )
                            )
                        )
                    )
                ),
                offentligEllerPrivat = Søknadsfelt(
                    label = "Er utdanningen offentlig eller privat?", svarId = "offentlig",
                    verdi = "Offentlig"
                ),
                heltidEllerDeltid = Søknadsfelt(label = "Heltid, eller deltid", svarId = "heltid", verdi = "Heltid"),
                hvorMyeSkalDuStudere = Søknadsfelt("Hvor mye skal du studere?", 100),
                hvaErMåletMedUtdanningen = Søknadsfelt(
                    "Hva er målet med utdanningen?",
                    "Odio quam nulla at amet eget. Faucibus feugiat orci, nisi a venenatis metus. Tincidunt massa amet sapien velit egestas varius in.\n" +
                        "\n" +
                        "Leo sed bibendum sapien eros, dui nunc, purus. Morbi vulputate non facilisi neque pulvinar. Vulputate malesuada risus ipsum scelerisque. Id ac consequat, curabitur fermentum mauris blandit dictum rhoncus nibh. Etiam hendrerit amet tempor ultrices eu ultrices. Enim in parturient at ut tincidunt sit.\n" +
                        "\n" +
                        "Leo donec diam vestibulum tempus at dictum lacinia rutrum. Molestie sit netus sagittis sit sodales ultrices orci. Placerat vehicula sit quis in. Nulla nunc, egestas id etiam sit facilisis enim vitae sed."
                ),
                utdanningEtterGrunnskolen = Søknadsfelt("Har du tatt utdanning etter grunnskolen?", true),
                tidligereUtdanninger = Søknadsfelt(
                    "Tidligere Utdanning",
                    listOf(
                        TidligereUtdanning(
                            Søknadsfelt(
                                "Linje/kurs/grad",
                                "Master Fysikk"
                            ),
                            Søknadsfelt(
                                "Når var du elev/student?",
                                MånedÅrPeriode(
                                    Month.JANUARY,
                                    1999,
                                    Month.OCTOBER,
                                    2004
                                )
                            )
                        ),
                        TidligereUtdanning(
                            Søknadsfelt(
                                "Linje/kurs/grad",
                                "Doktorgrad Fuglekikking"
                            ),
                            Søknadsfelt(
                                "Når var du elev/student?",
                                MånedÅrPeriode(
                                    Month.JULY,
                                    2005,
                                    Month.JUNE,
                                    2012
                                )
                            )
                        )
                    )
                )
            )
        }

        private fun defaultAdresse(): Adresse {
            return Adresse("Jerpefaret 5C", "1440", "Drøbak", "Norge")
        }

        private fun defaultBarnetilsynDokumentasjon() = BarnetilsynDokumentasjon(
            defaultDokumentfelt("barnepassordningFaktura"),
            defaultDokumentfelt("avtaleBarnepasser"),
            defaultDokumentfelt("arbeidstid"),
            defaultDokumentfelt("roterendeArbeidstid"),
            defaultDokumentfelt("spesielleBehov")
        )
    }
}

data class NavnOgFnr(val navn: String, val fødselsnummer: String)
