package com.android.core.arch.ui.base

import android.view.View

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

/**
 * Base class for all [ViewHolder] which help the data object
 * to get hold when recycler view
 * bind it self to them.
 *
 * @author Rohit Anvekar
 * @since 2019-02-14
 */
abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(position: Int)
}