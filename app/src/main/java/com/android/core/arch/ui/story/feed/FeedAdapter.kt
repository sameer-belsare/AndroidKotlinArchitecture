package com.android.core.arch.ui.story.feed

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.android.core.arch.R
import com.android.core.arch.ui.base.BaseViewHolder
import com.android.core.arch.ui.story.feed.model.Feeds
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.feed_recycler_item_view.*

/**
 * FeedAdapter to render latest feed in recycler view to display feed.
 *
 * @author Rohit Anvekar
 * @see BaseViewHolder
 *
 * @since 2019-02-16
 */
class FeedAdapter
/**
 * Feed Adaptor constructor
 *
 * @param context
 */
(private val mContext: Context) : RecyclerView.Adapter<BaseViewHolder>() {

    private var mFeeds: Feeds? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val activityView = LayoutInflater.from(parent.context).inflate(R.layout.feed_recycler_item_view, parent, false)
        return FeedViewHolder(activityView, activityView)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.itemView.tag = position
        holder.onBind(position)
    }

    /*override fun getItemCount(): Int {
        return mFeeds!!.rows!!.size
    }*/
    override fun getItemCount() = mFeeds!!.rows!!.size

    fun addFeeds(feeds: Feeds?) {
        mFeeds = feeds
    }

    /**
     * FeedViewHolder class to hold bind view with adpater.
     */
    inner class FeedViewHolder(feedView: View, override val containerView: View?) : BaseViewHolder(feedView), View.OnClickListener, LayoutContainer {

        init {
            feedView.setOnClickListener(this)
        }

        override fun onBind(position: Int) {

            val row = mFeeds!!.rows!![position]
            if (TextUtils.isEmpty(row.title)) {
                titleTxtView!!.text = mContext.getString(R.string.no_title)
            } else {
                titleTxtView!!.text = row.title
            }

            if (TextUtils.isEmpty(row.description)) {
                descriptionTxtView!!.text = mContext.getString(R.string.content_not_found)
            } else {
                descriptionTxtView!!.text = row.description
            }

            Glide.with(mContext)
                    .load(row.imageHref)
                    .placeholder(R.drawable.ic_default_placeholder)
                    .error(R.drawable.ic_image_not_found)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT).skipMemoryCache(true)
                    .into(feedImgView!!)
        }

        override fun onClick(v: View) {
            Toast.makeText(mContext, mFeeds!!.rows!![adapterPosition].title, Toast.LENGTH_SHORT).show()
        }
    }
}
