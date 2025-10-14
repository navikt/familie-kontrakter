package no.nav.familie.kontrakter.felles.arbeidsforhold

data class Arbeidsforhold(
    val id: String? = null,
    val type: Kodeverksentitet? = null,
    val arbeidstaker: Arbeidstaker? = null,
    val arbeidssted: Arbeidssted? = null,
    val ansettelsesperiode: Ansettelsesperiode? = null,
    val ansettelsesdetaljer: List<Ansettelsesdetaljer>? = null,
)

data class Kodeverksentitet(
    val kode: String? = null,
    val beskrivelse: String? = null,
)

data class Arbeidstaker(
    val identer: List<Ident>? = null,
)

data class Arbeidssted(
    val type: ArbeidsstedType? = null,
    val identer: List<Ident>? = null,
)

data class Ansettelsesperiode(
    val startdato: String? = null,
    val sluttdato: String? = null,
    val sluttaarsak: Kodeverksenitet? = null,
    val varsling: Kodeverksenitet? = null,
    val sporingsinformasjon: Sporingsinformasjon? = null,
)

data class Ansettelsesdetaljer(
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

data class Rapporteringsmaaneder(
    val fra: String? = null,
    val til: String? = null,
)

data class Ident(
    val type: IdentType? = null,
    val ident: String? = null,
    val gjeldende: Boolean? = null,
)

data class Kodeverksenitet(
    val kode: String? = null,
    val beskrivelse: String? = null,
)

data class Sporingsinformasjon(
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
