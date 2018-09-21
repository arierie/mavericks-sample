package id.arieridwan.maverickssample.ui.explore

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.arieridwan.maverickssample.R

/**
 * A simple [Fragment] subclass.
 *
 */
class ExploreFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }


}
