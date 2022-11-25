package project.st991571169st991571540.gursikhpeter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import project.st991571169st991571540.gursikhpeter.R
import project.st991571169st991571540.gursikhpeter.databinding.ExerciseHomeBinding

class ExerciseHome : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        val binding: ExerciseHomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.exercise_home, container, false)

        binding.btnEx1.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_exerciseHome_to_excerciseOneFragment)
        }

        binding.btnEx2.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_exerciseHome_to_exerciseTwoFragment)
        }

        binding.btnEx3.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_exerciseHome_to_exerciseThreeFragment)
        }
        return binding.root
    }
}