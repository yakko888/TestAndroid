package co.personal.testandroid.application

import android.app.Application
import co.personal.testandroid.application.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        NetworkModule::class,
        ContextModule::class,
        ActivityBuildersModule::class]
)
interface AppComponent : AndroidInjector<MasterApp> {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}