package project.st991571169st991571540.gursikhpeter

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_excercise_add_one.*
import project.st991571169st991571540.gursikhpeter.databinding.FragmentExcerciseAddOneBinding
import java.text.SimpleDateFormat
import java.util.*


class ExerciseAddOneFragment : Fragment() {

    var formate =  SimpleDateFormat("dd MMM, YYYY", Locale.CANADA)
    var timeFormat = SimpleDateFormat("hh:mm a", Locale.CANADA)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentExcerciseAddOneBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_excercise_add_one, container, false
        )

        binding.btnAdd.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_excerciseAddOneFragment_to_excerciseOneFragment)
        }

        binding.btnDate.setOnClickListener {
            val now = Calendar.getInstance()
            val datePicker = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener {view, year, month, dayOfMonth ->
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

        binding.txtDistance.setOnClickListener{

        }
        return binding.root
    }
}