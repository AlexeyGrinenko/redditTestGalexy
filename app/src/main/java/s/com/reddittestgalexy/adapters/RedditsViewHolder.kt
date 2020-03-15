package s.com.reddittestgalexy.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_reddit_in_list.view.*
import s.com.reddittestgalexy.R
import s.com.reddittestgalexy.domain.model.RedditData
import s.com.reddittestgalexy.utils.getTimeDiffMessage
import s.com.reddittestgalexy.utils.gone
import s.com.reddittestgalexy.utils.visible

class RedditsViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView) {
    fun bind(redditData: RedditData, clickListener: (RedditData) -> Unit) {
        itemView.apply {
            tvTitleItemList?.text = redditData.title
            tvAuthorItemList?.text = "${context.getString(R.string.author)} ${redditData.author}"
            tvSubredditItemList?.text =
                "${context.getString(R.string.subreddit)} ${redditData.subreddit}"

            tvPostDateItemList?.text = getTimeDiffMessage(redditData.createdUtc, context)

            tvPopularityItemList?.text =
                "${context.getString(R.string.popularity)} ${redditData.score}"

            tvVotesItemList?.text =
                "${context.getString(R.string.number_of_comments)} ${redditData.numComments}"
            if (!redditData.thumbnail.isNullOrEmpty() && redditData.thumbnail!!.contains("http")) {
                ivImageItemList.visible()
                Glide.with(this)
                    .load(redditData.thumbnail)
                    .into(ivImageItemList)
            }else{
                ivImageItemList.gone()
            }

        }
        itemView.setOnClickListener { clickListener(redditData) }
    }
}