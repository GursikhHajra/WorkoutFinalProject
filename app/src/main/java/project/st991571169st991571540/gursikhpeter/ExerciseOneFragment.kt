package project.st991571169st991571540.gursikhpeter
/*
Made By:
Peter Mascherin - 991571540
Gursikh Hajra - 991571169
 */

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_excercise_one.*
import kotlinx.coroutines.*
import project.st991571169st991571540.gursikhpeter.databinding.FragmentExcerciseOneBinding

class ExerciseOneFragment : Fragment() {

    private lateinit var mDb: ProjectDB

    // lateinit var viewModel: ExerciseOneViewmodel
    lateinit var ex1Data: MutableList<ExerciseOneEntity>
    private var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var adapter: MyRecyclerViewEx1
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var id: ExerciseOneEntity

    /*  private val viewModel by lazy {
          ViewModelProvider(this).get(ExerciseOneViewmodel::class.java)
      }
  */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: FragmentExcerciseOneBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_excercise_one, container, false
        )

        binding.btnAdd.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_excerciseOneFragment_to_excerciseAddOneFragment)
        }
        val applicationContext = requireNotNull(this.activity).applicationContext;
        mDb = ProjectDB.getInstance(applicationContext)

        // var ex1Data = listOf(ExerciseOneEntity(1, "today", "rn", 78), ExerciseOneEntity(2, "peter", "ok", 278),ExerciseOneEntity (3, "when", "workwithdb", 178))

        manager = LinearLayoutManager(requireContext())

        val application = requireNotNull(this.activity).application;

        val dataSource = ProjectDB.getInstance(application).ExerciseOneDao()

        val viewModelFactory = ExcerciseOneViewmodelFactory(dataSource, application);

        val exerciseOneViewmodel =
            ViewModelProviders.of(this, viewModelFactory).get(ExerciseOneViewmodel::class.java);

        exerciseOneViewmodel.exerciseonelivedatalist.observe(requireActivity(), Observer {
            binding.recyclerView.apply {
                adapter = MyRecyclerViewEx1(it)
                layoutManager = manager
            }
        })


        (activity as AppCompatActivity).supportActionBar?.title = ("Exercise One Page")
        return binding.root
    }

    private fun displayData(exerciseOneEntities: List<ExerciseOneEntity>) {
        adapter = MyRecyclerViewEx1(exerciseOneEntities)
    }
}
