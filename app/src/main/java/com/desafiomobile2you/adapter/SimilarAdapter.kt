package com.desafiomobile2you.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.desafiomobile2you.databinding.CardItemViewBinding
import com.desafiomobile2you.model.Result


class SimilarAdapter(
    private val similarList: List<Result>,
    private val onClickListener: (movie: Result) -> Unit
) : RecyclerView.Adapter<SimilarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardItemViewBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(similarList[position], onClickListener)
    }

    override fun getItemCount() = similarList.size

    class ViewHolder(
        private val binding: CardItemViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            movie:Result,
            onClickListener: (movie: Result) -> Unit,
        ) {
            with(binding) {
                tvTitle.text = movie.title
            }
        }
    }
}