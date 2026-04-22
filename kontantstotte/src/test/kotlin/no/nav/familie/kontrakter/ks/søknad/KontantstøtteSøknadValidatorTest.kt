package no.nav.familie.kontrakter.ks.søknad

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.assertNotNull

/**
 * Test som sikrer at alle støttede versjoner av KontantstøtteSøknad har en tilhørende validator.
 * Dette tester eksistensen av validator-klasser for alle versjoner som er definert i
 * StøttetVersjonertKontantstøtteSøknad.
 */
class KontantstøtteSøknadValidatorTest {
    @Test
    fun `alle støttede versjoner over 6 av KontantstøtteSøknad skal ha en egen validator klasse med funksjon som valider kontrakten`() {
        val klasserSomArverStøttetVersjonertKontantstøtteSøknad = StøttetVersjonertKontantstøtteSøknad::class.sealedSubclasses

        val versjonerSomSkalHaValidatorKlasse =
            klasserSomArverStøttetVersjonertKontantstøtteSøknad
                .mapNotNull {
                    it.simpleName?.substringAfterLast("V")?.toInt()
                }.filter { it >= 6 }

        versjonerSomSkalHaValidatorKlasse.forEach { versjon ->
            assertDoesNotThrow("V$versjon validator skal eksistere") {
                val validatorClass = Class.forName("no.nav.familie.kontrakter.ks.søknad.v$versjon.KontantstøtteSøknadV${versjon}Validator")
                assertNotNull(validatorClass, "KontantstøtteSøknad versjon $versjon mangler en KontantstøtteSøknadV${versjon}Validator")

                val companionClass = validatorClass.getDeclaredField("Companion").type
                val validerMethod =
                    companionClass.getDeclaredMethod(
                        "valider",
                        Class.forName("no.nav.familie.kontrakter.ks.søknad.v$versjon.KontantstøtteSøknad"),
                    )

                assertNotNull(validerMethod, "KontantstøtteSøknadV${versjon}Validator mangler en companion metode med navn valider")
            }
        }
    }
}
