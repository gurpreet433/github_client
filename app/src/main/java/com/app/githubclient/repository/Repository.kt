package com.app.githubclient.repository

import com.app.githubclient.network.GitApiInstance
import com.app.githubclient.pojo.Item
import com.app.githubclient.room.ItemDatabase
import com.app.githubclient.room.ItemEntity

class Repository(
    val db: ItemDatabase
) {
    suspend fun searchRepositories(query: String, pageNo: Int) =
        GitApiInstance.gitHubApiService.searchRepositories(query, pageNo = pageNo)

    suspend fun insert(itemEntity: ItemEntity) = db.getDao().insertItem(itemEntity)

    fun getItems() = db.getDao().getAllItems()

    suspend fun delete(itemEntity: ItemEntity) = db.getDao().deleteItem(itemEntity)

}