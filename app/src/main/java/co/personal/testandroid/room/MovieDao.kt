package co.personal.testandroid.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    fun findAll(): LiveData<MovieRoom?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: MovieRoom?): Long

    @Query("SELECT * FROM movie")
    fun getMovies(): List<MovieRoom>

    @Delete
    fun delete(movie: MovieRoom?): Int

}