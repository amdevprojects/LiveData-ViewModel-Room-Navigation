package com.example.livedataroom.fragments


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.livedataroom.R
import com.example.livedataroom.db.Avengers
import com.example.livedataroom.viewmodels.AvengersViewModel
import kotlinx.android.synthetic.main.fragment_add_avenger.*


/**
 * A simple [Fragment] subclass.
 *
 */
class AddAvengerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_avenger, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val avengersViewModel = ViewModelProviders.of(this).get(AvengersViewModel::class.java)
        addBtn.setOnClickListener {
            val name = inputName.text.toString().trim()
            val desc = inputDesc.text.toString().trim()
            if (name.isNotEmpty() && desc.isNotEmpty()) {
                Thread(Runnable {
                    avengersViewModel.insertAvenger(Avengers(null, name, desc))
                    Handler(Looper.getMainLooper()).post {
                        Navigation.findNavController(it).popBackStack()
                    }
                }).start()
            }
        }
    }
}
