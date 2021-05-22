package taufiq.apps.core.utils

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

/**
 * Created By Taufiq on 4/26/2021.
 *
 */
abstract class BaseFragment : Fragment() {

    abstract fun initView(savedInstanceState: Bundle?)
    abstract fun observableInit()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(savedInstanceState)
        observableInit()
    }

}