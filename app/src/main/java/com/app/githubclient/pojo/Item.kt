package com.app.githubclient.pojo

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class Item(
    val id: Long,
    @JsonProperty("node_id")
    val nodeId: String?,
    val name: String,
    @JsonProperty("full_name")
    val fullName: String?,
    val owner: Owner?,
    val private: Boolean?,
    @JsonProperty("html_url")
    val htmlUrl: String?,
    val description: String?,
    val fork: Boolean?,
    val url: String?,
    @JsonProperty("created_at")
    val createdAt: String?,
    @JsonProperty("updated_at")
    val updatedAt: String?,
    @JsonProperty("pushed_at")
    val pushedAt: String?,
    val homepage: String?,
    val size: Long?,
    @JsonProperty("stargazers_count")
    val stargazersCount: Long?,
    @JsonProperty("watchers_count")
    val watchersCount: Long?,
    val language: String?,
    @JsonProperty("forks_count")
    val forksCount: Long?,
    @JsonProperty("open_issues_count")
    val openIssuesCount: Long?,
    @JsonProperty("master_branch")
    val masterBranch: String?,
    @JsonProperty("default_branch")
    val defaultBranch: String?,
    val score: Long?,
    @JsonProperty("archive_url")
    val archiveUrl: String?,
    @JsonProperty("assignees_url")
    val assigneesUrl: String?,
    @JsonProperty("blobs_url")
    val blobsUrl: String?,
    @JsonProperty("branches_url")
    val branchesUrl: String?,
    @JsonProperty("collaborators_url")
    val collaboratorsUrl: String?,
    @JsonProperty("comments_url")
    val commentsUrl: String?,
    @JsonProperty("commits_url")
    val commitsUrl: String?,
    @JsonProperty("compare_url")
    val compareUrl: String?,
    // Add null checks for other properties...

    @JsonProperty("teams_url")
    val teamsUrl: String?,
    @JsonProperty("trees_url")
    val treesUrl: String?,
    @JsonProperty("clone_url")
    val cloneUrl: String?,
    @JsonProperty("mirror_url")
    val mirrorUrl: String?,
    @JsonProperty("hooks_url")
    val hooksUrl: String?,
    @JsonProperty("svn_url")
    val svnUrl: String?,
    val forks: Long?,
    @JsonProperty("open_issues")
    val openIssues: Long?,
    val watchers: Long?,
    @JsonProperty("has_issues")
    val hasIssues: Boolean?,
    @JsonProperty("has_projects")
    val hasProjects: Boolean?,
    @JsonProperty("has_pages")
    val hasPages: Boolean?,
    @JsonProperty("has_wiki")
    val hasWiki: Boolean?,
    @JsonProperty("has_downloads")
    val hasDownloads: Boolean?,
    val archived: Boolean?,
    val disabled: Boolean?,
    val visibility: String?,
    val license: License?
): Serializable {
    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (nodeId?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (fullName?.hashCode() ?: 0)
        result = 31 * result + (private?.hashCode() ?: 0)
        result = 31 * result + (htmlUrl?.hashCode() ?: 0)
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + (fork?.hashCode() ?: 0)
        result = 31 * result + (url?.hashCode() ?: 0)
        result = 31 * result + (createdAt?.hashCode() ?: 0)
        result = 31 * result + (updatedAt?.hashCode() ?: 0)
        result = 31 * result + (pushedAt?.hashCode() ?: 0)
        result = 31 * result + (homepage?.hashCode() ?: 0)
        result = 31 * result + (size?.hashCode() ?: 0)
        result = 31 * result + (stargazersCount?.hashCode() ?: 0)
        result = 31 * result + (watchersCount?.hashCode() ?: 0)
        result = 31 * result + (language?.hashCode() ?: 0)
        result = 31 * result + (forksCount?.hashCode() ?: 0)
        result = 31 * result + (openIssuesCount?.hashCode() ?: 0)
        result = 31 * result + (masterBranch?.hashCode() ?: 0)
        result = 31 * result + (defaultBranch?.hashCode() ?: 0)
        result = 31 * result + (score?.hashCode() ?: 0)
        result = 31 * result + (archiveUrl?.hashCode() ?: 0)
        result = 31 * result + (assigneesUrl?.hashCode() ?: 0)
        result = 31 * result + (blobsUrl?.hashCode() ?: 0)
        result = 31 * result + (branchesUrl?.hashCode() ?: 0)
        result = 31 * result + (collaboratorsUrl?.hashCode() ?: 0)
        result = 31 * result + (commentsUrl?.hashCode() ?: 0)
        result = 31 * result + (commitsUrl?.hashCode() ?: 0)
        result = 31 * result + (compareUrl?.hashCode() ?: 0)
        // Add null checks for other properties...

        return result
    }
}