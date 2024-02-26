package com.mauriciojimenez.pokedex.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "pokemon_table")
data class PokemonDataEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id") var id : Int = 0 ,
    @ColumnInfo(name ="name")var name:String,
    @ColumnInfo(name="url")var url: String,
    @ColumnInfo(name= "image") var image : String
)
