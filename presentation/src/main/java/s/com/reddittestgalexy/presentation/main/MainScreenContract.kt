package s.com.reddittestgalexy.presentation.main

import s.com.reddittestgalexy.presentation.IBasePresenter

interface MainScreenContract {

    interface View {
    }

    interface Presenter : IBasePresenter<View> {
        fun onShowsHomeClicked()
        fun onShowsClicked(showId: String)
    }
}