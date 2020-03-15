package s.com.reddittestgalexy

import androidx.multidex.MultiDexApplication
import org.koin.android.ext.android.setProperty
import org.koin.android.ext.android.startKoin
import s.com.reddittestgalexy.di.koinAppModules
import s.com.reddittestgalexy.remote.utils.KEY_APPLICATION_CONTEXT

class RedditGalexyApplication : MultiDexApplication() {


    override fun onCreate() {
        super.onCreate()
        startKoin(this, koinAppModules)
        setProperty(KEY_APPLICATION_CONTEXT, applicationContext)

    }

}