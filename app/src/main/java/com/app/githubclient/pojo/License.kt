package com.app.githubclient.pojo

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class License(
    val key: String?,
    val name: String?,
    val url: String?,
    @JsonProperty("spdx_id")
    val spdxId: String?,
    @JsonProperty("node_id")
    val nodeId: String?,
    @JsonProperty("html_url")
    val htmlUrl: String?
) : Serializable {

    companion object {
        private const val serialVersionUID: Long = 1
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val license = other as License

        if (key != license.key) return false
        if (name != license.name) return false
        if (url != license.url) return false
        if (spdxId != license.spdxId) return false
        if (nodeId != license.nodeId) return false
        if (htmlUrl != license.htmlUrl) return false

        return true
    }

    override fun hashCode(): Int {
        var result = key?.hashCode() ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (url?.hashCode() ?: 0)
        result = 31 * result + (spdxId?.hashCode() ?: 0)
        result = 31 * result + (nodeId?.hashCode() ?: 0)
        result = 31 * result + (htmlUrl?.hashCode() ?: 0)
        return result
    }
}