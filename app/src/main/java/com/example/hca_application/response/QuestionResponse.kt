package com.example.hca_application.response

import com.google.gson.annotations.SerializedName

data class QuestionResponse(
    @SerializedName("is_answered") val isAnswered: Boolean,
    @SerializedName("view_count") val viewCount: Int,
    @SerializedName("answer_count") val answerCount: Int,
    @SerializedName("score") val score: Int,
    @SerializedName("question_id") val questionId: Long,
    @SerializedName("link") val link: String,
    @SerializedName("title") val title: String
)