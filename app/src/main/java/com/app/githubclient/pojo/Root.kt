package com.app.githubclient.pojo

import com.fasterxml.jackson.annotation.JsonProperty

data class Root(
    @JsonProperty("total_count")
    val totalCount: Long,
    @JsonProperty("incomplete_results")
    val incompleteResults: Boolean,
    val items: List<Item>,
)