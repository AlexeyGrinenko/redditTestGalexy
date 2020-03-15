package s.com.reddittestgalexy.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.fragment_reddits_list.*
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import org.koin.core.scope.Scope
import s.com.reddittestgalexy.R
import s.com.reddittestgalexy.adapters.InfiniteScrollListener
import s.com.reddittestgalexy.adapters.RedditsListAdapter
import s.com.reddittestgalexy.di.KOIN_KEY_SCOPE_REDDIT_LIST_FRAGMENT
import s.com.reddittestgalexy.domain.model.RedditData
import s.com.reddittestgalexy.presentation.REDDITS_LIST_SCREEN
import s.com.reddittestgalexy.presentation.main.RedditsListContract
import s.com.reddittestgalexy.remote.utils.BASE_URL_HTTPS
import s.com.reddittestgalexy.utils.BaseFragment
import s.com.reddittestgalexy.utils.getBitmapFromVectorDrawable
import s.com.reddittestgalexy.utils.gone
import s.com.reddittestgalexy.utils.visible


class RedditsListFragment : BaseFragment(), RedditsListContract.View,
    SwipeRefreshLayout.OnRefreshListener {

    private lateinit var scopeKoin: Scope

    override val contextName = REDDITS_LIST_SCREEN

    private val presenter: RedditsListContract.Presenter by inject { parametersOf(this.activity as MainActivity) }
    private val shows: ArrayList<RedditData> = ArrayList()
    private lateinit var showsListAdapter: RedditsListAdapter
    private lateinit var customTabsIntent: CustomTabsIntent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reddits_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scopeKoin = getKoin().getOrCreateScope(KOIN_KEY_SCOPE_REDDIT_LIST_FRAGMENT)
        presenter.attachView(this)
        swipeReddits.setOnRefreshListener(this@RedditsListFragment)
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerReddits.layoutManager = linearLayoutManager
        showsListAdapter =
            RedditsListAdapter(shows) { redditData: RedditData -> onRedditClickListener(redditData) }
        recyclerReddits.adapter = showsListAdapter
        if (isNetworkAvailable()) presenter.loadReddits(true)
        recyclerReddits.clearOnScrollListeners()
        recyclerReddits.addOnScrollListener(
            InfiniteScrollListener({ presenter.loadReddits(false) }, linearLayoutManager)
        )
        context?.let {   recyclerReddits.addItemDecoration(
            DividerItemDecoration(
                it,
                DividerItemDecoration.VERTICAL
            )
        )}
        initCustomTabs()
    }

    override fun loadShowsList(redditsList: List<RedditData>, isFromRefresh: Boolean) {
        if (this@RedditsListFragment.isAdded) {
            if (isFromRefresh) shows.clear()
            shows.addAll(redditsList)
            showsListAdapter.notifyDataSetChanged()
            swipeReddits.isRefreshing = false
        }
    }

    override fun onRefresh() {
        presenter.refreshShowsList()
        swipeReddits.isRefreshing = false
    }

    override fun onDestroy() {
        presenter.detachView()
        scopeKoin.close()
        super.onDestroy()
    }

    override fun onDestroyView() {
        presenter.onViewHidden()
        hideProgressDialog()
        super.onDestroyView()
    }

    override fun showErrorMessage(message: String) {
        if (this@RedditsListFragment.isAdded) {
            context?.let { Toast.makeText(context, message, Toast.LENGTH_SHORT).show() }
        }
    }

    override fun showProgressDialog() {
        progressReddits.visible()
    }

    override fun hideProgressDialog() {
        progressReddits.gone()
    }

    private fun initCustomTabs() {
        context?.let {
            val customTabsIntentBuilder = CustomTabsIntent.Builder()
                .addDefaultShareMenuItem()
                .setToolbarColor(
                    this.resources
                        .getColor(R.color.colorPrimary)
                )
                .setShowTitle(true)

            getBitmapFromVectorDrawable(R.drawable.ic_arrow_back_white_24dp, it)?.let {
                customTabsIntentBuilder.setCloseButtonIcon(it)
            }
            customTabsIntent = customTabsIntentBuilder.build()
        }
    }

    private fun onRedditClickListener(redditData: RedditData) {
        context?.let {
            customTabsIntent.launchUrl(it, Uri.parse(BASE_URL_HTTPS + redditData.permalink))
        }
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
            true
        } else {
            context?.let { showErrorMessage(it.getString(R.string.toast_no_internet)) }
            false
        }
    }
}