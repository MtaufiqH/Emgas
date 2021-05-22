package taufiq.apps.emgas

import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import android.widget.Toast
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
                    try {
                        val favoriteFragment =
                            Class.forName("taufiq.apps.emgas.favgame.FavoriteFragment")
                                .newInstance() as Fragment
                        moveFragment(favoriteFragment)
                    } catch (e: Exception) {
                        Toast.makeText(this, "Something wrong!", Toast.LENGTH_SHORT).show()
                    }
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