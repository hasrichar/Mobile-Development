package com.development.gocipes.core.domain.repository

import com.development.gocipes.core.data.remote.response.article.ArtikelItem
import com.development.gocipes.core.data.remote.response.article.ArtikelResponse
import com.development.gocipes.core.utils.Result
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {

    fun getAllArticle(): Flow<Result<List<ArtikelItem>>>
}