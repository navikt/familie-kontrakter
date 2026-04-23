package no.nav.familie.kontrakter.ks.søknad.v6

import no.nav.familie.kontrakter.felles.søknad.Søknadsfelt
import no.nav.familie.kontrakter.ks.søknad.MAKS_LENGDE
import no.nav.familie.kontrakter.ks.søknad.UGYLDIGE_TEGN_REGEX
import no.nav.familie.kontrakter.ks.søknad.Valideringsfeil
import no.nav.familie.kontrakter.ks.søknad.v1.Locale
import no.nav.familie.kontrakter.ks.søknad.v1.Søknaddokumentasjon
import no.nav.familie.kontrakter.ks.søknad.v2.Omsorgsperson
import no.nav.familie.kontrakter.ks.søknad.v4.AndreForelder
import no.nav.familie.kontrakter.ks.søknad.v4.Søker
import kotlin.reflect.full.memberProperties

class KontantstøtteSøknadV6Validator {
    companion object {
        fun valider(søknad: KontantstøtteSøknad): List<Valideringsfeil> {
            val feil = mutableListOf<Valideringsfeil>()

            // Valider søker
            feil.addAll(validerSøker(søknad.søker))

            // Valider barn
            søknad.barn.forEachIndexed { index, barn ->
                feil.addAll(validerBarn(barn, index))
            }

            // Valider toppnivå Søknadsfelt-felter
            feil.addAll(validerSøknadsfelt(søknad.erNoenAvBarnaFosterbarn, "erNoenAvBarnaFosterbarn"))
            feil.addAll(validerSøknadsfelt(søknad.søktAsylForBarn, "søktAsylForBarn"))
            feil.addAll(validerSøknadsfelt(søknad.oppholderBarnSegIInstitusjon, "oppholderBarnSegIInstitusjon"))
            feil.addAll(validerSøknadsfelt(søknad.barnOppholdtSegTolvMndSammenhengendeINorge, "barnOppholdtSegTolvMndSammenhengendeINorge"))
            feil.addAll(validerSøknadsfelt(søknad.erBarnAdoptert, "erBarnAdoptert"))
            feil.addAll(validerSøknadsfelt(søknad.mottarKontantstøtteForBarnFraAnnetEøsland, "mottarKontantstøtteForBarnFraAnnetEøsland"))
            feil.addAll(validerSøknadsfelt(søknad.harEllerTildeltBarnehageplass, "harEllerTildeltBarnehageplass"))
            søknad.erAvdødPartnerForelder?.let {
                feil.addAll(validerSøknadsfelt(it, "erAvdødPartnerForelder"))
            }

            // Valider teksterTilPdf
            søknad.teksterTilPdf.forEach { (key, tekstPåSpråkMap) ->
                tekstPåSpråkMap.forEach { (locale, tekst) ->
                    feil.addAll(validerString(tekst, "teksterTilPdf.$key", locale))
                }
            }

            // Valider dokumentasjon
            søknad.dokumentasjon.forEachIndexed { index, dok ->
                feil.addAll(validerDokumentasjon(dok, index))
            }

            return feil
        }

        private fun validerSøker(søker: Søker): List<Valideringsfeil> {
            val feil = mutableListOf<Valideringsfeil>()

            // Valider Søknadsfelt-felter
            feil.addAll(validerSøknadsfelt(søker.ident, "søker.ident"))
            feil.addAll(validerSøknadsfelt(søker.navn, "søker.navn"))
            feil.addAll(validerSøknadsfelt(søker.statsborgerskap, "søker.statsborgerskap"))
            feil.addAll(validerSøknadsfelt(søker.adresse, "søker.adresse"))
            feil.addAll(validerSøknadsfelt(søker.sivilstand, "søker.sivilstand"))

            // Enkeltfelter
            søker.borPåRegistrertAdresse?.let { feil.addAll(validerSøknadsfelt(it, "søker.borPåRegistrertAdresse")) }
            feil.addAll(validerSøknadsfelt(søker.værtINorgeITolvMåneder, "søker.værtINorgeITolvMåneder"))
            feil.addAll(validerSøknadsfelt(søker.planleggerÅBoINorgeTolvMnd, "søker.planleggerÅBoINorgeTolvMnd"))
            feil.addAll(validerSøknadsfelt(søker.yrkesaktivFemÅr, "søker.yrkesaktivFemÅr"))
            feil.addAll(validerSøknadsfelt(søker.erAsylsøker, "søker.erAsylsøker"))
            feil.addAll(validerSøknadsfelt(søker.utenlandsoppholdUtenArbeid, "søker.utenlandsoppholdUtenArbeid"))
            feil.addAll(validerSøknadsfelt(søker.arbeidIUtlandet, "søker.arbeidIUtlandet"))
            feil.addAll(validerSøknadsfelt(søker.mottarUtenlandspensjon, "søker.mottarUtenlandspensjon"))
            søker.arbeidINorge?.let { feil.addAll(validerSøknadsfelt(it, "søker.arbeidINorge")) }
            søker.pensjonNorge?.let { feil.addAll(validerSøknadsfelt(it, "søker.pensjonNorge")) }
            søker.andreUtbetalinger?.let { feil.addAll(validerSøknadsfelt(it, "søker.andreUtbetalinger")) }
            søker.adresseISøkeperiode?.let { feil.addAll(validerSøknadsfelt(it, "søker.adresseISøkeperiode")) }

            // Lister
            søker.utenlandsperioder.forEachIndexed { index, periode ->
                feil.addAll(validerSøknadsfelt(periode, "søker.utenlandsperioder[$index]"))
            }
            søker.arbeidsperioderUtland.forEachIndexed { index, periode ->
                feil.addAll(validerSøknadsfelt(periode, "søker.arbeidsperioderUtland[$index]"))
            }
            søker.pensjonsperioderUtland.forEachIndexed { index, periode ->
                feil.addAll(validerSøknadsfelt(periode, "søker.pensjonsperioderUtland[$index]"))
            }
            søker.arbeidsperioderNorge.forEachIndexed { index, periode ->
                feil.addAll(validerSøknadsfelt(periode, "søker.arbeidsperioderNorge[$index]"))
            }
            søker.pensjonsperioderNorge.forEachIndexed { index, periode ->
                feil.addAll(validerSøknadsfelt(periode, "søker.pensjonsperioderNorge[$index]"))
            }
            søker.andreUtbetalingsperioder.forEachIndexed { index, periode ->
                feil.addAll(validerSøknadsfelt(periode, "søker.andreUtbetalingsperioder[$index]"))
            }
            søker.idNummer.forEachIndexed { index, idNummer ->
                feil.addAll(validerSøknadsfelt(idNummer, "søker.idNummer[$index]"))
            }

            return feil
        }

        private fun validerBarn(
            barn: Barn,
            barnIndex: Int,
        ): List<Valideringsfeil> {
            val feil = mutableListOf<Valideringsfeil>()
            val baseSti = "barn[$barnIndex]"

            // Valider Søknadsfelt-felter
            feil.addAll(validerSøknadsfelt(barn.ident, "$baseSti.ident"))
            feil.addAll(validerSøknadsfelt(barn.navn, "$baseSti.navn"))
            feil.addAll(validerSøknadsfelt(barn.registrertBostedType, "$baseSti.registrertBostedType"))
            barn.alder?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.alder")) }

            // Om Barna
            feil.addAll(validerSøknadsfelt(barn.erFosterbarn, "$baseSti.erFosterbarn"))
            feil.addAll(validerSøknadsfelt(barn.oppholderSegIInstitusjon, "$baseSti.oppholderSegIInstitusjon"))
            feil.addAll(validerSøknadsfelt(barn.erAdoptert, "$baseSti.erAdoptert"))
            feil.addAll(validerSøknadsfelt(barn.erAsylsøker, "$baseSti.erAsylsøker"))
            feil.addAll(validerSøknadsfelt(barn.boddMindreEnn12MndINorge, "$baseSti.boddMindreEnn12MndINorge"))
            feil.addAll(validerSøknadsfelt(barn.kontantstøtteFraAnnetEøsland, "$baseSti.kontantstøtteFraAnnetEøsland"))
            feil.addAll(validerSøknadsfelt(barn.harBarnehageplass, "$baseSti.harBarnehageplass"))
            barn.andreForelderErDød?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.andreForelderErDød")) }

            // Om barnet - oppfølgningsspørsmål
            barn.utbetaltForeldrepengerEllerEngangsstønad?.let {
                feil.addAll(validerSøknadsfelt(it, "$baseSti.utbetaltForeldrepengerEllerEngangsstønad"))
            }
            barn.mottarEllerMottokEøsKontantstøtte?.let {
                feil.addAll(
                    validerSøknadsfelt(it, "$baseSti.mottarEllerMottokEøsKontantstøtte"),
                )
            }
            barn.pågåendeSøknadFraAnnetEøsLand?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.pågåendeSøknadFraAnnetEøsLand")) }
            barn.pågåendeSøknadHvilketLand?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.pågåendeSøknadHvilketLand")) }
            barn.planleggerÅBoINorge12Mnd?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.planleggerÅBoINorge12Mnd")) }

            // Perioder
            barn.eøsKontantstøttePerioder.forEachIndexed { index, periode ->
                feil.addAll(validerSøknadsfelt(periode, "$baseSti.eøsKontantstøttePerioder[$index]"))
            }
            barn.barnehageplassPerioder.forEachIndexed { index, periode ->
                feil.addAll(validerSøknadsfelt(periode, "$baseSti.barnehageplassPerioder[$index]"))
            }
            barn.utenlandsperioder.forEachIndexed { index, periode ->
                feil.addAll(validerSøknadsfelt(periode, "$baseSti.utenlandsperioder[$index]"))
            }
            barn.idNummer.forEachIndexed { index, idNummer ->
                feil.addAll(validerSøknadsfelt(idNummer, "$baseSti.idNummer[$index]"))
            }

            // Om barnet
            feil.addAll(validerSøknadsfelt(barn.borFastMedSøker, "$baseSti.borFastMedSøker"))
            barn.foreldreBorSammen?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.foreldreBorSammen")) }
            barn.søkerDeltKontantstøtte?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.søkerDeltKontantstøtte")) }

            // EØS
            barn.søkersSlektsforhold?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.søkersSlektsforhold")) }
            barn.søkersSlektsforholdSpesifisering?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.søkersSlektsforholdSpesifisering")) }
            barn.borMedAndreForelder?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.borMedAndreForelder")) }
            barn.borMedOmsorgsperson?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.borMedOmsorgsperson")) }
            barn.adresse?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.adresse")) }

            // Valider andreForelder
            barn.andreForelder?.let {
                feil.addAll(validerAndreForelder(it, "$baseSti.andreForelder"))
            }

            // Valider omsorgsperson
            barn.omsorgsperson?.let {
                feil.addAll(validerOmsorgsperson(it, "$baseSti.omsorgsperson"))
            }

            // Valider teksterTilPdf
            barn.teksterTilPdf.forEach { (key, tekstPåSpråkMap) ->
                tekstPåSpråkMap.forEach { (locale, tekst) ->
                    feil.addAll(validerString(tekst, "$baseSti.teksterTilPdf.$key", locale))
                }
            }

            return feil
        }

        private fun validerAndreForelder(
            andreForelder: AndreForelder,
            baseSti: String,
        ): List<Valideringsfeil> {
            val feil = mutableListOf<Valideringsfeil>()

            // Enkeltfelt
            feil.addAll(validerSøknadsfelt(andreForelder.kanIkkeGiOpplysninger, "$baseSti.kanIkkeGiOpplysninger"))
            andreForelder.navn?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.navn")) }
            andreForelder.fnr?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.fnr")) }
            andreForelder.fødselsdato?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.fødselsdato")) }
            andreForelder.yrkesaktivFemÅr?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.yrkesaktivFemÅr")) }
            andreForelder.arbeidUtlandet?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.arbeidUtlandet")) }
            andreForelder.utenlandsoppholdUtenArbeid?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.utenlandsoppholdUtenArbeid")) }
            andreForelder.pensjonUtland?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.pensjonUtland")) }
            andreForelder.arbeidNorge?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.arbeidNorge")) }
            andreForelder.pensjonNorge?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.pensjonNorge")) }
            andreForelder.andreUtbetalinger?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.andreUtbetalinger")) }
            andreForelder.adresse?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.adresse")) }
            andreForelder.pågåendeSøknadFraAnnetEøsLand?.let {
                feil.addAll(
                    validerSøknadsfelt(it, "$baseSti.pågåendeSøknadFraAnnetEøsLand"),
                )
            }
            andreForelder.pågåendeSøknadHvilketLand?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.pågåendeSøknadHvilketLand")) }
            andreForelder.kontantstøtteFraEøs?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.kontantstøtteFraEøs")) }

            // Lister
            andreForelder.arbeidsperioderUtland.forEachIndexed { index, felt ->
                feil.addAll(validerSøknadsfelt(felt, "$baseSti.arbeidsperioderUtland[$index]"))
            }
            andreForelder.pensjonsperioderUtland.forEachIndexed { index, felt ->
                feil.addAll(validerSøknadsfelt(felt, "$baseSti.pensjonsperioderUtland[$index]"))
            }
            andreForelder.arbeidsperioderNorge.forEachIndexed { index, felt ->
                feil.addAll(validerSøknadsfelt(felt, "$baseSti.arbeidsperioderNorge[$index]"))
            }
            andreForelder.pensjonsperioderNorge.forEachIndexed { index, felt ->
                feil.addAll(validerSøknadsfelt(felt, "$baseSti.pensjonsperioderNorge[$index]"))
            }
            andreForelder.andreUtbetalingsperioder.forEachIndexed { index, felt ->
                feil.addAll(validerSøknadsfelt(felt, "$baseSti.andreUtbetalingsperioder[$index]"))
            }
            andreForelder.eøsKontantstøttePerioder.forEachIndexed { index, felt ->
                feil.addAll(validerSøknadsfelt(felt, "$baseSti.eøsKontantstøttePerioder[$index]"))
            }
            andreForelder.utenlandsperioder.forEachIndexed { index, felt ->
                feil.addAll(validerSøknadsfelt(felt, "$baseSti.utenlandsperioder[$index]"))
            }
            andreForelder.idNummer.forEachIndexed { index, felt ->
                feil.addAll(validerSøknadsfelt(felt, "$baseSti.idNummer[$index]"))
            }

            return feil
        }

        private fun validerOmsorgsperson(
            omsorgsperson: Omsorgsperson,
            baseSti: String,
        ): List<Valideringsfeil> {
            val feil = mutableListOf<Valideringsfeil>()

            // Enkeltfelt
            feil.addAll(validerSøknadsfelt(omsorgsperson.navn, "$baseSti.navn"))
            omsorgsperson.slektsforhold?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.slektsforhold")) }
            omsorgsperson.slektsforholdSpesifisering?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.slektsforholdSpesifisering")) }
            feil.addAll(validerSøknadsfelt(omsorgsperson.idNummer, "$baseSti.idNummer"))
            feil.addAll(validerSøknadsfelt(omsorgsperson.adresse, "$baseSti.adresse"))
            feil.addAll(validerSøknadsfelt(omsorgsperson.arbeidUtland, "$baseSti.arbeidUtland"))
            feil.addAll(validerSøknadsfelt(omsorgsperson.arbeidNorge, "$baseSti.arbeidNorge"))
            feil.addAll(validerSøknadsfelt(omsorgsperson.pensjonUtland, "$baseSti.pensjonUtland"))
            feil.addAll(validerSøknadsfelt(omsorgsperson.pensjonNorge, "$baseSti.pensjonNorge"))
            feil.addAll(validerSøknadsfelt(omsorgsperson.andreUtbetalinger, "$baseSti.andreUtbetalinger"))
            feil.addAll(validerSøknadsfelt(omsorgsperson.pågåendeSøknadFraAnnetEøsLand, "$baseSti.pågåendeSøknadFraAnnetEøsLand"))
            omsorgsperson.pågåendeSøknadHvilketLand?.let { feil.addAll(validerSøknadsfelt(it, "$baseSti.pågåendeSøknadHvilketLand")) }
            feil.addAll(validerSøknadsfelt(omsorgsperson.kontantstøtteFraEøs, "$baseSti.kontantstøtteFraEøs"))

            // Lister
            omsorgsperson.arbeidsperioderUtland.forEachIndexed { index, felt ->
                feil.addAll(validerSøknadsfelt(felt, "$baseSti.arbeidsperioderUtland[$index]"))
            }
            omsorgsperson.arbeidsperioderNorge.forEachIndexed { index, felt ->
                feil.addAll(validerSøknadsfelt(felt, "$baseSti.arbeidsperioderNorge[$index]"))
            }
            omsorgsperson.pensjonsperioderUtland.forEachIndexed { index, felt ->
                feil.addAll(validerSøknadsfelt(felt, "$baseSti.pensjonsperioderUtland[$index]"))
            }
            omsorgsperson.pensjonsperioderNorge.forEachIndexed { index, felt ->
                feil.addAll(validerSøknadsfelt(felt, "$baseSti.pensjonsperioderNorge[$index]"))
            }
            omsorgsperson.andreUtbetalingsperioder.forEachIndexed { index, felt ->
                feil.addAll(validerSøknadsfelt(felt, "$baseSti.andreUtbetalingsperioder[$index]"))
            }
            omsorgsperson.eøsKontantstøttePerioder.forEachIndexed { index, felt ->
                feil.addAll(validerSøknadsfelt(felt, "$baseSti.eøsKontantstøttePerioder[$index]"))
            }

            return feil
        }

        private fun validerDokumentasjon(
            dok: Søknaddokumentasjon,
            index: Int,
        ): List<Valideringsfeil> {
            val feil = mutableListOf<Valideringsfeil>()
            val baseSti = "dokumentasjon[$index]"

            // Valider dokumentasjonSpråkTittel
            dok.dokumentasjonSpråkTittel.forEach { (locale, tittel) ->
                feil.addAll(validerString(tittel, "$baseSti.dokumentasjonSpråkTittel", locale))
            }

            // Valider vedlegg
            dok.opplastedeVedlegg.forEachIndexed { vedleggIndex, vedlegg ->
                val vedleggSti = "$baseSti.opplastedeVedlegg[$vedleggIndex]"
                feil.addAll(validerString(vedlegg.dokumentId, "$vedleggSti.dokumentId", ""))
                feil.addAll(validerString(vedlegg.navn, "$vedleggSti.navn", ""))
            }

            return feil
        }

        private fun validerString(
            verdi: String,
            objectPath: String,
            locale: Locale,
        ): List<Valideringsfeil> {
            val feil = mutableListOf<Valideringsfeil>()

            if (verdi.length > MAKS_LENGDE) {
                feil.add(
                    Valideringsfeil(
                        objectPath = objectPath,
                        locale = locale,
                        feilmelding = "Verdi overskrider maksimal lengde på $MAKS_LENGDE tegn (faktisk: ${verdi.length})",
                    ),
                )
            }

            if (UGYLDIGE_TEGN_REGEX.containsMatchIn(verdi)) {
                feil.add(
                    Valideringsfeil(
                        objectPath = objectPath,
                        locale = locale,
                        feilmelding = "Verdi inneholder ugyldige tegn: $verdi",
                    ),
                )
            }

            return feil
        }

        private fun validerVerdiRekursivt(
            verdi: Any?,
            objectPath: String,
            locale: Locale,
        ): List<Valideringsfeil> {
            if (verdi == null) return emptyList()

            val feil = mutableListOf<Valideringsfeil>()

            when (verdi) {
                is String -> {
                    feil.addAll(validerString(verdi, objectPath, locale))
                }

                is Søknadsfelt<*> -> {
                    feil.addAll(validerSøknadsfelt(verdi, objectPath))
                }

                is Map<*, *> -> {
                    verdi.forEach { (key, value) ->
                        feil.addAll(validerVerdiRekursivt(value, "$objectPath.$key", locale))
                    }
                }

                is Collection<*> -> {
                    verdi.forEachIndexed { index, element ->
                        feil.addAll(validerVerdiRekursivt(element, "$objectPath[$index]", locale))
                    }
                }

                else -> {
                    // Refleksjon: traverser feltene i ukjente objekter (f.eks. Arbeidsperiode, Pensjonsperiode, etc.)
                    verdi::class.memberProperties.forEach { prop ->
                        try {
                            val feltVerdi = prop.getter.call(verdi)
                            if (feltVerdi != null) {
                                feil.addAll(validerVerdiRekursivt(feltVerdi, "$objectPath.${prop.name}", locale))
                            }
                        } catch (_: Exception) {
                            // Ignorer felt som ikke kan leses
                        }
                    }
                }
            }

            return feil
        }

        private fun <T> validerSøknadsfelt(
            søknadsfelt: Søknadsfelt<T>,
            objectPath: String,
        ): List<Valideringsfeil> {
            val feil = mutableListOf<Valideringsfeil>()

            søknadsfelt.label.forEach { (locale, label) ->
                if (label.length > MAKS_LENGDE) {
                    feil.add(
                        Valideringsfeil(
                            objectPath = "$objectPath.label",
                            locale = locale,
                            feilmelding = "Label overskrider maksimal lengde på $MAKS_LENGDE tegn (faktisk: ${label.length})",
                        ),
                    )
                }

                if (UGYLDIGE_TEGN_REGEX.containsMatchIn(label)) {
                    feil.add(
                        Valideringsfeil(
                            objectPath = "$objectPath.label",
                            locale = locale,
                            feilmelding = "Label inneholder ugyldige tegn: $label",
                        ),
                    )
                }
            }

            // Valider verdi - traverser rekursivt for å finne alle String-verdier
            søknadsfelt.verdi.forEach { (locale, verdi) ->
                feil.addAll(validerVerdiRekursivt(verdi, "$objectPath.verdi", locale))
            }

            return feil
        }
    }
}
