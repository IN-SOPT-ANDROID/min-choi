package org.sopt.sample

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import org.sopt.sample.databinding.ActivityHomeBinding
import org.xmlpull.v1.XmlPullParserFactory.newInstance

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayFragment()
    }

    private fun displayFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.home_container, HomeFragment())
            .commit()

        fun changeFragment(fragment: Fragment) {
            supportFragmentManager
                .beginTransaction()

        }
    }
}