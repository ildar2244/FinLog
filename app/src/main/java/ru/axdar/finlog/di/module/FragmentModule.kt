package ru.axdar.finlog.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.axdar.finlog.presentation.quotes.QuotesFragment

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun injectQuoteFragment(): QuotesFragment
}