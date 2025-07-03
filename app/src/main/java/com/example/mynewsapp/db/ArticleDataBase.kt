package com.example.mynewsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mynewsapp.models.Article

@Database(
    entities = [Article::class],
    version = 1,
    exportSchema = false // Disable schema export to avoid the warning
)
@TypeConverters(Converters::class) // Reference the Converters class
abstract class ArticleDataBase : RoomDatabase() {
    abstract fun getArticleDao(): ArticleDAO // Fixed typo: use 'getArticleDao' to match DAO interface

    companion object {
        @Volatile
        private var instance: ArticleDataBase? = null
        private val Lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(Lock) {
            instance ?: createDataBase(context).also { instance = it }
        }

        private fun createDataBase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDataBase::class.java,
                name = "article_db.db"
            ).build()
    }
}