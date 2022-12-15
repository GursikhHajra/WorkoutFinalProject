package project.st991571169st991571540.gursikhpeter
/*
Made By:
Peter Mascherin - 991571540
Gursikh Hajra - 991571169
 */

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import project.st991571169st991571540.gursikhpeter.databinding.FragmentExcerciseOneBinding
import project.st991571169st991571540.gursikhpeter.databinding.FragmentExerciseTwoBinding
import androidx.lifecycle.*

class ExerciseTwoFragment : Fragment() {
    private lateinit var mDb: ProjectDB
    private lateinit var manager: RecyclerView.LayoutManager


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: FragmentExerciseTwoBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_exercise_two, container, false
        )

        binding.btnAdd.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_exerciseTwoFragment_to_exerciseAddTwoFragment3)
        }

        val applicationContext = requireNotNull(this.activity).applicationContext;
        mDb = ProjectDB.getInstance(applicationContext)


        manager = LinearLayoutManager(requireContext())

        val application = requireNotNull(this.activity).application;

        val dataSource = ProjectDB.getInstance(application).ExerciseTwoDao()

        val viewModelFactory = ExcerciseTwoViewmodelFactory(dataSource, application);

        val exerciseTwoViewmodel =
            ViewModelProviders.of(this, viewModelFactory).get(ExerciseTwoViewmodel::class.java);

        exerciseTwoViewmodel.exercisetwolivedatalist.observe(requireActivity(), Observer {
            binding.recyclerView.apply {
                adapter = MyRecyclerViewEx2(it)
                layoutManager = manager
            }
        })

        (activity as AppCompatActivity).supportActionBar?.title = ("Exercise Two Page")
        return binding.root
    }
}