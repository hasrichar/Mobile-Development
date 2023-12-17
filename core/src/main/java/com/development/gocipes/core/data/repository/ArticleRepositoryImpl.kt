package com.development.gocipes.core.data.repository

import com.development.gocipes.core.data.remote.RemoteDataSource
import com.development.gocipes.core.data.remote.response.article.ArtikelItem
import com.development.gocipes.core.data.remote.response.article.ArtikelResponse
import com.development.gocipes.core.domain.repository.ArticleRepository
import com.development.gocipes.core.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : ArticleRepository {
    override fun getAllArticle(): Flow<Result<List<ArtikelItem>>> = flow{
        emit(Result.Loading())
        try {
            val response = remoteDataSource.getAllArticle()
            val result = response.data
            emit(Result.Success(result))
        } catch (e: Exception) {
            emit(Result.Error(e.message))
        }
    }
}