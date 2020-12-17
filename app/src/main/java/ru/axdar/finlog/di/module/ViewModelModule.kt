package ru.axdar.finlog.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.axdar.finlog.di.utils.ViewModelFactory
import ru.axdar.finlog.di.utils.ViewModelKey
import ru.axdar.finlog.presentation.quotes.QuotesViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModuleFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(QuotesViewModel::class)
    abstract fun bindQuotesViewModel(vm: QuotesViewModel): ViewModel
}