package com.app.githubclient.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.githubclient.pojo.License
import com.app.githubclient.pojo.Owner

@Entity(tableName = "ItemEntity")
data class ItemEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val nodeId: String? = null,
    val name: String? = null,
    val fullName: String? = null,
    val owner: Owner? = null,
    val isPrivate: Boolean? = null,
    val htmlUrl: String? = null,
    val description: String? = null,
    val fork: Boolean? = null,
    val url: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val pushedAt: String? = null,
    val homepage: String? = null,
    val size: Long? = null,
    val stargazersCount: Long? = null,
    val watchersCount: Long? = null,
    val language: String? = null,
    val forksCount: Long? = null,
    val openIssuesCount: Long? = null,
    val masterBranch: String? = null,
    val defaultBranch: String? = null,
    val score: Long? = null,
    val archiveUrl: String? = null,
    val assigneesUrl: String? = null,
    val blobsUrl: String? = null,
    val branchesUrl: String? = null,
    val contributorsUrl: String? = null,
    val commentsUrl: String? = null,
    val commitsUrl: String? = null,
    val compareUrl: String? = null,
    val teamsUrl: String? = null,
    val treesUrl: String? = null,
    val cloneUrl: String? = null,
    val mirrorUrl: String? = null,
    val hooksUrl: String? = null,
    val svnUrl: String? = null,
    val forks: Long? = null,
    val openIssues: Long? = null,
    val watchers: Long? = null,
    val hasIssues: Boolean? = null,
    val hasProjects: Boolean? = null,
    val hasPages: Boolean? = null,
    val hasWiki: Boolean? = null,
    val hasDownloads: Boolean? = null,
    val archived: Boolean? = null,
    val disabled: Boolean? = null,
    val visibility: String? = null,
    val license: License? = null
)