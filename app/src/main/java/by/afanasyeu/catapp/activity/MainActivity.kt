package by.afanasyeu.catapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.afanasyeu.catapp.R
import by.afanasyeu.catapp.adapter.page.PageAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var adapter: PageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (adapter == null) {
            val catList = mutableListOf<Long>().apply {
                for (i in 0L..100) add(i)
            }
            adapter = PageAdapter(this, catList)
        }
        pagerCats.adapter = adapter

        TabLayoutMediator(tabLayoutIndicator, pagerCats)
        { _, _ ->}.attach()
    }
}