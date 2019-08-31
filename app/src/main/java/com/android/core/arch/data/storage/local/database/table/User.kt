package com.android.core.arch.data.storage.local.database.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * User table
 *
 * @author Rohit Anvekar
 * @since 2019-02-14
 */
@Entity(tableName = "users")
class User {


    var id: Long = 0

    @PrimaryKey
    @ColumnInfo(name = "user_id")
    lateinit var userId: String

    @ColumnInfo(name = "name")
    lateinit var name: String

    @ColumnInfo(name = "first_name")
    lateinit var firstName: String

    @ColumnInfo(name = "last_name")
    lateinit var lastName: String

    @ColumnInfo(name = "email")
    lateinit var email: String

    @ColumnInfo(name = "created_at")
    lateinit var createdAt: String

    @ColumnInfo(name = "updated_at")
    lateinit var updatedAt: String

    @ColumnInfo(name = "profile_image_url")
    lateinit var profileImageUrl: String

    @ColumnInfo(name = "logged_mode")
    var loggedMode: Int = 0

    override fun toString(): String {
        return "UserApi{" +
                "id=" + id +
                ", userId='" + userId + '\''.toString() +
                ", name='" + name + '\''.toString() +
                ", firstName='" + firstName + '\''.toString() +
                ", lastName='" + lastName + '\''.toString() +
                ", email='" + email + '\''.toString() +
                ", createdAt='" + createdAt + '\''.toString() +
                ", updatedAt='" + updatedAt + '\''.toString() +
                ", profileImageUrl='" + profileImageUrl + '\''.toString() +
                ", loggedMode=" + loggedMode +
                '}'.toString()
    }
}
