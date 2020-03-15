package s.com.reddittestgalexy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import s.com.reddittestgalexy.R
import s.com.reddittestgalexy.domain.model.RedditData

class RedditsListAdapter(private val reddits: ArrayList<RedditData>, private val clickListener: (RedditData) -> Unit) : RecyclerView.Adapter<RedditsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RedditsViewHolder(LayoutInflater.from(parent.context)
                            .inflate(R.layout.item_reddit_in_list, parent, false))


    override fun onBindViewHolder(holder: RedditsViewHolder, position: Int) {
        holder.bind(reddits[position], clickListener)
    }

    override fun getItemCount() = reddits.size
}
