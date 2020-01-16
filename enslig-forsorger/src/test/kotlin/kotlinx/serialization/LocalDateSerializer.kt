package kotlinx.serialization

import kotlinx.serialization.internal.StringDescriptor
import java.time.LocalDate


@Serializer(forClass = LocalDate::class)
object LocalDateSerializer : KSerializer<LocalDate> {

    override val descriptor: SerialDescriptor =
            StringDescriptor.withName(LocalDate::class.java.name)

}

