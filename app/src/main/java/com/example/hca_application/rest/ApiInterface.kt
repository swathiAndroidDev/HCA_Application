package com.example.hca_application.rest

import com.example.hca_application.response.QuestionBaseResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/2.3/questions?order=desc&sort=activity&site=stackoverflow")
    fun getQuestions(): Call<QuestionBaseResponse>
}