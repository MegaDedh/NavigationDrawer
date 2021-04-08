package ru.asshands.softwire.navigationdrawer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.asshands.softwire.navigationdrawer.databinding.FragmentTwoBinding

class FragmentTwo : Fragment(R.layout.fragment_two){
    private var _bind: FragmentTwoBinding? = null
    private val bind get() = _bind!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _bind =  FragmentTwoBinding.bind(view)

        bind.fragmentText.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_two_to_fragment_three)
        }
    }

    override fun onDestroyView() {
        _bind = null
        super.onDestroyView()
    }
}