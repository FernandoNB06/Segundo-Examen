package com.example.helloandroidstudio.di

import androidx.room.Room
import com.example.helloandroidstudio.data.local.AppDatabase
import com.example.helloandroidstudio.data.repository.DollarRateRepositoryImpl
import com.example.helloandroidstudio.data.repository.GithubRepositoryImpl
import com.example.helloandroidstudio.domain.repository.DollarRateRepository
import com.example.helloandroidstudio.domain.repository.GithubRepository
import com.example.helloandroidstudio.domain.usecase.FindByNickNameUseCase
import com.example.helloandroidstudio.presentation.DollarRateViewModel
import com.example.helloandroidstudio.presentation.GithubViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // ---------- GitHub ----------
    single<GithubRepository> { GithubRepositoryImpl() }
    factory { FindByNickNameUseCase(get()) }
    viewModel { GithubViewModel(get()) }

    // ---------- Room ----------
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "app.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<AppDatabase>().dollarRateDao() }

    // ---------- Dollar ----------
    single<DollarRateRepository> { DollarRateRepositoryImpl(get()) }
    viewModel { DollarRateViewModel(get()) }
}
