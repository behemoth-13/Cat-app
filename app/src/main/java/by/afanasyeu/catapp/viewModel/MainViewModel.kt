package by.afanasyeu.catapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val catsList = MutableLiveData<List<Long>>().apply {
        val list = mutableListOf<Long>().apply {
            for (i in 0L..150) add(i)
        }
        value = list
    }
}