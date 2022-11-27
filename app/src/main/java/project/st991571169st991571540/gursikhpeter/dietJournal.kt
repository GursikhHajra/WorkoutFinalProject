package project.st991571169st991571540.gursikhpeter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import project.st991571169st991571540.gursikhpeter.databinding.FragmentDietJournalBinding
import project.st991571169st991571540.gursikhpeter.databinding.FragmentExcerciseOneBinding

class DietJournal : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: FragmentDietJournalBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_diet_journal, container, false)

        binding.btnAdd.setOnClickListener{ view : View ->
            view.findNavController().navigate(R.id.action_dietJournal_to_dietJournalAdd)
        }

        return binding.root
    }
}