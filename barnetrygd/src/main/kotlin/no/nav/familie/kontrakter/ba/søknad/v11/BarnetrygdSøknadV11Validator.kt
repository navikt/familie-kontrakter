package no.nav.familie.kontrakter.ba.søknad.v11

import no.nav.familie.kontrakter.ba.søknad.Valideringsfeil
import no.nav.familie.kontrakter.ba.søknad.v10.BarnetrygdSøknadV10Validator
import no.nav.familie.kontrakter.ba.søknad.v10.DokumentasjonForValidering

class BarnetrygdSøknadV11Validator {
    companion object {
        fun valider(søknad: BarnetrygdSøknad): List<Valideringsfeil> =
            BarnetrygdSøknadV10Validator.valider(
                søker = søknad.søker,
                barn = søknad.barn,
                dokumentasjon =
                    søknad.dokumentasjon.map {
                        DokumentasjonForValidering(it.dokumentasjonSpråkTittel, it.opplastedeVedlegg)
                    },
                spørsmål = søknad.spørsmål,
                teksterUtenomSpørsmål = søknad.teksterUtenomSpørsmål,
            )
    }
}
