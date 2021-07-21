package com.example.hca_application.repository

import androidx.lifecycle.MutableLiveData
import com.example.hca_application.response.QuestionBaseResponse
import com.example.hca_application.rest.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object QuestionRepository {
    val questionsMutableLiveData = MutableLiveData<QuestionBaseResponse>()

    fun getQuestions(): MutableLiveData<QuestionBaseResponse> {

        val call = RetrofitClient.apiInterface.getQuestions()

        call.enqueue(object : Callback<QuestionBaseResponse> {
            override fun onFailure(call: Call<QuestionBaseResponse>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<QuestionBaseResponse>,
                response: Response<QuestionBaseResponse>
            ) {

                val data = response.body()

                questionsMutableLiveData.value = data
            }
        })

        return questionsMutableLiveData
    }
}