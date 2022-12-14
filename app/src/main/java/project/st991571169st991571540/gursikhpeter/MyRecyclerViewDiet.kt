package project.st991571169st991571540.gursikhpeter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import project.st991571169st991571540.gursikhpeter.databinding.ListItemDietBinding

class MyRecyclerViewDiet(private val dietData: List<DietEntity>):
    RecyclerView.Adapter<MyRecyclerViewDiet.ViewHolder>()  {

    inner class ViewHolder(val binding: ListItemDietBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DietEntity, index: Int) {
            binding.diet = item

            val deleteItem = binding.btnDelete
            val editItem = binding.btnEdit
            deleteItem.setOnClickListener(object : View.OnClickListener {

                override fun onClick(v: View?) {

                    val activity = v!!.context as AppCompatActivity
                    val application = requireNotNull(activity).application;
                    val dataSource = ProjectDB.getInstance(application).ExerciseThreeDao()
                    val viewModelFactory = ExcerciseThreeViewmodelFactory(dataSource, application);

                    //val exerciseThreeViewmodel = ViewModelProvider.get(ExerciseThreeViewmodel::class.java);


                    val context = v!!.context
                    //val exerciseAddThreeFragment = ExerciseThreeViewmodel(ProjectDB, activity)
                    Toast.makeText(context, R.string.v2, Toast.LENGTH_SHORT).show()
                }
            })
            editItem.setOnClickListener(object : View.OnClickListener {

                override fun onClick(v: View?) {

                    val activity = v!!.context as AppCompatActivity
                    val application = requireNotNull(activity).application;
                    val dataSource = ProjectDB.getInstance(application).ExerciseThreeDao()
                    val viewModelFactory = ExcerciseThreeViewmodelFactory(dataSource, application);

                    //val exerciseThreeViewmodel = ViewModelProvider.get(ExerciseThreeViewmodel::class.java);


                    val context = v!!.context
                    //val exerciseAddThreeFragment = ExerciseThreeViewmodel(ProjectDB, activity)
                    Toast.makeText(context, R.string.v2, Toast.LENGTH_SHORT).show()
                }
            })

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val listItemDietBinding = ListItemDietBinding.inflate(inflater, parent, false)

        return ViewHolder(listItemDietBinding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind(dietData[i], i)

    }

    override fun getItemCount(): Int {
        return dietData.size
    }
}