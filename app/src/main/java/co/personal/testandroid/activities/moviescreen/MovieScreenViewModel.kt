package co.personal.testandroid.activities.moviescreen

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import co.personal.testandroid.model.Movie
import co.personal.testandroid.repository.DataRepository
import javax.inject.Inject

class MovieScreenViewModel @Inject constructor(private val dataRepository: DataRepository, private val context: Context):
    ViewModel() {

    fun getListMovies(): LiveData<Movie> {
        return dataRepository.getListData()
    }
}