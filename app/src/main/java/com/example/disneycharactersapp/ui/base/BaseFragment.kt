package com.example.disneycharactersapp.ui.base

import android.app.Activity
import androidx.fragment.app.Fragment
import com.example.disneycharactersapp.MainActivity

/**
 * Created by Barış Keser on 18.03.2023.
 */
open class BaseFragment : Fragment() {

    fun showProgress() {
        getParentActivity<MainActivity>()?.showProgress()
    }

    fun hideProgress() {
        getParentActivity<MainActivity>()?.hideProgress()
    }

}


inline fun <reified T: Activity> Fragment.getParentActivity() : T? {
    val parentFragment = this.parentFragment

    if (parentFragment != null && parentFragment is T) {
        return parentFragment
    } else {
        val activity = this.activity
        if (activity != null && activity is T) {
            return activity
        }
    }
    return null
}