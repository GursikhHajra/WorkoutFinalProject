package project.st991571169st991571540.gursikhpeter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import project.st991571169st991571540.gursikhpeter.databinding.ListItemDietBinding

class MyRecyclerViewDiet(private val dietData: List<DietEntity>):
    RecyclerView.Adapter<MyRecyclerViewDiet.ViewHolder>()  {

    inner class ViewHolder(val binding: ListItemDietBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DietEntity, index: Int) {
            binding.diet = item
            val deleteItem = binding.btnDelete

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