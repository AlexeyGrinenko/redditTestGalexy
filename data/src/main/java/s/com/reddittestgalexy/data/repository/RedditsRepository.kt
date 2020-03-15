package s.com.reddittestgalexy.data.repository

import io.reactivex.Single
import s.com.reddittestgalexy.data.repository.source.main.IRedditsDataSource
import s.com.reddittestgalexy.domain.model.RedditData
import s.com.reddittestgalexy.domain.usecase.reddit.IRedditsRepository

class RedditsRepository(val redditsDataSource: IRedditsDataSource) : IRedditsRepository {
    private var after =""
    override fun loadShows(isRefreshing: Boolean): Single<List<RedditData>> {
        if (isRefreshing) {
            after =""
        }
        return redditsDataSource.loadReddits(after)
            .map { after =it.after
            it.redditsList
            }
    }
}