package project.st991571169st991571540.gursikhpeter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import project.st991571169st991571540.gursikhpeter.databinding.FragmentExcerciseOneBinding
import project.st991571169st991571540.gursikhpeter.databinding.FragmentExerciseTwoBinding

class ExerciseTwoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: FragmentExerciseTwoBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_exercise_two, container, false)

        binding.btnAdd.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_exerciseTwoFragment_to_exerciseAddTwoFragment3)
        }

        return binding.root
    }
}