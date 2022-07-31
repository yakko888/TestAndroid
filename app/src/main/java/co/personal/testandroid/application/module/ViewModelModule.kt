package co.personal.testandroid.application.module

import androidx.lifecycle.ViewModel
import co.personal.testandroid.activities.moviescreen.MovieScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieScreenViewModel::class)
    abstract fun bindListRetrofitViewModel(movieScreenViewModel: MovieScreenViewModel): ViewModel
}