package com.app.githubclient.pojo

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class License(
    val key: String? =null,
    val name: String?=null,
    val url: String?=null,
    val spdx_id: String?=null,
    val node_id: String?=null,
    val html_url: String?=null
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
        if (spdx_id != license.spdx_id) return false
        if (node_id != license.node_id) return false
        if (html_url != license.html_url) return false

        return true
    }

    override fun hashCode(): Int {
        var result = key?.hashCode() ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (url?.hashCode() ?: 0)
        result = 31 * result + (spdx_id?.hashCode() ?: 0)
        result = 31 * result + (node_id?.hashCode() ?: 0)
        result = 31 * result + (html_url?.hashCode() ?: 0)
        return result
    }
}