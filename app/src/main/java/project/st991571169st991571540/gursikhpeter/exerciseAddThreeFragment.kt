package project.st991571169st991571540.gursikhpeter

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_excercise_add_one.*
import project.st991571169st991571540.gursikhpeter.databinding.FragmentExerciseAddThreeBinding
import project.st991571169st991571540.gursikhpeter.databinding.FragmentExerciseAddTwoBinding
import java.text.SimpleDateFormat
import java.util.*

class ExerciseAddThreeFragment : Fragment() {

    var formate =  SimpleDateFormat("dd MMM, YYYY", Locale.CANADA)
    var timeFormat = SimpleDateFormat("hh:mm a", Locale.CANADA)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: FragmentExerciseAddThreeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_exercise_add_three, container, false)

        val application = requireNotNull(this.activity).application;

        val dataSource = ProjectDB.getInstance(application).ExerciseThreeDao()

        val viewModelFactory = ExcerciseThreeViewmodelFactory(dataSource,application);

        val exerciseThreeViewmodel = ViewModelProviders.of(this,viewModelFactory).get(ExerciseThreeViewmodel::class.java);

        binding.setLifecycleOwner(this)

        binding.exerciseThreeViewModel = exerciseThreeViewmodel;

        binding.btnAdd.setOnClickListener{ view : View ->

            var thedate = binding.btnDate.text.toString()
            var thetime = binding.txtTime.text.toString()
            var weight = binding.txtDistance.text.toString().toInt()

            var newExercise = ExerciseThreeEntity(0,thedate,thetime,weight)

            exerciseThreeViewmodel.addExerciseThree(newExercise)

            view.findNavController().navigate(R.id.action_exerciseAddThreeFragment_to_exerciseThreeFragment)
        }


        binding.btnDate.setOnClickListener {
            val now = Calendar.getInstance()
            val datePicker = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(Calendar.YEAR, year)
                selectedDate.set(Calendar.MONTH, month)
                selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val date = formate.format(selectedDate.time)

                btnDate.text = formate.format(selectedDate.time)
                Toast.makeText(requireContext(),"Date: " + date, Toast.LENGTH_LONG).show()
            },
                now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH))
            datePicker.show()
        }

        binding.txtTime.setOnClickListener {
            val now = Calendar.getInstance()

            val timePicker = TimePickerDialog(requireContext(), TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                val selectedTime = Calendar.getInstance()
                selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
                selectedTime.set(Calendar.MINUTE, minute)

                txtTime.text = timeFormat.format(selectedTime.time)

                Toast.makeText(requireContext(), "Time: " + timeFormat.format(selectedTime.time), Toast.LENGTH_SHORT).show()
            },
                now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), false)

            timePicker.show()
        }

        return binding.root
    }
}