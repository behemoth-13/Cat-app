package by.afanasyeu.catapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import by.afanasyeu.catapp.R
import kotlinx.android.synthetic.main.fragment_page.*

class PageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val catList = requireArguments().getLongArray(LIST_IDS)?.toList()
        println("catlistSize = ${catList?.size}")
    }

    companion object {
        private const val LIST_IDS = "LIST_IDS"

        fun newInstance(ids: LongArray) =
            PageFragment().apply {
                arguments = bundleOf(
                    LIST_IDS to ids
                )
            }
    }
}