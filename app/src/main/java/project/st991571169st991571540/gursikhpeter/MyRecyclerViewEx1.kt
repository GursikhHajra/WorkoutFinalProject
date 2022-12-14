package project.st991571169st991571540.gursikhpeter
/*
import android.app.LauncherActivity
import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_ex1.view.**/

/*class MyRecyclerViewEx1(val context: Context, val listener: IMyRecyclerViewEx1): RecyclerView.Adapter <MyRecyclerViewEx1.MyViewHolder>() {

    val allData = ArrayList<ExerciseOneEntity>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val image = itemView.findViewById<ImageView>(R.id.image_view)
        val title = itemView.findViewById<TextView>(R.id.title)
        val date = itemView.findViewById<TextView>(R.id.date)
        val time = itemView.findViewById<TextView>(R.id.time)
        val pushups = itemView.findViewById<TextView>(R.id.pushup)
        val edit = itemView.findViewById<ImageView>(R.id.btnEdit)
        val delete = itemView.findViewById<ImageView>(R.id.btnDelete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewHolder = MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_ex1,
            parent, false))

        viewHolder.delete.setOnClickListener {
            listener.onItemClicked(allData[viewHolder.adapterPosition])
        }

        viewHolder.edit.setOnClickListener {
            listener.onItemClicked(allData[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount() = allData.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = allData [position]

        holder.date.text = currentItem.date
        holder.time.text = currentItem.timePicker
        holder.pushups.text = currentItem.pushup.toString()
    }

    fun updateList(newList: List<ExerciseOneEntity>){
        allData.clear()
        allData.addAll(newList)

        notifyDataSetChanged()
    }
}

interface IMyRecyclerViewEx1{
    fun onItemClicked(exerciseOneEntity: ExerciseOneEntity)
}
*/
import android.view.LayoutInflater
import android.view.ScrollCaptureCallback
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import project.st991571169st991571540.gursikhpeter.databinding.ListItemEx1Binding


class MyRecyclerViewEx1(private val ex1Data: List<ExerciseOneEntity>) :
    RecyclerView.Adapter<MyRecyclerViewEx1.ViewHolder>() {

    inner class ViewHolder(val binding: ListItemEx1Binding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ExerciseOneEntity, index: Int) {
            binding.exerciseOneEntity = item
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

        val listItemEx1Binding = ListItemEx1Binding.inflate(inflater, parent, false)

        return ViewHolder(listItemEx1Binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind(ex1Data[i], i)

    }

    override fun getItemCount(): Int {
        return ex1Data.size
    }


}


