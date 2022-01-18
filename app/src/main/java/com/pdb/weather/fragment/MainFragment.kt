package com.pdb.weather.fragment

import android.os.Bundle
import android.view.*
import android.view.View.inflate
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.pdb.weather.R
import com.pdb.weather.adapter.ViewPagerFragmentStateAdapter
import com.pdb.weather.databinding.ActivityMainBinding.bind
import com.pdb.weather.databinding.ActivityMainBinding.inflate
import com.pdb.weather.databinding.HomeFragmentBinding

class MainFragment : Fragment() {

    lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ViewPagerFragmentStateAdapter(requireActivity())
        binding.viewPager.adapter = adapter
        val pageList = mutableListOf<String>()
        pageList.add("Page 1")
        pageList.add("Page 2")
        pageList.add("Page 3")
        pageList.add("Page 4")
        pageList.add("Page 5")
        adapter.setData(pageList)
        binding.viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })

        binding.toolbarHome.inflateMenu(R.menu.home_menu)
        binding.toolbarHome.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_settings -> {
                    // do something
                    true
                }
                R.id.action_city -> {
                    // do something
                    true
                }
                else -> {
                    super.onOptionsItemSelected(it)
                }
                }
            }
        }
//    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
//        R.id.action_settings -> {
//            // User chose the "Settings" item, show the app settings UI...
//            Toast.makeText(requireContext(), "Settings", Toast.LENGTH_SHORT).show()
//            true
//        }
//
//        else -> {
//            // If we got here, the user's action was not recognized.
//            // Invoke the superclass to handle it.
//            super.onOptionsItemSelected(item)
//        }
//    }
}

