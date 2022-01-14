package events

import org.axonframework.modelling.command.TargetAggregateIdentifier

abstract class BaseEvent<T>(
        @TargetAggregateIdentifier open val id: T
)

data class RadarCommandCreated(
        override val id :String,
        val vitessMax : Double,
        val longitud: Integer,
        val latitude: Integer
):BaseEvent<String>(id)

data class RadarCommandUpdated(
        override val id :String,
        val vitessMax : Double,
        val longitud: Integer,
        val latitude: Integer
):BaseEvent<String>(id)