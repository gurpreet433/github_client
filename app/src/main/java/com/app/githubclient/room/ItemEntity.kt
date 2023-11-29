package com.app.githubclient.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.githubclient.pojo.License
import com.app.githubclient.pojo.Owner
import com.fasterxml.jackson.annotation.JsonProperty

@Entity (
    tableName = "itemsTable"
)
data class ItemEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    @JsonProperty("node_id")
    val nodeId: String,
    val name: String,
    @JsonProperty("full_name")
    val fullName: String,
    val owner: Owner,
    val private: Boolean,
    @JsonProperty("html_url")
    val htmlUrl: String,
    val description: String,
    val fork: Boolean,
    val url: String,
    @JsonProperty("created_at")
    val createdAt: String,
    @JsonProperty("updated_at")
    val updatedAt: String,
    @JsonProperty("pushed_at")
    val pushedAt: String,
    val homepage: String,
    val size: Long,
    @JsonProperty("stargazers_count")
    val stargazersCount: Long,
    @JsonProperty("watchers_count")
    val watchersCount: Long,
    val language: String,
    @JsonProperty("forks_count")
    val forksCount: Long,
    @JsonProperty("open_issues_count")
    val openIssuesCount: Long,
    @JsonProperty("master_branch")
    val masterBranch: String,
    @JsonProperty("default_branch")
    val defaultBranch: String,
    val score: Long,
    @JsonProperty("archive_url")
    val archiveUrl: String,
    @JsonProperty("assignees_url")
    val assigneesUrl: String,
    @JsonProperty("blobs_url")
    val blobsUrl: String,
    @JsonProperty("branches_url")
    val branchesUrl: String,
    @JsonProperty("collaborators_url")
    val collaboratorsUrl: String,
    @JsonProperty("comments_url")
    val commentsUrl: String,
    @JsonProperty("commits_url")
    val commitsUrl: String,
    @JsonProperty("compare_url")
    val compareUrl: String,
    @JsonProperty("contents_url")
    val contentsUrl: String,
    @JsonProperty("contributors_url")
    val contributorsUrl: String,
    @JsonProperty("deployments_url")
    val deploymentsUrl: String,
    @JsonProperty("downloads_url")
    val downloadsUrl: String,
    @JsonProperty("events_url")
    val eventsUrl: String,
    @JsonProperty("forks_url")
    val forksUrl: String,
    @JsonProperty("git_commits_url")
    val gitCommitsUrl: String,
    @JsonProperty("git_refs_url")
    val gitRefsUrl: String,
    @JsonProperty("git_tags_url")
    val gitTagsUrl: String,
    @JsonProperty("git_url")
    val gitUrl: String,
    @JsonProperty("issue_comment_url")
    val issueCommentUrl: String,
    @JsonProperty("issue_events_url")
    val issueEventsUrl: String,
    @JsonProperty("issues_url")
    val issuesUrl: String,
    @JsonProperty("keys_url")
    val keysUrl: String,
    @JsonProperty("labels_url")
    val labelsUrl: String,
    @JsonProperty("languages_url")
    val languagesUrl: String,
    @JsonProperty("merges_url")
    val mergesUrl: String,
    @JsonProperty("milestones_url")
    val milestonesUrl: String,
    @JsonProperty("notifications_url")
    val notificationsUrl: String,
    @JsonProperty("pulls_url")
    val pullsUrl: String,
    @JsonProperty("releases_url")
    val releasesUrl: String,
    @JsonProperty("ssh_url")
    val sshUrl: String,
    @JsonProperty("stargazers_url")
    val stargazersUrl: String,
    @JsonProperty("statuses_url")
    val statusesUrl: String,
    @JsonProperty("subscribers_url")
    val subscribersUrl: String,
    @JsonProperty("subscription_url")
    val subscriptionUrl: String,
    @JsonProperty("tags_url")
    val tagsUrl: String,
    @JsonProperty("teams_url")
    val teamsUrl: String,
    @JsonProperty("trees_url")
    val treesUrl: String,
    @JsonProperty("clone_url")
    val cloneUrl: String,
    @JsonProperty("mirror_url")
    val mirrorUrl: String,
    @JsonProperty("hooks_url")
    val hooksUrl: String,
    @JsonProperty("svn_url")
    val svnUrl: String,
    val forks: Long,
    @JsonProperty("open_issues")
    val openIssues: Long,
    val watchers: Long,
    @JsonProperty("has_issues")
    val hasIssues: Boolean,
    @JsonProperty("has_projects")
    val hasProjects: Boolean,
    @JsonProperty("has_pages")
    val hasPages: Boolean,
    @JsonProperty("has_wiki")
    val hasWiki: Boolean,
    @JsonProperty("has_downloads")
    val hasDownloads: Boolean,
    val archived: Boolean,
    val disabled: Boolean,
    val visibility: String,
    val license: License,
)