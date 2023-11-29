package com.app.githubclient.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GitApiInstance {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val gitHubApiService: GitApiInterface = retrofit.create(GitApiInterface::class.java)

}