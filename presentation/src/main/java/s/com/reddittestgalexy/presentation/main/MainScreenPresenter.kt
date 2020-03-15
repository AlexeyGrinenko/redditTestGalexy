package s.com.reddittestgalexy.presentation.main

import s.com.reddittestgalexy.presentation.router.IMainScreenRouter


class MainScreenPresenter(
    private val mainScreenRouter: IMainScreenRouter
) : MainScreenContract.Presenter {
    private var view: MainScreenContract.View? = null

    override fun attachView(view: MainScreenContract.View) {
        super.attachView(view)
        this@MainScreenPresenter.view = view
    }

    override fun onShowsHomeClicked() {
        mainScreenRouter.openRedditsListFragment()
    }

    override fun onShowsClicked(showId: String) {
//        mainScreenRouter.openShowsDetailFragment(showId)
    }


    override fun detachView() {
        view = null
    }

    override fun onViewHidden() {
    }


}