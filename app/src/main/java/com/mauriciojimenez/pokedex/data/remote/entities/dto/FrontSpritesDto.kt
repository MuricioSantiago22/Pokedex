package com.mauriciojimenez.pokedex.data.remote.entities.dto

import com.google.gson.annotations.SerializedName

data class FrontSpritesDto(
    @SerializedName("front_default")
    var frontSprites: String
)
