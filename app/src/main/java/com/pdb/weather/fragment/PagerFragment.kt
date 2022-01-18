package com.pdb.weather.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.pdb.weather.R

class PagerFragment : Fragment(R.layout.fragment_view_pager) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            val titlePage = it.getString("title")
            val title = view.findViewById<TextView>(R.id.textView)
            title.text = titlePage
        }
    }
}