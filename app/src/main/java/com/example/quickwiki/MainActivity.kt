package com.example.quickwiki

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewpager2.widget.ViewPager2
import com.example.quickwiki.adapters.ViewPagerAdapter
import com.example.quickwiki.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //set the navigation bar and onClickListener to set themes
        setSupportActionBar(toolbar)
        toggle = ActionBarDrawerToggle(this,
            drawerLayout,
            toolbar,
            R.string.nav_open,
            R.string.nav_close)
        toggle.isDrawerIndicatorEnabled = true
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigation_menu.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.switch_theme -> {
                    chooseThemeDialog()
                }
                R.id.offlineMode -> {

                }
            }
            true
        }

        //set the tab layout
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager_2)
        viewPager2.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Articles"
                }
                1 -> {
                    tab.text = "Images"
                }
                2 -> {
                    tab.text = "Category List"
                }
            }
        }.attach()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun chooseThemeDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.choose_theme_text))
        val styles = arrayOf("Light","Dark","System default")
        val checkedItem = 0
        builder.setSingleChoiceItems(styles, checkedItem) { dialog, which ->
            when (which) {
                0 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    delegate.applyDayNight()
                    dialog.dismiss()
                }
                1 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    delegate.applyDayNight()
                    dialog.dismiss()
                }
                2 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                    delegate.applyDayNight()
                    dialog.dismiss()
                }
            }
        }
        val dialog = builder.create()
        dialog.show()
    }
}


