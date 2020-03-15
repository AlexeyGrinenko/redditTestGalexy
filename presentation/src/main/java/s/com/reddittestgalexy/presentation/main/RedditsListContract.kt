package s.com.reddittestgalexy.presentation.main

import s.com.reddittestgalexy.domain.model.RedditData
import s.com.reddittestgalexy.presentation.IBasePresenter


interface RedditsListContract {

    interface View {
        fun loadShowsList(redditsList: List<RedditData>, isFromRefresh:Boolean)
        fun showErrorMessage(message: String)
        fun showProgressDialog()
        fun hideProgressDialog()
    }

    interface Presenter : IBasePresenter<View> {
        fun refreshShowsList()
        fun loadReddits(isRefreshing: Boolean)
    }
}
