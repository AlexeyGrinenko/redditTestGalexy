package s.com.reddittestgalexy.domain.usecase.reddit

import io.reactivex.Scheduler
import io.reactivex.Single
import s.com.reddittestgalexy.domain.model.RedditData
import s.com.reddittestgalexy.domain.usecase.AbsUseCaseSingle

class RedditsUseCase(
    private val redditsRepository: IRedditsRepository,
    postExecutionThread: Scheduler
) : AbsUseCaseSingle<List<RedditData>, RedditsUseCase.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params): Single<List<RedditData>> {
        return redditsRepository.loadShows(params.isRefreshing)
    }

    class Params(val isRefreshing: Boolean)
}