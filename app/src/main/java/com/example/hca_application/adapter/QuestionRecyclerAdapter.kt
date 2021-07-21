package com.example.hca_application.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hca_application.databinding.ItemQuestionsBinding
import com.example.hca_application.response.QuestionResponse
import okhttp3.internal.immutableListOf
import java.util.*

class QuestionRecyclerAdapter(
    val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var questionList : MutableList<QuestionResponse> = ArrayList<QuestionResponse>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemQuestionsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuestionViewHolder(binding, binding.root)
    }

    fun updateItems(questionList: MutableList<QuestionResponse>){
        this.questionList.clear()
        this.questionList.addAll(questionList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return questionList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is QuestionViewHolder) {
            holder.bindData(questionList[position])
        }
    }

    class QuestionViewHolder(val binding: ItemQuestionsBinding, itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bindData(questionResponse: QuestionResponse) {
            binding.tvQuestionName.text = questionResponse.title
            binding.tvAnsCount.text="Answers: ${questionResponse.answerCount}"
            binding.tvViewCount.text="Views: ${questionResponse.viewCount}"
            binding.tvScoreCount.text="Score: ${questionResponse.score}"
        }
    }

}