package s.com.reddittestgalexy.remote.model

import com.google.gson.annotations.SerializedName

data class RedditsListDataGson (
    @SerializedName("children") val childrens: List<RedditsListChildrenGson>,
    @SerializedName("modhash") val modhash: String,
    @SerializedName("dist") val dist: Int,
    @SerializedName("after") val after: String,
    @SerializedName("before") val before: String

)