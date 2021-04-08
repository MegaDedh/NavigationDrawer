package ru.asshands.softwire.navigationdrawer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.asshands.softwire.navigationdrawer.databinding.FragmentStartBinding

class FragmentStart  : Fragment(R.layout.fragment_start){

    private var _bind: FragmentStartBinding? = null
    private val bind get() = _bind!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _bind =  FragmentStartBinding.bind(view)

        bind.fragmentStartText.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_start_to_fragment_one)
        }
    }

    override fun onDestroyView() {
        _bind = null
        super.onDestroyView()
    }
}