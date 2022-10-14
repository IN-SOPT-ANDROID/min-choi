package org.sopt.sample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sample.HomeViewModel
import org.sopt.sample.data.Repo
import org.sopt.sample.databinding.ActivityHomeBinding.inflate
import org.sopt.sample.databinding.HeaderBinding
import org.sopt.sample.databinding.LayoutGithubRepoBinding

class RepoAdapter(context: Context) : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {
    private val TYPE_HEADER = 0
    private val TYPE_LIST = 1

    private val inflater by lazy { LayoutInflater.from(context) }
    private var repolist: List<Repo> = emptyList()

    class RepoViewHolder(
        private val binding: LayoutGithubRepoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Repo) {
            binding.imageGithubRepo.setImageDrawable(binding.root.context.getDrawable(data.image))
            binding.txtGithubRepoName.text = data.name
            binding.txtGithubRepoAuthor.text = data.author
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return when (viewType) {
            TYPE_HEADER -> {
                val binding = LayoutGithubRepoBinding.inflate(inflater, parent, false)
                RepoViewHolder(binding)
            }
            else -> {
                val binding = LayoutGithubRepoBinding.inflate(inflater, parent, false)
                RepoViewHolder(binding)
            }
        }

    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        if (holder is RepoViewHolder) {
            holder.onBind(repolist[position])
        }
        when (holder) {
            is RepoViewHolder -> {
            }
            else -> {}
        }
    }

    fun setRepoList(repoList: List<Repo>) {
        this.repolist = repoList.toList()
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_HEADER
        else TYPE_LIST
    }

    override fun getItemCount(): Int {
        return repolist.size + 1
    }

}
