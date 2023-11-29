package com.app.githubclient.pojo

import com.fasterxml.jackson.annotation.JsonProperty

data class License(
    val key: String,
    val name: String,
    val url: String,
    @JsonProperty("spdx_id")
    val spdxId: String,
    @JsonProperty("node_id")
    val nodeId: String,
    @JsonProperty("html_url")
    val htmlUrl: String,
)