package co.personal.testandroid.application.module

import co.personal.testandroid.activities.moviescreen.MovieScreen
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class,FragmentBuildersModule::class])
    abstract fun contributeMovieScreen(): MovieScreen

}