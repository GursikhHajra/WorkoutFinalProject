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
import project.st991571169st991571540.gursikhpeter.databinding.FragmentDietJournalAddBinding
import project.st991571169st991571540.gursikhpeter.databinding.FragmentDietJournalBinding
import java.text.SimpleDateFormat
import java.util.*

class DietJournalAdd : Fragment() {

    var formate = SimpleDateFormat("dd MMM, YYYY", Locale.CANADA)
    var timeFormat = SimpleDateFormat("hh:mm a", Locale.CANADA)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: FragmentDietJournalAddBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_diet_journal_add, container, false
        )

        val application = requireNotNull(this.activity).application;

        val dataSource = ProjectDB.getInstance(application).DietDao()

        val viewModelFactory = DietJournalViewmodelFactory(dataSource, application);

        val dietJournalViewmodel =
            ViewModelProviders.of(this, viewModelFactory).get(DietJournalViewmodel::class.java);

        binding.setLifecycleOwner(this)

        binding.dietJournalViewmodel = dietJournalViewmodel;

        binding.btnAdd.setOnClickListener { view: View ->

            var thedate = binding.btnDate.text.toString()
            var thetime = binding.txtTime.text.toString()
            var mealname = binding.food.text.toString()
            var calories = binding.cal.text.toString()

            var newDiet = DietEntity(0, thedate, thetime, mealname, calories)

            dietJournalViewmodel.addDietEntry(newDiet)

            view.findNavController().navigate(R.id.action_dietJournalAdd_to_dietJournal)
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

        (activity as AppCompatActivity).supportActionBar?.title = ("Diet Journal Add Page")
        return binding.root
    }
}