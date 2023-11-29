package com.app.githubclient.repository

import com.app.githubclient.network.GitApiInstance
import com.app.githubclient.room.ItemDatabase

class Repository(
    val db: ItemDatabase
) {
    suspend fun searchRepositories(query: String, pageNo: Int) =
        GitApiInstance.gitHubApiService.searchRepositories(query, pageNo = pageNo)

}