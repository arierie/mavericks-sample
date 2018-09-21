package id.arieridwan.maverickssample.core

import android.os.Bundle
import android.os.Parcelable
import android.support.annotation.IdRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.MvRx

abstract class BaseFragment : BaseMvRxFragment() {

    protected val epoxyController by lazy { epoxyController() }

    abstract fun resLayout(): Int
    abstract fun epoxyController(): MvRxEpoxyController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(resLayout(), container, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        epoxyController.onRestoreInstanceState(savedInstanceState)
    }

    /**
     * Provide the EpoxyController to use when building models for this Fragment.
     * Basic usages can simply use [simpleController]
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        epoxyController.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        epoxyController.cancelPendingModelBuild()
        super.onDestroyView()
    }

    protected fun navigateTo(@IdRes actionId: Int, arg: Parcelable? = null) {
        /**
         * If we put a parcelable arg in [MvRx.KEY_ARG] then MvRx will attempt to call a secondary
         * constructor on any MvRxState objects and pass in this arg directly.
         * @see [com.airbnb.mvrx.sample.features.dadjoke.DadJokeDetailState]
         */
        val bundle = arg?.let { Bundle().apply { putParcelable(MvRx.KEY_ARG, it) } }
        findNavController().navigate(actionId, bundle)
    }

}