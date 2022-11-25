package project.st991571169st991571540.gursikhpeter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import project.st991571169st991571540.gursikhpeter.databinding.TitleFragmentBinding


class TitleFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: TitleFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.title_fragment, container, false)

        binding.btnEx.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_titleFragment2_to_exerciseHome)
        }

        binding.btnFood.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_titleFragment2_to_dietJournal)
        }

        return binding.root
    }

}
