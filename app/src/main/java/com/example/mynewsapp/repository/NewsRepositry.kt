package com.example.mynewsapp.repository


import com.example.mynewsapp.api.RetrofitInstance
import com.example.mynewsapp.db.ArticleDataBase
import com.example.mynewsapp.models.Article



class NewsRepositry(val db: ArticleDataBase) {

    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getTopHeadlines(countryCode,pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getFavouritesNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}


