package org.sopt.sample

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import org.sopt.sample.adapter.RepoAdapter
import org.sopt.sample.data.Repo
import org.sopt.sample.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = requireNotNull(_binding) { "바인딩 객체 생성 필요" }

    private val viewModel by viewModels<HomeViewModel>()
    private val mockRepoList = listOf<Repo>(
        Repo(
            image = R.drawable.github,
            name = "CatchMe",
            author = "Nunu-Lee"
        ),
        Repo(
            image = R.drawable.github,
            name = "FILL_IN",
            author = "Nunu-Lee"
        ),
        Repo(
            image = R.drawable.github,
            name = "Hacker",
            author = "Nunu-Lee"
        ),
        Repo(
            image = R.drawable.github,
            name = "BeMe",
            author = "Nunu-Lee"
        ),
        Repo(
            image = R.drawable.github,
            name = "CatchMe",
            author = "Nunu-Lee"
        ),
        Repo(
            image = R.drawable.github,
            name = "FILL_IN",
            author = "Nunu-Lee"
        ),
        Repo(
            image = R.drawable.github,
            name = "Hacker",
            author = "Nunu-Lee"
        ),
        Repo(
            image = R.drawable.github,
            name = "BeMe",
            author = "Nunu-Lee"
        )
    )




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RepoAdapter(requireContext())
        binding.rvRepos.adapter = adapter
        adapter.setRepoList(viewModel.mokRepoList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}