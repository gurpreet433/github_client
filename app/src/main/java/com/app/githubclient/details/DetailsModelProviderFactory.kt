package com.app.githubclient.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.githubclient.repository.Repository

class DetailsModelProviderFactory(
    val repository: Repository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailsViewModel(repository) as T
    }
}