package no.nav.familie.kontrakter.felles.tilbakekreving

import java.math.BigDecimal
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class Varsel(@field:NotBlank(message = "Mangler varseltekst")
                  val varseltekst: String,
                  @field:Min(value = 1, message = "sumFeilutbetaling må være større enn null")
                  val sumFeilutbetaling: BigDecimal,
                  @field:Size(min = 1, message = "Periode kan ikke være tom")
                  val perioder: List<Periode>)
