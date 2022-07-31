package co.personal.testandroid.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MovieRoom::class],version = MovieDatabase.VERSION,exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    companion object {
        private var INSTANCE: MovieDatabase? = null
        const val VERSION = 1

        fun getDatabase(context: Context): MovieDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MovieDatabase::class.java,
                        "movie_db"
                )
                        .allowMainThreadQueries()
                        .build()
            }
            return INSTANCE
        }
    }
    abstract fun getMovieDao(): MovieDao?
}