package project.st991571169st991571540.gursikhpeter


import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_excercise_one.*
import project.st991571169st991571540.gursikhpeter.ProjectDB.Companion.getInstance
import project.st991571169st991571540.gursikhpeter.databinding.FragmentExcerciseOneBinding

class ExerciseOneFragment : Fragment() {

    private lateinit var mDb:ProjectDB
    lateinit var viewModel: ExerciseOneViewmodel

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<MyRecyclerViewEx1.ViewHolder>? = null

    private lateinit var manager: RecyclerView.LayoutManager

    override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {

    // Inflate the layout for this fragment
    val binding: FragmentExcerciseOneBinding = DataBindingUtil.inflate(
        inflater, R.layout.fragment_excercise_one, container, false)

    binding.btnAdd.setOnClickListener{ view : View ->
        view.findNavController().navigate(R.id.action_excerciseOneFragment_to_excerciseAddOneFragment)
    }

        var ex1Data = listOf(ExerciseOneEntity(1, "today", "rn", 78), ExerciseOneEntity(2, "peter", "ok", 278),ExerciseOneEntity (3, "when", "workwithdb", 178))

        manager = LinearLayoutManager(requireContext())

        binding.recyclerView.apply {
            adapter = MyRecyclerViewEx1(ex1Data)
            layoutManager = manager
        }



     /*   mDb = ProjectDB.getInstance(requireActivity())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = MyRecyclerViewEx1(requireContext(), this)
        recyclerView.adapter = adapter

        val application = requireNotNull(this.activity).application;
val application = requireNotNull(this.activity).application;

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(ExerciseOneViewmodel::class.java)


        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(ExerciseOneViewmodel::class.java)

        viewModel.exerciseonelivedatalist.observe(viewLifecycleOwner, Observer {list ->
            list?.let {
                adapter.updateList(it)
            }
        })*/


    return binding.root
 }
    /*override fun onItemClicked(exerciseOneEntity: ExerciseOneEntity) {
        viewModel.delete(exerciseOneEntity)

    }*/

   /* override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        recycler_view.apply {

            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = MyRecyclerViewEx1()
        }
    }*/
}
