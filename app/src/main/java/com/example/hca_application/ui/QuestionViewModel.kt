package com.example.hca_application.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hca_application.repository.QuestionRepository
import com.example.hca_application.response.QuestionBaseResponse

class QuestionViewModel : ViewModel() {
    var questionsLiveData: MutableLiveData<QuestionBaseResponse>? = null

    /**
     * method to fetch all the questions
     */
    fun getQuestions() : LiveData<QuestionBaseResponse>? {
        questionsLiveData = QuestionRepository.getQuestions()
        return questionsLiveData
    }
}