package co.personal.testandroid.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.personal.testandroid.activities.moviescreen.MovieScreenViewModel
import co.personal.testandroid.repository.DataRepository
import javax.inject.Inject

class CustomViewModelFactory @Inject constructor(private val dataRepository: DataRepository?, private val context: Context):
    ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(MovieScreenViewModel::class.java)){
            return MovieScreenViewModel(dataRepository!!,context) as T
        }else{
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}