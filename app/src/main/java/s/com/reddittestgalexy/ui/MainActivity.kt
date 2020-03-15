package s.com.reddittestgalexy.ui

import android.os.Bundle
import org.koin.android.ext.android.getKoin
import org.koin.core.parameter.parametersOf
import s.com.reddittestgalexy.BaseActivity
import s.com.reddittestgalexy.R
import s.com.reddittestgalexy.di.KOIN_KEY_SCOPE_MAIN_ACTIVITY
import s.com.reddittestgalexy.presentation.main.MainScreenContract
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.setProperty
import s.com.reddittestgalexy.presentation.KEY_ACTIVITY

class MainActivity : BaseActivity(), MainScreenContract.View {
    private val scopeKoin = getKoin().getOrCreateScope(KOIN_KEY_SCOPE_MAIN_ACTIVITY)

    private val presenter: MainScreenContract.Presenter by inject { parametersOf(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setProperty(KEY_ACTIVITY, this)
        presenter.attachView(this)
        presenter.onShowsHomeClicked()
    }

    override fun onDestroy() {
        presenter.detachView()
        presenter.onViewHidden()
        scopeKoin.close()
        super.onDestroy()
    }
}