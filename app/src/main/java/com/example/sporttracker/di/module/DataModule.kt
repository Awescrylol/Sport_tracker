package com.example.sporttracker.di.module

import com.example.sporttracker.data.datasource.LocationDataSource
import com.example.sporttracker.data.datasource.LocationDataSourceImpl
import com.example.sporttracker.data.repository.LocationRepositoryImpl
import com.example.sporttracker.domain.repository.LocationRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun bindLocationDataSource(dataSource: LocationDataSourceImpl): LocationDataSource

    @Binds
    fun bindLocationRepository(repository: LocationRepositoryImpl): LocationRepository
}