package no.nav.familie.kontrakter.ba.søknad

import no.nav.familie.kontrakter.ba.søknad.v10.BarnetrygdSøknadV10Validator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.reflect.KClass
import kotlin.test.assertNotNull

/**
 * Test som sikrer at alle støttede versjoner av BarnetrygdSøknad har en tilhørende validator.
 * Dette tester eksistensen av validator-klasser for alle versjoner som er definert i
 * StøttetVersjonertBarnetrygdSøknad.
 */
class BarnetrygdSøknadValidatorTest {
    @Test
    fun `alle støttede versjoner over 10 av BarnetrygdSøknad skal ha en egen validator klasse med funksjon som valider kontrakten`() {
        val klasserSomArverStøttetVersjonertBarnetrygdSøknad = StøttetVersjonertBarnetrygdSøknad::class.sealedSubclasses

        val versjonerSomSkalHaValidatorKlasse =
            klasserSomArverStøttetVersjonertBarnetrygdSøknad
                .mapNotNull {
                    it.simpleName?.substringAfterLast("V")?.toInt()
                }.filter { it >= 10 }
        versjonerSomSkalHaValidatorKlasse.forEach { println() }

        versjonerSomSkalHaValidatorKlasse.forEach { versjon ->
            assertDoesNotThrow("V$versjon validator skal eksistere") {
                val validatorClass = Class.forName("no.nav.familie.kontrakter.ba.søknad.v$versjon.BarnetrygdSøknadV${versjon}Validator")
                assertNotNull(validatorClass, "BarnetrygdSøknad versjon $versjon mangler en BarnetrygdSøknadV${versjon}Validator")

                val companionClass = validatorClass.getDeclaredField("Companion").type
                val validerMethod =
                    companionClass.getDeclaredMethod(
                        "valider",
                        Class.forName("no.nav.familie.kontrakter.ba.søknad.v$versjon.BarnetrygdSøknad"),
                    )

                assertNotNull(validerMethod, "BarnetrygdSøknadV${versjon}Validator mangler en companion metode med navn valider")
            }
        }
    }
}
