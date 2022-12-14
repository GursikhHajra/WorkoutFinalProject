package project.st991571169st991571540.gursikhpeter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import project.st991571169st991571540.gursikhpeter.databinding.ListItemEx3Binding


class MyRecyclerViewEx3(private val ex3Data: List<ExerciseThreeEntity>) :
    RecyclerView.Adapter<MyRecyclerViewEx3.ViewHolder>() {


    inner class ViewHolder(val binding: ListItemEx3Binding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ExerciseThreeEntity, index: Int) {
            binding.exerciseThreeEntity = item
            val deleteItem = binding.btnDelete
            val editItem = binding.btnEdit
            val mMenus = binding.btnEdit
            deleteItem.setOnClickListener(object : View.OnClickListener {

                override fun onClick(v: View?) {

                    val activity = v!!.context as AppCompatActivity
                    val application = requireNotNull(activity).application;
                    val dataSource = ProjectDB.getInstance(application).ExerciseThreeDao()
                    val viewModelFactory = ExcerciseThreeViewmodelFactory(dataSource, application);

                    //val exerciseThreeViewmodel = ViewModelProvider.get(ExerciseThreeViewmodel::class.java);


                    val context = v!!.context
                    //val exerciseAddThreeFragment = ExerciseThreeViewmodel(ProjectDB, activity)
                    Toast.makeText(context, "Item Deleted", Toast.LENGTH_SHORT).show()
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
                    Toast.makeText(context, "To be Edited", Toast.LENGTH_SHORT).show()
                }
            })


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val listItemEx3Binding = ListItemEx3Binding.inflate(inflater, parent, false)

        return ViewHolder(listItemEx3Binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind(ex3Data[i], i)

    }

    override fun getItemCount(): Int {
        return ex3Data.size
    }

    private suspend fun deleteItem(position: Int) {
        val item = ex3Data[position]
        (ex3Data as MutableList).remove(item)
        notifyItemChanged(position)
        //  exerciseThreeDao.deleteEntry(item)
    }
}