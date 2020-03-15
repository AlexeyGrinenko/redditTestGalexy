package s.com.reddittestgalexy.presentation.main

import s.com.reddittestgalexy.domain.model.RedditData
import s.com.reddittestgalexy.domain.usecase.DisposableSimpleSingleObserver
import s.com.reddittestgalexy.domain.usecase.reddit.RedditsUseCase
import s.com.reddittestgalexy.presentation.router.IMainScreenRouter


class RedditsListPresenter(private val showsUseCase: RedditsUseCase,
                           private val mainScreenRouter: IMainScreenRouter) :
    RedditsListContract.Presenter {

    private var view: RedditsListContract.View? = null

    override fun attachView(view: RedditsListContract.View) {
        this@RedditsListPresenter.view = view
    }

    override fun refreshShowsList() {
        loadReddits(true)
    }

    override fun loadReddits(isRefreshing: Boolean) {
        view?.showProgressDialog()
        showsUseCase.execute(object : DisposableSimpleSingleObserver<List<RedditData>>() {
            override fun onSuccess(reddits: List<RedditData>) {
                view?.hideProgressDialog()
                view?.loadShowsList(reddits,isRefreshing)
            }

            override fun onError(e: Throwable) {
                view?.hideProgressDialog()
                view?.showErrorMessage(e.localizedMessage)
            }
        }, RedditsUseCase.Params(isRefreshing))
    }

    override fun detachView() {
        view = null
        showsUseCase.dispose()
    }

    override fun onViewHidden() {
        showsUseCase.clear()
    }

}