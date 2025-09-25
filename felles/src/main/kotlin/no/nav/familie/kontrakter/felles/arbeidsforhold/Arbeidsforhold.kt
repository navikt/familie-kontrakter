package no.nav.familie.kontrakter.felles.arbeidsforhold

class Arbeidsforhold(
    val id: String,
    val type: Kodeverksentitet? = null,
    val arbeidstaker: Arbeidstaker? = null,
    val arbeidssted: Arbeidssted? = null,
    val ansettelsesperiode: Ansettelsesperiode? = null,
    val ansettelsesdetaljer: List<Ansettelsesdetaljer>? = null,
)

class Kodeverksentitet(
    val kode: String? = null,
    val beskrivelse: String? = null,
)

class Arbeidstaker(
    val identer: List<Ident>? = null,
)

class Arbeidssted(
    val type: ArbeidsstedType? = null,
    val identer: List<Ident>? = null,
)

class Ansettelsesperiode(
    val startdato: String? = null,
    val sluttdato: String? = null,
    val sluttaarsak: Kodeverksenitet? = null,
    val varsling: Kodeverksenitet? = null,
    val sporingsinformasjon: Sporingsinformasjon? = null,
)

class Ansettelsesdetaljer(
    val arbeidstidsordning: Kodeverksentitet? = null,
    val ansettelsesform: Kodeverksentitet? = null,
    val yrke: Kodeverksentitet? = null,
    val antallTimerPrUke: Double? = null,
    val avtaltStillingsprosent: Double? = null,
    val rapporteringsmaaneder: Rapporteringsmaaneder? = null,
    val sporingsinformasjon: Sporingsinformasjon? = null,
    val type: AnsettelsesdetaljerType? = null,
    val sisteStillingsprosentendring: String? = null,
    val sisteLoennsendring: String? = null,
)

class Utenlandsopphold(
    val land: Kodeverksentitet? = null,
    val startdato: String? = null,
    val sluttdato: String? = null,
    val rapporteringsmaaned: String? = null,
    val sporingsinformasjon: Sporingsinformasjon? = null,
)

class Rapporteringsmaaneder(
    val fra: String? = null,
    val til: String? = null,
)

class Ident(
    val type: IdentType? = null,
    val ident: String? = null,
    val gjeldende: Boolean? = null,
)

class Kodeverksenitet(
    val kode: String? = null,
    val beskrivelse: String? = null,
)

class Sporingsinformasjon(
    val opprettetTidspunkt: String? = null,
    val opprettetAv: String? = null,
    val opprettetKilde: String? = null,
    val opprettetKildereferanse: String? = null,
    val endretTidspunkt: String? = null,
    val endretAv: String? = null,
    val endretKilde: String? = null,
    val endretKildereferanse: String? = null,
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
