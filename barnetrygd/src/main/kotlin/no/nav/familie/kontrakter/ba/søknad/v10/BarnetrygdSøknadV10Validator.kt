package no.nav.familie.kontrakter.ba.søknad.v10

import no.nav.familie.kontrakter.ba.søknad.MAKS_LENGDE
import no.nav.familie.kontrakter.ba.søknad.UGYLDIGE_TEGN_REGEX
import no.nav.familie.kontrakter.ba.søknad.Valideringsfeil
import no.nav.familie.kontrakter.ba.søknad.v4.Locale
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadsfelt
import no.nav.familie.kontrakter.ba.søknad.v8.AndreForelder
import no.nav.familie.kontrakter.ba.søknad.v8.Omsorgsperson
import no.nav.familie.kontrakter.felles.søknad.Søknadsfelt as FellesSøknadsfelt

class BarnetrygdSøknadV10Validator {
    companion object {
        fun valider(søknad: BarnetrygdSøknad): List<Valideringsfeil> {
            val feil = mutableListOf<Valideringsfeil>()

            // Valider søker
            feil.addAll(validerSøker(søknad.søker))

            // Valider barn
            søknad.barn.forEachIndexed { index, barn ->
                feil.addAll(validerBarn(barn, index))
            }

            // Valider spørsmål på toppnivå
            søknad.spørsmål.forEach { (spørsmålId, søknadsfelt) ->
                feil.addAll(validerSøknadsfelt(søknadsfelt, "spørsmål.$spørsmålId"))
            }

            // Valider teksterUtenomSpørsmål
            søknad.teksterUtenomSpørsmål.forEach { (spørsmålId, localeMap) ->
                localeMap.forEach { (locale, tekst) ->
                    feil.addAll(validerString(tekst, "teksterUtenomSpørsmål.$spørsmålId", locale))
                }
            }

            return feil
        }

        private fun validerSøker(søker: Søker): List<Valideringsfeil> {
            val feil = mutableListOf<Valideringsfeil>()

            // Valider FellesSøknadsfelt-felter
            feil.addAll(validerFellesSøknadsfelt(søker.ident, "søker.ident"))
            feil.addAll(validerFellesSøknadsfelt(søker.navn, "søker.navn"))
            feil.addAll(validerFellesSøknadsfelt(søker.statsborgerskap, "søker.statsborgerskap"))
            feil.addAll(validerFellesSøknadsfelt(søker.adresse, "søker.adresse"))
            feil.addAll(validerFellesSøknadsfelt(søker.sivilstand, "søker.sivilstand"))

            // Valider spørsmål-map
            søker.spørsmål.forEach { (key, søknadsfelt) ->
                feil.addAll(validerFellesSøknadsfelt(søknadsfelt, "søker.spørsmål.$key"))
            }

            // Valider valgfri nåværendeSamboer
            søker.nåværendeSamboer?.let {
                feil.addAll(validerFellesSøknadsfelt(it, "søker.nåværendeSamboer"))
            }

            // Valider lister
            søker.svalbardOppholdPerioder.forEachIndexed { index, periode ->
                feil.addAll(validerFellesSøknadsfelt(periode, "søker.svalbardOppholdPerioder[$index]"))
            }

            søker.tidligereSamboere.forEachIndexed { index, samboer ->
                feil.addAll(validerFellesSøknadsfelt(samboer, "søker.tidligereSamboere[$index]"))
            }

            søker.utenlandsperioder.forEachIndexed { index, periode ->
                feil.addAll(validerFellesSøknadsfelt(periode, "søker.utenlandsperioder[$index]"))
            }

            søker.andreUtbetalingsperioder.forEachIndexed { index, periode ->
                feil.addAll(validerFellesSøknadsfelt(periode, "søker.andreUtbetalingsperioder[$index]"))
            }

            søker.arbeidsperioderUtland.forEachIndexed { index, periode ->
                feil.addAll(validerFellesSøknadsfelt(periode, "søker.arbeidsperioderUtland[$index]"))
            }

            søker.arbeidsperioderNorge.forEachIndexed { index, periode ->
                feil.addAll(validerFellesSøknadsfelt(periode, "søker.arbeidsperioderNorge[$index]"))
            }

            søker.pensjonsperioderNorge.forEachIndexed { index, periode ->
                feil.addAll(validerFellesSøknadsfelt(periode, "søker.pensjonsperioderNorge[$index]"))
            }

            søker.pensjonsperioderUtland.forEachIndexed { index, periode ->
                feil.addAll(validerFellesSøknadsfelt(periode, "søker.pensjonsperioderUtland[$index]"))
            }

            søker.idNummer.forEachIndexed { index, idNummer ->
                feil.addAll(validerFellesSøknadsfelt(idNummer, "søker.idNummer[$index]"))
            }

            return feil
        }

        private fun validerBarn(
            barn: Barn,
            barnIndex: Int,
        ): List<Valideringsfeil> {
            val feil = mutableListOf<Valideringsfeil>()
            val baseSti = "barn[$barnIndex]"

            // Valider FellesSøknadsfelt-felter
            feil.addAll(validerFellesSøknadsfelt(barn.ident, "$baseSti.ident"))
            feil.addAll(validerFellesSøknadsfelt(barn.navn, "$baseSti.navn"))
            feil.addAll(validerFellesSøknadsfelt(barn.registrertBostedType, "$baseSti.registrertBostedType"))
            barn.alder?.let {
                feil.addAll(validerFellesSøknadsfelt(it, "$baseSti.alder"))
            }

            // Valider spørsmål-map
            barn.spørsmål.forEach { (key, søknadsfelt) ->
                feil.addAll(validerFellesSøknadsfelt(søknadsfelt, "$baseSti.spørsmål.$key"))
            }

            // Valider lister
            barn.utenlandsperioder.forEachIndexed { index, periode ->
                feil.addAll(validerFellesSøknadsfelt(periode, "$baseSti.utenlandsperioder[$index]"))
            }

            barn.eøsBarnetrygdsperioder.forEachIndexed { index, periode ->
                feil.addAll(validerFellesSøknadsfelt(periode, "$baseSti.eøsBarnetrygdsperioder[$index]"))
            }

            barn.idNummer.forEachIndexed { index, idNummer ->
                feil.addAll(validerFellesSøknadsfelt(idNummer, "$baseSti.idNummer[$index]"))
            }

            barn.svalbardOppholdPerioder.forEachIndexed { index, periode ->
                feil.addAll(validerFellesSøknadsfelt(periode, "$baseSti.svalbardOppholdPerioder[$index]"))
            }

            // Valider andreForelder
            barn.andreForelder?.let {
                feil.addAll(validerAndreForelder(it, "$baseSti.andreForelder"))
            }

            // Valider omsorgsperson
            barn.omsorgsperson?.let {
                feil.addAll(validerOmsorgsperson(it, "$baseSti.omsorgsperson"))
            }

            return feil
        }

        private fun validerAndreForelder(
            andreForelder: AndreForelder,
            baseSti: String,
        ): List<Valideringsfeil> {
            val feil = mutableListOf<Valideringsfeil>()

            // Enkeltfelt
            feil.addAll(validerFellesSøknadsfelt(andreForelder.kanIkkeGiOpplysninger, "$baseSti.kanIkkeGiOpplysninger"))
            andreForelder.navn?.let { feil.addAll(validerFellesSøknadsfelt(it, "$baseSti.navn")) }
            andreForelder.fnr?.let { feil.addAll(validerFellesSøknadsfelt(it, "$baseSti.fnr")) }
            andreForelder.fødselsdato?.let { feil.addAll(validerFellesSøknadsfelt(it, "$baseSti.fødselsdato")) }
            andreForelder.arbeidUtlandet?.let { feil.addAll(validerFellesSøknadsfelt(it, "$baseSti.arbeidUtlandet")) }
            andreForelder.pensjonUtland?.let { feil.addAll(validerFellesSøknadsfelt(it, "$baseSti.pensjonUtland")) }
            andreForelder.skriftligAvtaleOmDeltBosted?.let { feil.addAll(validerFellesSøknadsfelt(it, "$baseSti.skriftligAvtaleOmDeltBosted")) }
            andreForelder.pensjonNorge?.let { feil.addAll(validerFellesSøknadsfelt(it, "$baseSti.pensjonNorge")) }
            andreForelder.arbeidNorge?.let { feil.addAll(validerFellesSøknadsfelt(it, "$baseSti.arbeidNorge")) }
            andreForelder.andreUtbetalinger?.let { feil.addAll(validerFellesSøknadsfelt(it, "$baseSti.andreUtbetalinger")) }
            andreForelder.adresse?.let { feil.addAll(validerFellesSøknadsfelt(it, "$baseSti.adresse")) }
            andreForelder.pågåendeSøknadFraAnnetEøsLand?.let { feil.addAll(validerFellesSøknadsfelt(it, "$baseSti.pågåendeSøknadFraAnnetEøsLand")) }
            andreForelder.pågåendeSøknadHvilketLand?.let { feil.addAll(validerFellesSøknadsfelt(it, "$baseSti.pågåendeSøknadHvilketLand")) }
            andreForelder.barnetrygdFraEøs?.let { feil.addAll(validerFellesSøknadsfelt(it, "$baseSti.barnetrygdFraEøs")) }

            // Lister
            andreForelder.idNummer.forEachIndexed { index, felt ->
                feil.addAll(validerFellesSøknadsfelt(felt, "$baseSti.idNummer[$index]"))
            }
            andreForelder.arbeidsperioderUtland.forEachIndexed { index, felt ->
                feil.addAll(validerFellesSøknadsfelt(felt, "$baseSti.arbeidsperioderUtland[$index]"))
            }
            andreForelder.pensjonsperioderUtland.forEachIndexed { index, felt ->
                feil.addAll(validerFellesSøknadsfelt(felt, "$baseSti.pensjonsperioderUtland[$index]"))
            }
            andreForelder.arbeidsperioderNorge.forEachIndexed { index, felt ->
                feil.addAll(validerFellesSøknadsfelt(felt, "$baseSti.arbeidsperioderNorge[$index]"))
            }
            andreForelder.pensjonsperioderNorge.forEachIndexed { index, felt ->
                feil.addAll(validerFellesSøknadsfelt(felt, "$baseSti.pensjonsperioderNorge[$index]"))
            }
            andreForelder.andreUtbetalingsperioder.forEachIndexed { index, felt ->
                feil.addAll(validerFellesSøknadsfelt(felt, "$baseSti.andreUtbetalingsperioder[$index]"))
            }
            andreForelder.eøsBarnetrygdsperioder.forEachIndexed { index, felt ->
                feil.addAll(validerFellesSøknadsfelt(felt, "$baseSti.eøsBarnetrygdsperioder[$index]"))
            }

            // Utvidet
            andreForelder.utvidet.søkerHarBoddMedAndreForelder?.let {
                feil.addAll(validerFellesSøknadsfelt(it, "$baseSti.utvidet.søkerHarBoddMedAndreForelder"))
            }
            andreForelder.utvidet.søkerFlyttetFraAndreForelderDato?.let {
                feil.addAll(validerFellesSøknadsfelt(it, "$baseSti.utvidet.søkerFlyttetFraAndreForelderDato"))
            }

            return feil
        }

        private fun validerOmsorgsperson(
            omsorgsperson: Omsorgsperson,
            baseSti: String,
        ): List<Valideringsfeil> {
            val feil = mutableListOf<Valideringsfeil>()

            // Enkeltfelt
            feil.addAll(validerFellesSøknadsfelt(omsorgsperson.navn, "$baseSti.navn"))
            feil.addAll(validerFellesSøknadsfelt(omsorgsperson.slektsforhold, "$baseSti.slektsforhold"))
            omsorgsperson.slektsforholdSpesifisering?.let { feil.addAll(validerFellesSøknadsfelt(it, "$baseSti.slektsforholdSpesifisering")) }
            feil.addAll(validerFellesSøknadsfelt(omsorgsperson.idNummer, "$baseSti.idNummer"))
            feil.addAll(validerFellesSøknadsfelt(omsorgsperson.adresse, "$baseSti.adresse"))
            feil.addAll(validerFellesSøknadsfelt(omsorgsperson.arbeidUtland, "$baseSti.arbeidUtland"))
            feil.addAll(validerFellesSøknadsfelt(omsorgsperson.arbeidNorge, "$baseSti.arbeidNorge"))
            feil.addAll(validerFellesSøknadsfelt(omsorgsperson.pensjonUtland, "$baseSti.pensjonUtland"))
            feil.addAll(validerFellesSøknadsfelt(omsorgsperson.pensjonNorge, "$baseSti.pensjonNorge"))
            feil.addAll(validerFellesSøknadsfelt(omsorgsperson.andreUtbetalinger, "$baseSti.andreUtbetalinger"))
            feil.addAll(validerFellesSøknadsfelt(omsorgsperson.pågåendeSøknadFraAnnetEøsLand, "$baseSti.pågåendeSøknadFraAnnetEøsLand"))
            omsorgsperson.pågåendeSøknadHvilketLand?.let { feil.addAll(validerFellesSøknadsfelt(it, "$baseSti.pågåendeSøknadHvilketLand")) }
            feil.addAll(validerFellesSøknadsfelt(omsorgsperson.barnetrygdFraEøs, "$baseSti.barnetrygdFraEøs"))

            // Lister
            omsorgsperson.arbeidsperioderUtland.forEachIndexed { index, felt ->
                feil.addAll(validerFellesSøknadsfelt(felt, "$baseSti.arbeidsperioderUtland[$index]"))
            }
            omsorgsperson.arbeidsperioderNorge.forEachIndexed { index, felt ->
                feil.addAll(validerFellesSøknadsfelt(felt, "$baseSti.arbeidsperioderNorge[$index]"))
            }
            omsorgsperson.pensjonsperioderUtland.forEachIndexed { index, felt ->
                feil.addAll(validerFellesSøknadsfelt(felt, "$baseSti.pensjonsperioderUtland[$index]"))
            }
            omsorgsperson.pensjonsperioderNorge.forEachIndexed { index, felt ->
                feil.addAll(validerFellesSøknadsfelt(felt, "$baseSti.pensjonsperioderNorge[$index]"))
            }
            omsorgsperson.andreUtbetalingsperioder.forEachIndexed { index, felt ->
                feil.addAll(validerFellesSøknadsfelt(felt, "$baseSti.andreUtbetalingsperioder[$index]"))
            }
            omsorgsperson.eøsBarnetrygdsperioder.forEachIndexed { index, felt ->
                feil.addAll(validerFellesSøknadsfelt(felt, "$baseSti.eøsBarnetrygdsperioder[$index]"))
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
            }

            return feil
        }

        private fun <T> validerFellesSøknadsfelt(
            søknadsfelt: FellesSøknadsfelt<T>,
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
