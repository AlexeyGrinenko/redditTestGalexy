package s.com.reddittestgalexy.domain.model

data class RedditsListResponse (
    var after: String,
    var redditsList: List<RedditData>
    )