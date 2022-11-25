package project.st991571169st991571540.gursikhpeter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import project.st991571169st991571540.gursikhpeter.databinding.FragmentExcerciseOneBinding
import project.st991571169st991571540.gursikhpeter.databinding.FragmentExerciseAddTwoBinding

class ExerciseAddTwoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: FragmentExerciseAddTwoBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_exercise_add_two, container, false)

        binding.btnAdd.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_exerciseAddTwoFragment3_to_exerciseTwoFragment)
        }

        return binding.root
    }
}