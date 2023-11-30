package com.app.githubclient.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.githubclient.pojo.Item
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

fun List<ItemEntity>.toItemList(): List<Item> {
    return map { it.toItem() }
}

fun ItemEntity.toItem(): Item {
    return Item(
        id = this.id,
        node_id = this.nodeId,
        name = this.name ?: "",
        full_name = this.fullName,
        owner = this.owner,
        private = this.isPrivate,
        html_url = this.htmlUrl,
        description = this.description,
        fork = this.fork,
        url = this.url,
        created_at = this.createdAt,
        updated_at = this.updatedAt,
        pushed_at = this.pushedAt,
        homepage = this.homepage,
        size = this.size,
        stargazers_count = this.stargazersCount,
        watchers_count = this.watchersCount,
        language = this.language,
        forks_count = this.forksCount,
        open_issues_count = this.openIssuesCount,
        master_branch = this.masterBranch,
        default_branch = this.defaultBranch,
        score = this.score,
        archive_url = this.archiveUrl,
        assignees_url = this.assigneesUrl,
        blobs_url = this.blobsUrl,
        branches_url = this.branchesUrl,
        contributors_url = this.contributorsUrl,
        comments_url = this.commentsUrl,
        commits_url = this.commitsUrl,
        compare_url = this.compareUrl,
        teams_url = this.teamsUrl,
        trees_url = this.treesUrl,
        clone_url = this.cloneUrl,
        mirror_url = this.mirrorUrl,
        hooks_url = this.hooksUrl,
        svn_url = this.svnUrl,
        forks = this.forks,
        open_issues = this.openIssues,
        watchers = this.watchers,
        has_issues = this.hasIssues,
        has_projects = this.hasProjects,
        has_pages = this.hasPages,
        has_wiki = this.hasWiki,
        has_downloads = this.hasDownloads,
        archived = this.archived,
        disabled = this.disabled,
        visibility = this.visibility,
        license = this.license
    )
}