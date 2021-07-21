package com.example.hca_application.response

import com.google.gson.annotations.SerializedName

data class QuestionBaseResponse(
    @SerializedName("items") val questionResponseItems: MutableList<QuestionResponse>,
    @SerializedName("has_mode") val hasMore: Boolean,
    @SerializedName("quota_max") val quotaMax: Int,
    @SerializedName("quota_remaining") val quotaRemaining: Int
)