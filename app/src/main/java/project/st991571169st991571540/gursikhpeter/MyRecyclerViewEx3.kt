package project.st991571169st991571540.gursikhpeter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import project.st991571169st991571540.gursikhpeter.databinding.ListItemEx2Binding
import project.st991571169st991571540.gursikhpeter.databinding.ListItemEx3Binding

class MyRecyclerViewEx3 (private val ex3Data: List<ExerciseThreeEntity>):
    RecyclerView.Adapter<MyRecyclerViewEx3.ViewHolder>()  {

    inner class ViewHolder(val binding: ListItemEx3Binding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ExerciseThreeEntity, index: Int) {
            binding.exerciseThreeEntity = item
            val deleteItem = binding.btnDelete

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
}