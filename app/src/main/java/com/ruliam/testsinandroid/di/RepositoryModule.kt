package com.ruliam.testsinandroid.di

import com.ruliam.testsinandroid.repositories.AuthRepository
import com.ruliam.testsinandroid.repositories.AuthRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun providesAuthRepository() : AuthRepository = AuthRepositoryImpl()
}