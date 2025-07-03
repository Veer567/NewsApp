package com.example.mynewsapp.db

import androidx.room.TypeConverter
import com.example.mynewsapp.models.Source
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromSource(source: Source?): String? {
        return source?.let { gson.toJson(it) }
    }

    @TypeConverter
    fun toSource(sourceString: String?): Source? {
        return if (sourceString == null) null else {
            val type = object : TypeToken<Source>() {}.type
            gson.fromJson(sourceString, type)
        }
    }
}