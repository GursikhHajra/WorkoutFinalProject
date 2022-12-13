package project.st991571169st991571540.gursikhpeter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import project.st991571169st991571540.gursikhpeter.databinding.ListItemEx2Binding

class MyRecyclerViewEx2(private val ex2Data: List<ExerciseTwoEntity>):
    RecyclerView.Adapter<MyRecyclerViewEx2.ViewHolder>()  {

    inner class ViewHolder(val binding: ListItemEx2Binding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ExerciseTwoEntity, index: Int) {
            binding.exerciseTwoEntity = item
            val deleteItem = binding.btnDelete

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val listItemEx2Binding = ListItemEx2Binding.inflate(inflater, parent, false)

        return ViewHolder(listItemEx2Binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind(ex2Data[i], i)

    }

    override fun getItemCount(): Int {
        return ex2Data.size
    }
}