package com.app.githubclient.network
import com.app.githubclient.pojo.Root
import com.app.githubclient.util.Constant.Companion.QUERY_PAGE_SIZE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GitApiInterface {
    @GET("search/repositories")
    @Headers(
        "Accept: application/vnd.github.v3+json",
        "X-GitHub-Api-Version: 2022-11-28"
    )
    suspend fun searchRepositories(
        @Query("q") query: String,
        @Query("per_page") perPage: Int = QUERY_PAGE_SIZE,
        @Query("page") pageNo: Int = 1
    ): Response<Root>
}