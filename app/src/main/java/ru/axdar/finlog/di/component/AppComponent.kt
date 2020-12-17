package ru.axdar.finlog.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.axdar.finlog.FinApp
import ru.axdar.finlog.di.module.*
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class, AppModule::class, NetworkModule::class,
        RepositoryModule::class, ViewModelModule::class, FragmentModule::class
    ]
)
interface AppComponent : AndroidInjector<FinApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: FinApp): AppComponent
    }
}