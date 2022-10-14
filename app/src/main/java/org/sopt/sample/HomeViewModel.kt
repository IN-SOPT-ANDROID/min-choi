package org.sopt.sample

import androidx.lifecycle.ViewModel
import org.sopt.sample.data.Repo

class HomeViewModel: ViewModel() {
    val mokRepoList = listOf<Repo>(
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
    )

}