package com.app.githubclient.pojo

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class Owner(
    val login: String?,
    val id: Long?,
    @JsonProperty("node_id")
    val nodeId: String?,
    @JsonProperty("avatar_url")
    val avatarUrl: String?,
    @JsonProperty("gravatar_id")
    val gravatarId: String?,
    val url: String?,
    @JsonProperty("received_events_url")
    val receivedEventsUrl: String?,
    val type: String?,
    @JsonProperty("html_url")
    val htmlUrl: String?,
    @JsonProperty("followers_url")
    val followersUrl: String?,
    @JsonProperty("following_url")
    val followingUrl: String?,
    @JsonProperty("gists_url")
    val gistsUrl: String?,
    @JsonProperty("starred_url")
    val starredUrl: String?,
    @JsonProperty("subscriptions_url")
    val subscriptionsUrl: String?,
    @JsonProperty("organizations_url")
    val organizationsUrl: String?,
    @JsonProperty("repos_url")
    val reposUrl: String?,
    @JsonProperty("events_url")
    val eventsUrl: String?,
    @JsonProperty("site_admin")
    val siteAdmin: Boolean?
) : Serializable{

    override fun hashCode(): Int {
        var result = login?.hashCode() ?: 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (nodeId?.hashCode() ?: 0)
        result = 31 * result + (avatarUrl?.hashCode() ?: 0)
        result = 31 * result + (gravatarId?.hashCode() ?: 0)
        result = 31 * result + (url?.hashCode() ?: 0)
        result = 31 * result + (receivedEventsUrl?.hashCode() ?: 0)
        result = 31 * result + (type?.hashCode() ?: 0)
        result = 31 * result + (htmlUrl?.hashCode() ?: 0)
        result = 31 * result + (followersUrl?.hashCode() ?: 0)
        result = 31 * result + (followingUrl?.hashCode() ?: 0)
        result = 31 * result + (gistsUrl?.hashCode() ?: 0)
        result = 31 * result + (starredUrl?.hashCode() ?: 0)
        result = 31 * result + (subscriptionsUrl?.hashCode() ?: 0)
        result = 31 * result + (organizationsUrl?.hashCode() ?: 0)
        result = 31 * result + (reposUrl?.hashCode() ?: 0)
        result = 31 * result + (eventsUrl?.hashCode() ?: 0)
        result = 31 * result + siteAdmin.hashCode()
        return result
    }
}