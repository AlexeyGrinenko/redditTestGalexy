package s.com.reddittestgalexy.data.repository.source.main

import io.reactivex.Single
import s.com.reddittestgalexy.domain.model.RedditsListResponse

interface IRedditsDataSource {
    fun loadReddits(after:String): Single<RedditsListResponse>

}