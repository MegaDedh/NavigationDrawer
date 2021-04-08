package ru.asshands.softwire.navigationdrawer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.asshands.softwire.navigationdrawer.databinding.FragmentOneBinding

class FragmentOne : Fragment(R.layout.fragment_one){

    private var _bind: FragmentOneBinding? = null
    private val bind get() = _bind!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _bind =  FragmentOneBinding.bind(view)

        bind.fragmentOneText.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_one_to_fragment_two)
        }
    }

    override fun onDestroyView() {
        _bind = null
        super.onDestroyView()
    }
}