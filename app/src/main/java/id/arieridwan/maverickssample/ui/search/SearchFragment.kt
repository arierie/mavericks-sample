package id.arieridwan.maverickssample.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel

import id.arieridwan.maverickssample.R

class SearchFragment : BaseMvRxFragment() {

    private val viewModel: SearchViewModel by fragmentViewModel()

    override fun invalidate() {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

}