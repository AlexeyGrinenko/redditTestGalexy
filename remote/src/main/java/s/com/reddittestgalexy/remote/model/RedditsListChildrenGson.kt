package s.com.reddittestgalexy.remote.model

import com.google.gson.annotations.SerializedName

data class RedditsListChildrenGson (
    @SerializedName("kind") val kind: String,
    @SerializedName("data") val redditDataGson: RedditDataGson
)