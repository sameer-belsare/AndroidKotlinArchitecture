package com.android.core.arch.ui.story.feed.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Feed Model Row
 *
 * @author Rohit Anvekar
 * @since 2019-02-16
 */
class Row {

    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("imageHref")
    @Expose
    var imageHref: Any? = null

    override fun toString(): String {
        return "Row{" +
                "title='" + title + '\''.toString() +
                ", description='" + description + '\''.toString() +
                ", imageHref=" + imageHref +
                '}'.toString()
    }
}
