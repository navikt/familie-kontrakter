package no.nav.familie.kontrakter.ba.søknad.v10

import no.nav.familie.kontrakter.ba.søknad.MAKS_LENGDE
import no.nav.familie.kontrakter.ba.søknad.UGYLDIGE_TEGN_REGEX
import no.nav.familie.kontrakter.ba.søknad.Valideringsfeil
import no.nav.familie.kontrakter.ba.søknad.v4.Locale
import no.nav.familie.kontrakter.ba.søknad.v4.Søknadsfelt
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

            // Valider verdi - sjekk kun String-verdier
            søknadsfelt.verdi.forEach { (locale, verdi) ->
                if (verdi is String && verdi.length > MAKS_LENGDE) {
                    feil.add(
                        Valideringsfeil(
                            objectPath = "$objectPath.verdi",
                            locale = locale,
                            feilmelding = "Verdi overskrider maksimal lengde på $MAKS_LENGDE tegn (faktisk: ${verdi.length})",
                        ),
                    )
                }

                if (verdi is String && UGYLDIGE_TEGN_REGEX.containsMatchIn(verdi)) {
                    feil.add(
                        Valideringsfeil(
                            objectPath = "$objectPath.verdi",
                            locale = locale,
                            feilmelding = "Verdi inneholder ugyldige tegn: $verdi",
                        ),
                    )
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

            // Valider verdi - sjekk kun String-verdier
            søknadsfelt.verdi.forEach { (locale, verdi) ->
                if (verdi is String && verdi.length > MAKS_LENGDE) {
                    feil.add(
                        Valideringsfeil(
                            objectPath = "$objectPath.verdi",
                            locale = locale,
                            feilmelding = "Verdi overskrider maksimal lengde på $MAKS_LENGDE tegn (faktisk: ${verdi.length})",
                        ),
                    )
                }

                if (verdi is String && UGYLDIGE_TEGN_REGEX.containsMatchIn(verdi)) {
                    feil.add(
                        Valideringsfeil(
                            objectPath = "$objectPath.verdi",
                            locale = locale,
                            feilmelding = "Verdi inneholder ugyldige tegn: $verdi",
                        ),
                    )
                }
            }

            return feil
        }
    }
}
