package org.sopt.sample.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sample.data.Repo
import org.sopt.sample.databinding.LayoutGithubRepoBinding

class RepoViewHolder(
    private val binding: LayoutGithubRepoBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: Repo) {
        binding.imageGithubRepo.setImageDrawable(binding.root.context.getDrawable(data.image))
        binding.txtGithubRepoName.text = data.name
        binding.txtGithubRepoAuthor.text =data.author
    }

}
