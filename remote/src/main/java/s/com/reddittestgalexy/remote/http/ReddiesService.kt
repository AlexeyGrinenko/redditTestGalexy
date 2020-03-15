package s.com.reddittestgalexy.remote.http

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import s.com.reddittestgalexy.remote.model.RedditsListHttpResponse

interface ReddiesService {

    @GET("/top.json")
    fun downloadReddits(
        @Query("after") after: String
    ): Single<RedditsListHttpResponse>

}