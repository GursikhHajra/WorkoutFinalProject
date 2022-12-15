package project.st991571169st991571540.gursikhpeter

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_excercise_add_one.*
import project.st991571169st991571540.gursikhpeter.databinding.FragmentExcerciseOneBinding
import project.st991571169st991571540.gursikhpeter.databinding.FragmentExerciseAddTwoBinding
import java.text.SimpleDateFormat
import java.util.*

class ExerciseAddTwoFragment : Fragment() {

    var formate = SimpleDateFormat("dd MMM, YYYY", Locale.CANADA)
    var timeFormat = SimpleDateFormat("hh:mm a", Locale.CANADA)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: FragmentExerciseAddTwoBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_exercise_add_two, container, false
        )

        val application = requireNotNull(this.activity).application;

        val dataSource = ProjectDB.getInstance(application).ExerciseTwoDao()

        val viewModelFactory = ExcerciseTwoViewmodelFactory(dataSource, application);

        val exerciseTwoViewmodel =
            ViewModelProviders.of(this, viewModelFactory).get(ExerciseTwoViewmodel::class.java);

        binding.setLifecycleOwner(this)

        binding.exerciseTwoViewModel = exerciseTwoViewmodel;


        binding.btnAdd.setOnClickListener { view: View ->

            var thedate = binding.btnDate.text.toString()
            var thetime = binding.txtTime.text.toString()
            var distance = binding.txtDistance.text.toString().toInt()

            var newExercise = ExerciseTwoEntity(0, thedate, thetime, distance)

            exerciseTwoViewmodel.addExerciseTwo(newExercise)

            view.findNavController()
                .navigate(R.id.action_exerciseAddTwoFragment3_to_exerciseTwoFragment)
        }


        binding.btnDate.setOnClickListener {
            val now = Calendar.getInstance()
            val datePicker = DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    val selectedDate = Calendar.getInstance()
                    selectedDate.set(Calendar.YEAR, year)
                    selectedDate.set(Calendar.MONTH, month)
                    selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    val date = formate.format(selectedDate.time)

                    btnDate.text = formate.format(selectedDate.time)
                    Toast.makeText(requireContext(), "Date: " + date, Toast.LENGTH_LONG).show()
                },
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }

        binding.txtTime.setOnClickListener {
            val now = Calendar.getInstance()

            val timePicker = TimePickerDialog(
                requireContext(), TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    val selectedTime = Calendar.getInstance()
                    selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
                    selectedTime.set(Calendar.MINUTE, minute)

                    txtTime.text = timeFormat.format(selectedTime.time)

                    Toast.makeText(
                        requireContext(),
                        "Time: " + timeFormat.format(selectedTime.time),
                        Toast.LENGTH_SHORT
                    ).show()
                },
                now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), false
            )

            timePicker.show()
        }

        (activity as AppCompatActivity).supportActionBar?.title = ("Exercise Add Page")

        return binding.root
    }
}