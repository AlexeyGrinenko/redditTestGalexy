package s.com.reddittestgalexy.presentation

interface IBasePresenter<View> {
    fun attachView(view: View) {}
    fun detachView() {}
    fun onViewHidden() {}
}