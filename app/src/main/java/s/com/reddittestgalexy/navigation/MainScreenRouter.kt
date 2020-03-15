package s.com.reddittestgalexy.navigation

import org.koin.standalone.KoinComponent
import s.com.reddittestgalexy.ui.MainActivity
import s.com.reddittestgalexy.R
import s.com.reddittestgalexy.presentation.router.IMainScreenRouter
import s.com.reddittestgalexy.ui.RedditsListFragment
import s.com.reddittestgalexy.utils.log

class MainScreenRouter(private val activityBase: MainActivity) : IMainScreenRouter, KoinComponent {

    override fun openRedditsListFragment() {
        log("openRedditListFragment")
        activityBase.supportFragmentManager
            .beginTransaction()
            .replace(R.id.framelayoutMain, RedditsListFragment())
            .commit()
    }

}