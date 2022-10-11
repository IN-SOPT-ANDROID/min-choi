package org.sopt.sample

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.home_container)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.home_container, HomeFragment.newInstance())
                .commit()
        }
    }
}