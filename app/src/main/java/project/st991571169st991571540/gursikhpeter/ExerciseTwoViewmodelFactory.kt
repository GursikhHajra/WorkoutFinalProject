package project.st991571169st991571540.gursikhpeter

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ExcerciseTwoViewmodelFactory (
    private val datasource: ExerciseTwoDao,
    private val application: Application
) : ViewModelProvider.Factory{

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ExerciseTwoViewmodel::class.java))
        {
            return ExerciseTwoViewmodel(datasource,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}