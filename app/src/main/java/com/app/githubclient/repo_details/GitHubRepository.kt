package com.app.githubclient.repo_details

data class GitHubRepository(
    val id: Long,
    val name: String,
    val description: String?,
    // Add other properties as needed
)