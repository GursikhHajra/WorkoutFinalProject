package project.st991571169st991571540.gursikhpeter


import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import project.st991571169st991571540.gursikhpeter.ExerciseOneDao;

class ExcerciseOneViewmodelFactory(
    private val datasource: ExerciseOneDao,
    private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExerciseOneViewmodel::class.java)) {
            return ExerciseOneViewmodel(datasource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}