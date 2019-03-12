package com.example.amandahinchman_dominguez.recyclerviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*

data class Movie(val title: String, val year: Int, val image: String)

class MainFragment : Fragment() {

    private val nicCageMovies = listOf(
        Movie("Raising Arizona", 1987, "raising_arizona.jpg"),
        Movie("Vampire's Kiss", 1988, "vampires_kiss.png"),
        Movie("Con Air", 1997, "con_air.jpg"),
        Movie("Face/Off", 1997, "face_off.jpg"),
        Movie("National Treasure", 2004, "national_treasure.jpg"),
        Movie("The Wicker Man", 2006, "wicker_man.jpg"),
        Movie("Bad Lieutenant", 2009, "bad_lieutenant.jpg"),
        Movie("Kick-Ass", 2010, "kickass.jpg")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_main, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListAdapter(nicCageMovies)
        }
    }

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }
}