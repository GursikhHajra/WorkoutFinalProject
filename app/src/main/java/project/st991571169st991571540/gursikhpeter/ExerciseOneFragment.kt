package project.st991571169st991571540.gursikhpeter


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

    private lateinit var mDb:ProjectDB
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
        inflater, R.layout.fragment_excercise_one, container, false)

    binding.btnAdd.setOnClickListener{ view : View ->
        view.findNavController().navigate(R.id.action_excerciseOneFragment_to_excerciseAddOneFragment)
    }
        val applicationContext = requireNotNull(this.activity).applicationContext;
        mDb = ProjectDB.getInstance(applicationContext)

       // var ex1Data = listOf(ExerciseOneEntity(1, "today", "rn", 78), ExerciseOneEntity(2, "peter", "ok", 278),ExerciseOneEntity (3, "when", "workwithdb", 178))

        manager = LinearLayoutManager(requireContext())

        val application = requireNotNull(this.activity).application;

        val dataSource = ProjectDB.getInstance(application).ExerciseOneDao()

        val viewModelFactory = ExcerciseOneViewmodelFactory(dataSource,application);

        val exerciseOneViewmodel = ViewModelProviders.of(this,viewModelFactory).get(ExerciseOneViewmodel::class.java);

        exerciseOneViewmodel.exerciseonelivedatalist.observe(requireActivity(), Observer {
            binding.recyclerView.apply {
                adapter = MyRecyclerViewEx1(it)
                layoutManager = manager
            }
        })


/*        viewModel.exerciseonelivedatalist.observe(viewLifecycleOwner, Observer {
            displayData(it)
        })*/

        /*binding.btnReload.setOnClickListener {


        GlobalScope.launch {
            val ex1Data = mDb.ExerciseOneDao().getAllExOne()

            getActivity()?.runOnUiThread(){
                binding.recyclerView.apply {
                    adapter = MyRecyclerViewEx1(ex1Data)
                    layoutManager = manager
                }
            }
        }
    }*/

/*
       fun OnDelete(Item : ExerciseOneEntity, position: Int){
            viewModel.delete(Item)
        }*/




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

      (activity as AppCompatActivity).supportActionBar?.title = ("Exercise One Page")
    return binding.root
 }

    private fun displayData(exerciseOneEntities: List<ExerciseOneEntity>) {
        adapter = MyRecyclerViewEx1(exerciseOneEntities)
    }
/*
    fun delete(item: ExerciseOneEntity){
        viewModel.delete(item)
    }*/

    /*override fun onItemClicked(exerciseOneEntity: ExerciseOneEntity) {
        viewModel.delete(exerciseOneEntity)

    }*/

   /* override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        recycler_view.apply {

            // set a LinearLayoutManager to handle Android
            // RecyclerView behaviorZ
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = MyRecyclerViewEx1()
        }
    }*/
}
