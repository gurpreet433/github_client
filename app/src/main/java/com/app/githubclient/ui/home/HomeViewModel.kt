package com.app.githubclient.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Insert
import com.app.githubclient.pojo.Item
import com.app.githubclient.pojo.Root
import com.app.githubclient.pojo.toItemEntity
import com.app.githubclient.repository.Repository
import com.app.githubclient.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response
import com.app.githubclient.room.toItemList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val repository: Repository
) : ViewModel() {

    val searchRepositories: MutableLiveData<Resource<Root>> = MutableLiveData()
    var pageNo = 1
    var searchResponse: Root? =null

    fun getRepositories(query: String) = viewModelScope.launch {
        searchRepositories.postValue(Resource.Loading())

        val response = repository.searchRepositories(query, pageNo)
        searchRepositories.postValue(handleResponse(response))
    }

    init {
        loadFromDb()
    }

    private fun loadFromDb() = viewModelScope.launch {
        searchRepositories.postValue(Resource.Loading())

        try {
            val response = withContext(Dispatchers.IO) {
                repository.getItems()
            }

            searchRepositories.postValue(Resource.Success(
                Root(response.size.toLong(),
                    false,
                    response.toItemList().toMutableList()
                )))
        } catch (e: Exception) {
            searchRepositories.postValue(Resource.Error("Error loading data from database"))
        }
    }


    private fun handleResponse(response: Response<Root>): Resource<Root> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                pageNo++
                if(searchResponse == null) {
                    searchResponse = result
                }else {
                    var old = searchResponse?.items
                    var new = result.items

                    old?.addAll(new)
                }

                // add to database
                for (item in result.items) {
                    println("Item ID: ${item.id}, Name: ${item.name}")
                    insert(item)
                }
                return Resource.Success(searchResponse ?: result)
            }
        }
        return Resource.Error(response.message())
    }

    fun insert(item: Item) = viewModelScope.launch {
        repository.insert(item.toItemEntity())
    }

    fun getItem() = repository.getItems()

    fun deleteItem(item: Item) = viewModelScope.launch {
        repository.delete(item.toItemEntity())
    }
}