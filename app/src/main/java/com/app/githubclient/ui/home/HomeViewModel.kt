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

class HomeViewModel (
    private val repository: Repository
): ViewModel() {

    val searchRepositories: MutableLiveData<Resource<Root>> = MutableLiveData()
    private var pageNo = 1

    fun getRepositories(query: String) = viewModelScope.launch {
        searchRepositories.postValue(Resource.Loading())

        val response = repository.searchRepositories(query, pageNo)
        searchRepositories.postValue(handleResponse(response))
    }

    private fun handleResponse(response: Response<Root>) : Resource<Root> {
        if(response.isSuccessful){
            response.body()?.let { result ->

                for (item in result.items) {
                    println("Item ID: ${item.id}, Name: ${item.name}")
                    insert(item)
                }

                return Resource.Success(result)
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