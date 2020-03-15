package s.com.reddittestgalexy.remote.utils

import s.com.reddittestgalexy.domain.model.RedditData
import s.com.reddittestgalexy.remote.model.RedditsListChildrenGson

fun convertRedditsGsonListToDomain(shows: List<RedditsListChildrenGson>) :
 List<RedditData> {
    return shows.map {
        RedditData(
            title = it.redditDataGson.title ?: "",
            author = it.redditDataGson.author ?: "",
            createdUtc = it.redditDataGson.createdUtc ?: System.currentTimeMillis(),
            thumbnail = it.redditDataGson.thumbnail,
            score = it.redditDataGson.score ?: 0,
            numComments = it.redditDataGson.numComments ?: 0,
            permalink = it.redditDataGson.permalink ?: "",
            id = it.redditDataGson.id ?: "",
            subreddit = it.redditDataGson.subreddit ?:""
        )
    }
}