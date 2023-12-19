package com.development.gocipes.core.di

import com.development.gocipes.core.data.local.datastore.UserPreferences
import com.development.gocipes.core.data.local.datastore.UserPreferencesImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PreferencesModule {

    @Binds
    @Singleton
    abstract fun provideUserPreferences(userPreferencesImpl: UserPreferencesImpl): UserPreferences
}