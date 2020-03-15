package s.com.reddittestgalexy.remote.http

import com.google.gson.GsonBuilder
import s.com.reddittestgalexy.remote.model.ErrorResponse
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import s.com.reddittestgalexy.domain.exception.RedditTestHttpException
import java.io.IOException

class RemoteErrorInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)


        val rawJson = response.body()?.string()?.let { it ->

            val gson = GsonBuilder().setPrettyPrinting().create()
            val code = response.code()
            if (code !in 200..299) {
                var messageText = ""
                try {
                    val errorResponse = gson.fromJson(it, ErrorResponse::class.java)
                    if (errorResponse.message.isNullOrEmpty()) {
                        messageText = "Unknown error"
                    } else {
                        messageText = errorResponse.message
                    }
                } catch (exception: java.lang.Exception) {
                    messageText = it
                }
                throw RedditTestHttpException(message = messageText, httpStatus = code)
            }
            return response.newBuilder()
                .body(ResponseBody.create(response.body()?.contentType(), it))
                .build()
        }
        throw RedditTestHttpException(message = "Empty response body", httpStatus = 0)
    }
}
