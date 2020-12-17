package ru.axdar.finlog.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.axdar.finlog.FinApp
import ru.axdar.finlog.presentation.DiffUtilItemCallbackFactory

@Module
class AppModule {

    @Provides
    fun provideContext(app: FinApp): Context = app.applicationContext

    @Provides
    fun provideDiffUtilItemCallbackFactory(): DiffUtilItemCallbackFactory {
        return DiffUtilItemCallbackFactory()
    }
}