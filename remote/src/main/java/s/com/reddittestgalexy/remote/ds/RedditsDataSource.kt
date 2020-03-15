package s.com.reddittestgalexy.remote.ds

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import s.com.reddittestgalexy.data.repository.source.main.IRedditsDataSource
import s.com.reddittestgalexy.domain.model.RedditsListResponse
import s.com.reddittestgalexy.remote.http.ReddiesService
import s.com.reddittestgalexy.remote.utils.convertRedditsGsonListToDomain

class RedditsDataSource(private val reddiesService: ReddiesService) : IRedditsDataSource {
    override fun loadReddits(after:String): Single<RedditsListResponse> {
        return reddiesService.downloadReddits(after)
            .map {RedditsListResponse(it.data.after,
                convertRedditsGsonListToDomain(it.data.childrens))}
            .observeOn(AndroidSchedulers.mainThread())
    }
}