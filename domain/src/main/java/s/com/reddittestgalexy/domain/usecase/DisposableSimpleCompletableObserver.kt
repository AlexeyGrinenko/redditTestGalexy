package s.com.reddittestgalexy.domain.usecase

import io.reactivex.observers.DisposableCompletableObserver

open class DisposableSimpleCompletableObserver : DisposableCompletableObserver() {

    override fun onComplete() {
        // Empty
    }


    override fun onError(e: Throwable) {
        e.printStackTrace()
    }
}