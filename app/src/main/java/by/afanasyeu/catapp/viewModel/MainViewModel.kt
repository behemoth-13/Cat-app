package by.afanasyeu.catapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var lastId = 0L

    val catsList = MutableLiveData<MutableList<Long>>().apply {
        val list = mutableListOf<Long>().apply {
            for (i in 0L..140) add(i)
        }
        lastId = 140L
        value = list
    }

    fun addImage() {
        catsList.value?.let {
            val next = if (it.isNotEmpty()) {
                it.last() + 1
            } else {
                1
            }

            it.add(next)
            lastId = next
            catsList.value = it
        }
    }

    fun clear() {
        val from = lastId + 1
        lastId += 140
        val list = mutableListOf<Long>().apply {
            for (i in from..lastId) add(i)
        }
        catsList.value = list
    }
}