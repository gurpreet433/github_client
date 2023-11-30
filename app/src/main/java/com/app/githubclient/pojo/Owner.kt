package com.app.githubclient.pojo

import java.io.Serializable

data class Owner(
    val login: String? = null,
    val id: Long? = null,
    val node_id: String? = null,
    val avatar_url: String? = null,
    val gravatar_id: String? = null,
    val url: String? = null,
    val received_events_url: String? = null,
    val type: String? = null,
    val html_url: String? = null,
    val followers_url: String? = null,
    val following_url: String? = null,
    val gists_url: String? = null,
    val starred_url: String? = null,
    val subscriptions_url: String? = null,
    val organizations_url: String? = null,
    val repos_url: String? = null,
    val events_url: String? = null,
    val site_admin: Boolean? = null
) : Serializable {

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