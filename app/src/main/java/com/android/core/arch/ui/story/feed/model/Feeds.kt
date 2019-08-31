package com.android.core.arch.ui.story.feed.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Feeds Model
 *
 * @author Rohit Anvekar
 * @since 2019-02-16
 */
class Feeds {

    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("rows")
    @Expose
    var rows: List<Row>? = null


    override fun toString(): String {
        return "Feeds{" +
                "title='" + title + '\''.toString() +
                ", rows=" + rows +
                '}'.toString()
    }


}