package no.nav.familie.kontrakter.felles.annotasjoner

@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.EXPRESSION,
)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class Improvement(
    val message: String = "",
)
