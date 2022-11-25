package project.st991571169st991571540.gursikhpeter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import project.st991571169st991571540.gursikhpeter.databinding.FragmentExerciseAddThreeBinding
import project.st991571169st991571540.gursikhpeter.databinding.FragmentExerciseAddTwoBinding

class exerciseAddThreeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: FragmentExerciseAddThreeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_exercise_add_three, container, false)

        binding.btnAdd.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_exerciseAddThreeFragment_to_exerciseThreeFragment)
        }

        return binding.root
    }
}