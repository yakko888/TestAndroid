package co.personal.testandroid.activities.moviescreen

import android.os.Bundle

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import co.personal.testandroid.R
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import co.personal.testandroid.adapter.ListMoviesAdapter

import co.personal.testandroid.room.MovieDatabase
import co.personal.testandroid.room.MovieRoom
import co.personal.testandroid.viewmodel.CustomViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MovieScreen : DaggerAppCompatActivity() {

    var rv_movies:RecyclerView ? = null
    var swipeLayout:SwipeRefreshLayout ? = null

    private lateinit var adapter: ListMoviesAdapter

    @Inject
    lateinit var viewCustomModelFactory: CustomViewModelFactory
    var dataViewModel: MovieScreenViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_screen)
        dataViewModel = ViewModelProviders.of(this,viewCustomModelFactory).get(MovieScreenViewModel::class.java)

        rv_movies = findViewById(R.id.rv_movies)
        swipeLayout = findViewById(R.id.swipe_layout)

        rv_movies?.layoutManager = LinearLayoutManager(this)

        val checkData = MovieDatabase.getDatabase(application)?.getMovieDao()?.getMovies()

        getMovies()
        btnListener()
    }

    private fun init(){
        adapter.clear()
        getMovies()
    }

    private fun getMovies(){
        swipeLayout?.isRefreshing = true

        dataViewModel!!.getListMovies().observe(this, Observer {

            for(item in it.results!!.indices){

                val movieRoom = MovieRoom(it.results[item].backdrop_path,
                        it.results[item].id, it.results[item].original_title,
                        it.results[item].overview, it.results[item].poster_path,
                        it.results[item].release_date, it.results[item].title)

                MovieDatabase.getDatabase(application)?.getMovieDao()?.insertMovie(movieRoom)
            }

            adapter = ListMoviesAdapter(this, it)
            rv_movies?.adapter = adapter
            swipeLayout?.isRefreshing = false
        })
    }
    private fun btnListener(){
        swipeLayout?.setOnRefreshListener {
            init()
        }
    }
}