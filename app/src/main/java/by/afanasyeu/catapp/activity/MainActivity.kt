package by.afanasyeu.catapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import by.afanasyeu.catapp.R
import by.afanasyeu.catapp.adapter.page.PageAdapter
import by.afanasyeu.catapp.viewModel.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var adapter: PageAdapter = PageAdapter(this)
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initViewModel()
        initClickListeners()
    }

    private fun initView() {
        pagerCats.adapter = adapter
        TabLayoutMediator(tabLayoutIndicator, pagerCats) { _, _ -> }.attach()
    }

    private fun initViewModel() {
        viewModel.catsList.observe(this, Observer {
            adapter.submitList(it)
        })
    }

    private fun initClickListeners() {
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_add -> {
                    Toast.makeText(this, "catch", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_reload -> {
                    Toast.makeText(this, "action_reload", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}