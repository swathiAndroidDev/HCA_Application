package com.example.hca_application.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hca_application.R
import com.example.hca_application.adapter.QuestionRecyclerAdapter
import com.example.hca_application.databinding.ActivityMainBinding
import com.example.hca_application.response.QuestionResponse
import okhttp3.internal.immutableListOf

class MainActivity : AppCompatActivity() {

    private lateinit var questionViewModel: QuestionViewModel
    private lateinit var questionRecyclerAdapter: QuestionRecyclerAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()

        questionViewModel = ViewModelProvider(this).get(QuestionViewModel::class.java)
        getQuestions()
    }

    private fun setUpRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.rvQuestions.layoutManager = layoutManager
        questionRecyclerAdapter = QuestionRecyclerAdapter(this)
        binding.rvQuestions.adapter = questionRecyclerAdapter
    }

    private fun getQuestions() {
        binding.progressbar.visibility = View.VISIBLE
        questionViewModel.getQuestions()
        questionViewModel.questionsLiveData?.observe(this, Observer { questionResponse ->
            binding.progressbar.visibility = View.GONE
            if (questionResponse.quotaRemaining > 0) {
                if (questionResponse.questionResponseItems.isNotEmpty()) {
                    questionRecyclerAdapter.updateItems(questionResponse.questionResponseItems)
                    showHideViews(false, "")
                } else {
                    showHideViews(true, getString(R.string.empty_questions))
                }
            }else{
                showHideViews(true, getString(R.string.quota_exceeded))
            }
        })
    }

    private fun showHideViews(isListEmpty : Boolean, message : String){
        binding.tvEmpty.visibility = if(isListEmpty)View.VISIBLE else View.GONE
        binding.rvQuestions.visibility = if(isListEmpty)View.GONE else View.VISIBLE
        binding.tvEmpty.text = message
    }
}