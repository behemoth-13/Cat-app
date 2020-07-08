package by.afanasyeu.catapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import by.afanasyeu.catapp.R
import by.afanasyeu.catapp.adapter.cats.CatAdapter
import kotlinx.android.synthetic.main.fragment_page.*

class PageFragment : Fragment() {
    private val adapter = CatAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewCatList.adapter = adapter
        val catList = requireArguments().getLongArray(LIST_IDS)?.toList()
        adapter.submitList(catList)
    }

    fun updateCats(catList: List<Long>) {
        adapter.submitList(catList)
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