package com.example.yassirtest.util

import com.example.yassirtest.data.movies.repositories.MoviesRepositoryImplementation
import com.example.yassirtest.data.movies.sources.KtorClientFactory
import com.example.yassirtest.data.movies.sources.MoviesDataSource
import com.example.yassirtest.domain.movies.repositories.MoviesRepository
import com.example.yassirtest.domain.movies.use_cases.GetMoviesUseCase
import com.example.yassirtest.ui.activities.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

object DependencyInjection {

    val networkModule = module {
        single { KtorClientFactory.create() }
        single { MoviesDataSource(get()) }
    }

    val repositoryModule = module {
        single<MoviesRepository> { MoviesRepositoryImplementation(get()) }
    }

    val useCaseModule = module {
        factory { GetMoviesUseCase(get()) }
    }

    val viewModelModule = module {
        viewModel { MainViewModel(get()) }
    }

    fun startKoinInjection() = startKoin {
        modules(
            networkModule,
            repositoryModule,
            useCaseModule,
            viewModelModule
        )
    }
}
