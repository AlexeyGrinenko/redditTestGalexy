package s.com.reddittestgalexy.domain.exception

class RedditTestHttpException(override val message: String?, val httpStatus: Int) : RuntimeException(message)