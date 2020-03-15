package s.com.reddittestgalexy.domain.usecase.reddit

import io.reactivex.Single
import s.com.reddittestgalexy.domain.model.RedditData

interface IRedditsRepository {
    fun loadShows(isRefreshing: Boolean): Single<List<RedditData>>
}