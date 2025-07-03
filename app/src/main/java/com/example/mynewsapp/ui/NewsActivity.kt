package com.example.mynewsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.mynewsapp.db.ArticleDataBase
import com.example.mynewsapp.repository.NewsRepositry
import com.example.newsprojectpractice.R
import com.example.newsprojectpractice.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {
    lateinit var newsViewModel: NewsViewModel
    lateinit var binding: ActivityNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsRepositry = NewsRepositry(ArticleDataBase(this))
        val viewModelProviderFactor = NewsViewModelPRoviderFactory(application, newsRepositry)
        newsViewModel = ViewModelProvider(this, viewModelProviderFactor).get(newsViewModel::class.java)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val  navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }

}