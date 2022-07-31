package co.personal.testandroid.application

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MasterApp:DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}