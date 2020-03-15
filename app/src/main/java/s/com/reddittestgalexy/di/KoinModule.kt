package s.com.reddittestgalexy.di

import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module.module
import s.com.reddittestgalexy.BaseActivity
import s.com.reddittestgalexy.data.repository.RedditsRepository
import s.com.reddittestgalexy.data.repository.source.main.IRedditsDataSource
import s.com.reddittestgalexy.domain.usecase.reddit.IRedditsRepository
import s.com.reddittestgalexy.domain.usecase.reddit.RedditsUseCase
import s.com.reddittestgalexy.navigation.MainScreenRouter
import s.com.reddittestgalexy.presentation.main.MainScreenContract
import s.com.reddittestgalexy.presentation.main.MainScreenPresenter
import s.com.reddittestgalexy.presentation.main.RedditsListContract
import s.com.reddittestgalexy.presentation.main.RedditsListPresenter
import s.com.reddittestgalexy.presentation.router.IMainScreenRouter
import s.com.reddittestgalexy.remote.ds.RedditsDataSource
import s.com.reddittestgalexy.remote.http.ReddiesService
import s.com.reddittestgalexy.remote.http.remoteDatasourceModule
import s.com.reddittestgalexy.ui.MainActivity

/**
 * Koin main module
 */
val KoinModule = module {

    single { AndroidSchedulers.mainThread() }

//Router
    scope<IMainScreenRouter>(KOIN_KEY_SCOPE_MAIN_ACTIVITY) { (activity: MainActivity) ->
        MainScreenRouter(
            activity
        )
    }

// Presenter

    scope<MainScreenContract.Presenter>(scopeId = KOIN_KEY_SCOPE_MAIN_ACTIVITY) { (activity: BaseActivity) ->
        MainScreenPresenter(
            get { parametersOf(activity) })
    }

    scope<RedditsListContract.Presenter>(scopeId = KOIN_KEY_SCOPE_REDDIT_LIST_FRAGMENT) { (activity: MainActivity) ->
        RedditsListPresenter(
            get(RedditsUseCase::class.java.name),
            get { parametersOf(activity) })
    }


//Use Case
    factory(name = RedditsUseCase::class.java.name) {
        RedditsUseCase(
            get(RedditsRepository::class.java.name),
            get()
        )
    }


//Repository
    factory<IRedditsRepository>(name = RedditsRepository::class.java.name) {
        RedditsRepository(
            get(
                RedditsDataSource::class.java.name
            )
        )
    }

//Data source
    factory<IRedditsDataSource>(name = RedditsDataSource::class.java.name) {
        RedditsDataSource(
            get(
                ReddiesService::class.java.simpleName
            )
        )
    }

}


/**
 * Module list
 */
val koinAppModules = listOf(KoinModule, remoteDatasourceModule)

enum class ScopeName {
    KOIN_KEY_SCOPE_MAIN_ACTIVITY(),
    KOIN_KEY_SCOPE_REDDIT_LIST_FRAGMENT()
}

val KOIN_KEY_SCOPE_MAIN_ACTIVITY = ScopeName.KOIN_KEY_SCOPE_MAIN_ACTIVITY.name

val KOIN_KEY_SCOPE_REDDIT_LIST_FRAGMENT = ScopeName.KOIN_KEY_SCOPE_REDDIT_LIST_FRAGMENT.name
