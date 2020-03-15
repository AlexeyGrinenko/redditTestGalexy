package s.com.reddittestgalexy.remote.model

import com.google.gson.annotations.SerializedName

data class RedditsListHttpResponse (
    @SerializedName("data") val data: RedditsListDataGson,
    @SerializedName("kind") val kind: String
)