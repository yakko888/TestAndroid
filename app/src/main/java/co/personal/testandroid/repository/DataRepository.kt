package co.personal.testandroid.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.personal.testandroid.api.NetworkApi
import co.personal.testandroid.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class DataRepository @Inject constructor(val retrofit: Retrofit, val context: Context) {

    fun getListData(): LiveData<Movie> {

        val listData: MutableLiveData<Movie> = MutableLiveData()
        val call: Call<Movie> = retrofit.create(NetworkApi::class.java).getAllMovies()
        call.enqueue(object : Callback<Movie> {
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                listData.postValue(null)
            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {

                listData.value = response.body()
            }
        })
        return listData
    }
}