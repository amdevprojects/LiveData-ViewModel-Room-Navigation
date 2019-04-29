package com.example.livedataroom.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.livedataroom.R
import com.example.livedataroom.adapters.AvengersRecyclerAdapter
import com.example.livedataroom.db.AppDb
import com.example.livedataroom.db.Avengers
import com.example.livedataroom.db.AvengersRepo
import com.example.livedataroom.viewmodels.AvengersViewModel
import kotlinx.android.synthetic.main.fragment_avengers_list.*

/**
 * A simple [Fragment] subclass.
 *
 */
class AvengersListFragment : Fragment() {

    private var adapter: AvengersRecyclerAdapter? = null

    private val avengers = mutableListOf<Avengers>()

    private lateinit var avengersViewModel: AvengersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_avengers_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        avengersViewModel = ViewModelProviders.of(this).get(AvengersViewModel::class.java)
        avengersViewModel.getAvengers()?.observe(this, Observer {
            avengers.clear()
            avengers.addAll(it)
            adapter?.notifyDataSetChanged()
        })

        setRecyclerView()

        populateTable()

        addBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_avengersListFragment_to_addAvengerFragment)
        }
    }

    private fun setRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.itemAnimator = DefaultItemAnimator()
        adapter = AvengersRecyclerAdapter(avengers)
        recyclerView.adapter = adapter
    }

    private fun populateTable() {
        Thread(Runnable {
            avengersViewModel.insertAvenger(Avengers(1, "Hulk", "The Hulk is a fictional superhero appearing in publications by the American publisher Marvel Comics. Created by writer Stan Lee and artist Jack Kirby, the character first appeared in the debut issue of The Incredible Hulk."))
            avengersViewModel.insertAvenger(Avengers(2, "Thor", "Thor is exiled by his father Odin, the King of Asgard, to the Earth to live among mortals. When he lands on Earth, his trusted weapon Mjolnir is discovered and captured by S.H.I.E.L.D."))
        }).start()
    }
}
