package no.nav.familie.kontrakter.felles.personopplysning.adresse

data class Adresse(val adresseType: AdresseType?,
                   val adresselinje1: String?,
                   val adresselinje2: String?,
                   val adresselinje3: String?,
                   val adresselinje4: String?,
                   val postnummer: String?,
                   val poststed: String?,
                   val land: String?)