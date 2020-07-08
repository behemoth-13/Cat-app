package by.afanasyeu.catapp.adapter.page

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import by.afanasyeu.catapp.fragment.PageFragment
import java.util.ArrayList


private const val PAGE_SIZE = 70

class PageAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private val fragmentsMap = mutableMapOf<Int, PageFragment>()
    private var catIds: List<Long> = listOf()
    private var pages = 0

    override fun getItemCount(): Int {
        return getPageCountByItemCount(catIds.size)
    }

    override fun createFragment(position: Int): Fragment {
        val catSubList = getCatListByPagePosition(position, catIds)
        val fragment = PageFragment.newInstance(catSubList.toLongArray())
        fragmentsMap[position] = fragment
        return fragment
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun containsItem(itemId: Long): Boolean {
        return itemId in 0..pages
    }


    fun submitList(newCatIds: List<Long>) {
        val updateTo = getPageCountByItemCount(newCatIds.size) - 1

        catIds = newCatIds

        notifyDataSetChanged()
        pages = getPageCountByItemCount(catIds.size)
        for (i in 0..updateTo) {
            fragmentsMap[i]?.updateCats(getCatListByPagePosition(i, newCatIds))
        }
    }

    private fun getPageCountByItemCount(itemCount: Int): Int {
        return if (itemCount % PAGE_SIZE == 0) {
            itemCount / PAGE_SIZE
        } else {
            itemCount / PAGE_SIZE + 1
        }
    }

    private fun getCatListByPagePosition(position: Int, catIds: List<Long>): List<Long> {
        val fromIndex = PAGE_SIZE * position
        val toIndexTheory = fromIndex + PAGE_SIZE
        val toIndex = if (toIndexTheory > catIds.size) {
            if (catIds.isNotEmpty()) {
                catIds.lastIndex
            } else {
                0
            }
        } else {
            toIndexTheory
        }
        return ArrayList(catIds.subList(fromIndex, toIndex))
    }
}