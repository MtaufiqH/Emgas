package taufiq.apps.emgas

import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import taufiq.apps.emgas.databinding.ActivityMainBinding
import taufiq.apps.emgas.fragment.GameFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding<ActivityMainBinding>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        moveFragment(GameFragment())

        binding.bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    moveFragment(GameFragment())
                    true
                }

                R.id.menu_favorites -> {
                    val fragmentName = "taufiq.apps.emgas.favgame.FavoriteFragment"
                    val fragment = Class.forName(fragmentName)
                        .newInstance() as Fragment
                    moveFragment(fragment)
                    true
                }
                else -> moveFragment(GameFragment())
            }
        }

    }

    private fun moveFragment(fragment: Fragment): Boolean {
        return run {
            supportFragmentManager.commit {
                replace(R.id.container_fragment, fragment)
            }
            true
        }

    }
}