package com.example.mynewsapp.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mynewsapp.repository.NewsRepositry

class NewsViewModelPRoviderFactory(val app : Application , val newsRepositry: NewsRepositry): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(app , newsRepositry) as T
    }
}