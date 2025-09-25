package no.nav.familie.kontrakter.felles.arbeidsforhold

class Arbeidsforhold(
    val id: String?,
    val type: Kodeverksentitet?,
    val arbeidstaker: Arbeidstaker?,
    val arbeidssted: Arbeidssted?,
    val opplysningspliktig: Opplysningspliktig?,
    val ansettelsesperiode: Ansettelsesperiode?,
    val ansettelsesdetaljer: List<Ansettelsesdetaljer>?,
    val permisjoner: List<Permisjon>?,
    val permitteringer: List<Permittering>?,
    val timerMedTimeloenn: List<TimerMedTimeloenn>?,
    val utenlandsopphold: List<Utenlandsopphold>?,
    val idHistorikk: List<IdHistorikk>?,
    val varsler: List<Varsel>?,
    val rapporteringsordning: Kodeverksentitet?,
    val navArbeidsforholdId: Long?,
    val navVersjon: Int?,
    val navUuid: String?,
    val opprettet: String?,
    val sistBekreftet: String?,
    val sistEndret: String?,
    val bruksperiode: Bruksperiode?,
    val sporingsinformasjon: Sporingsinformasjon?,
)

class Kodeverksentitet(
    val kode: String?,
    val beskrivelse: String?,
)

class Arbeidstaker(
    val type: String?,
    val offentligIdent: String?,
    val aktoerId: String?,
)

class Arbeidssted(
    val type: ArbeidsstedType?,
    val identer: List<Ident>?,
)

class Ansettelsesperiode(
    val startDato: String?,
    val sluttdato: String?,
    val sluttaarsak: Kodeverksenitet?,
    val varsling: Kodeverksenitet?,
    val sporingsinformasjon: Sporingsinformasjon?,
)

class Ansettelsesdetaljer(
    val arbeidstidsordning: Kodeverksentitet?,
    val ansettelsesform: Kodeverksentitet?,
    val yrke: Kodeverksentitet?,
    val antallTimerPrUke: Double?,
    val avtaltStillingsprosent: Double?,
    val rapporteringsmaaneder: Rapporteringsmaaneder?,
    val sporingsinformasjon: Sporingsinformasjon?,
    val type: AnsettelsesdetaljerType?,
    val sisteStillingsprosentendring: String?,
    val sisteLoennsendring: String?,
)

class Permisjon(
    val id: String?,
    val type: Kodeverksentitet?,
    val startdato: String?,
    val sluttdato: String?,
    val prosent: Double?,
    val varsling: Kodeverksentitet?,
    val idHistorikk: List<IdHistorikk>?,
    val sporingsinformasjon: Sporingsinformasjon?,
)

class Permittering(
    val id: String?,
    val type: Kodeverksentitet?,
    val startdato: String?,
    val sluttdato: String?,
    val prosent: Double?,
    val varsling: Kodeverksentitet?,
    val idHistorikk: List<IdHistorikk>?,
    val sporingsinformasjon: Sporingsinformasjon?,
)

class TimerMedTimeloenn(
    val antall: Double?,
    val startdato: String?,
    val sluttdato: String?,
    val rapporteringsmaaned: String?,
    val sporingsinformasjon: Sporingsinformasjon?,
)

class Utenlandsopphold(
    val land: Kodeverksentitet?,
    val startdato: String?,
    val sluttdato: String?,
    val rapporteringsmaaned: String?,
    val sporingsinformasjon: Sporingsinformasjon?,
)

class IdHistorikk(
    val id: String?,
    val bruksperiode: Bruksperiode?,
)

class Varsel(
    val entitet: VarselEntitet?,
    val varsling: Kodeverksentitet?,
)

class Rapporteringsmaaneder(
    val fra: String?,
    val til: String?,
)

class Bruksperiode(
    val fom: String?,
    val tom: String?,
)

class Opplysningspliktig(
    val type: OpplysningspliktigType?,
    val identer: List<Ident>?,
)

class Ident(
    val type: IdentType?,
    val ident: String?,
    val gjeldende: Boolean?,
)

class Kodeverksenitet(
    val kode: String? = null,
    val beskrivelse: String?,
)

class Sporingsinformasjon(
    val opprettetTidspunkt: String?,
    val opprettetAv: String?,
    val opprettetKilde: String?,
    val opprettetKildereferanse: String?,
    val endretTidspunkt: String?,
    val endretAv: String?,
    val endretKilde: String?,
    val endretKildereferanse: String?,
)

enum class ArbeidsstedType {
    Underenhet,
    Person,
}

enum class IdentType {
    AKTORID,
    FOLKEREGISTERIDENT,
    ORGANISASJONSNUMMER,
}

enum class AnsettelsesdetaljerType {
    Ordinaer,
    Maritim,
    Forenklet,
    Frilanser,
}

enum class OpplysningspliktigType {
    Hovedenhet,
    Person,
}

enum class VarselEntitet {
    Arbeidsforhold,
    Ansettelsesperiode,
    Permisjon,
    Permittering,
}
