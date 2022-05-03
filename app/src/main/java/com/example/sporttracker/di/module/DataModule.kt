package com.example.sporttracker.di.module

import com.example.sporttracker.data.datasource.LocationDataSource
import com.example.sporttracker.data.datasource.LocationDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun bindLocationDataSource(dataSource: LocationDataSourceImpl): LocationDataSource
}