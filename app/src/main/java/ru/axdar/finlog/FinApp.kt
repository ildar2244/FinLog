package ru.axdar.finlog

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.axdar.finlog.di.component.DaggerAppComponent

class FinApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}