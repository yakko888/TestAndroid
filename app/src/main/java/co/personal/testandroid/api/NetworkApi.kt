package co.personal.testandroid.api

import co.personal.testandroid.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface NetworkApi {
    @GET("movie/popular?api_key=09963e300150f9831c46a1828a82a984&language=en-US")
    fun getAllMovies(): Call<Movie>
}