package com.example.helloandroidstudio.di

import com.example.helloandroidstudio.data.repository.GithubRepositoryImpl
import com.example.helloandroidstudio.domain.repository.GithubRepository
import com.example.helloandroidstudio.domain.usecase.FindByNickNameUseCase
import com.example.helloandroidstudio.presentation.GithubViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Repository
    single<GithubRepository> { GithubRepositoryImpl() }

    // UseCase
    factory { FindByNickNameUseCase(get()) }

    // ViewModel
    viewModel { GithubViewModel(get()) }
}
