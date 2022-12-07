package project.st991571169st991571540.gursikhpeter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ExerciseOneViewmodel(
            val database: ExerciseOneDao,
            application: Application
            ) : AndroidViewModel(application){

    private var exerciseonelivedata = MutableLiveData<ExerciseOneEntity>();

    private var exerciseonelivedatalist = MutableLiveData<List<ExerciseOneEntity>>();


    fun addExerciseOne(exercise: ExerciseOneEntity)
    {
            GlobalScope.launch {
                database.insert(exercise);
            }
    }
}