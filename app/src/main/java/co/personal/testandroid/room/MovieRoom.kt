package co.personal.testandroid.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieRoom(
        val backdrop_path :String,
        @PrimaryKey val id : Int,
        val original_title:String,
        val overview :String,
        val poster_path:String,
        val release_date :String,
        val title:String,
)