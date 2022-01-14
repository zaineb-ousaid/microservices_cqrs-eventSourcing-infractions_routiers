package commands

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.*


abstract class BaseCommand<T>(
        @TargetAggregateIdentifier open val id: T
)

data class CreateRadarCommand(
        override val id :String,
        val vitesse_maximale : Double,
        val Longitud: Integer,
        val latitude: Integer
):BaseCommand<String>(id)

data class UpdateRadarCommand(
        override val id :String,
        val vitesse_maximale : Double,
        val Longitud: Integer,
        val latitude: Integer
):BaseCommand<String>(id)