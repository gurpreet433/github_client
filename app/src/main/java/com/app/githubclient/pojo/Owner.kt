package com.app.githubclient.pojo

import java.io.Serializable

data class Owner(
    val login: String?,
    val id: Long?,
    val node_id: String?,
    val avatar_url: String?,
    val gravatar_id: String?,
    val url: String?,
    val received_events_url: String?,
    val type: String?,
    val html_url: String?,
    val followers_url: String?,
    val following_url: String?,
    val gists_url: String?,
    val starred_url: String?,
    val subscriptions_url: String?,
    val organizations_url: String?,
    val repos_url: String?,
    val events_url: String?,
    val site_admin: Boolean?
) : Serializable{

    override fun hashCode(): Int {
        var result = login?.hashCode() ?: 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (node_id?.hashCode() ?: 0)
        result = 31 * result + (avatar_url?.hashCode() ?: 0)
        result = 31 * result + (gravatar_id?.hashCode() ?: 0)
        result = 31 * result + (url?.hashCode() ?: 0)
        result = 31 * result + (received_events_url?.hashCode() ?: 0)
        result = 31 * result + (type?.hashCode() ?: 0)
        result = 31 * result + (html_url?.hashCode() ?: 0)
        result = 31 * result + (followers_url?.hashCode() ?: 0)
        result = 31 * result + (following_url?.hashCode() ?: 0)
        result = 31 * result + (gists_url?.hashCode() ?: 0)
        result = 31 * result + (starred_url?.hashCode() ?: 0)
        result = 31 * result + (subscriptions_url?.hashCode() ?: 0)
        result = 31 * result + (organizations_url?.hashCode() ?: 0)
        result = 31 * result + (repos_url?.hashCode() ?: 0)
        result = 31 * result + (events_url?.hashCode() ?: 0)
        result = 31 * result + site_admin.hashCode()
        return result
    }
}