package by.afanasyeu.catapp.adapter.page

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import by.afanasyeu.catapp.fragment.PageFragment

private const val PAGE_SIZE = 70

class PageAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private var catIds: List<Long> = listOf()

    override fun getItemCount(): Int {
        return catIds.size.let {
            if (it % PAGE_SIZE == 0) {
                it / PAGE_SIZE
            } else {
                it / PAGE_SIZE + 1
            }
        }
    }

    override fun createFragment(position: Int): Fragment {
        val fromIndex = PAGE_SIZE * position
        val toIndexTheory = fromIndex + PAGE_SIZE
        val toIndex = if (toIndexTheory > catIds.size) {
            catIds.lastIndex
        } else {
            toIndexTheory
        }
        return PageFragment.newInstance(catIds.subList(fromIndex, toIndex).toLongArray())
    }

    fun submitList(newCatIds: List<Long>) {
        catIds = newCatIds
        notifyDataSetChanged()
    }
}