package project.st991571169st991571540.gursikhpeter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ExerciseTwoViewmodel(
    val database: ExerciseTwoDao,
    application: Application
) : AndroidViewModel(application){

    private var exercisetwolivedata = MutableLiveData<ExerciseTwoEntity>();

    private var exercisetwolivedatalist = MutableLiveData<List<ExerciseTwoEntity>>();

    fun addExerciseTwo(exercise: ExerciseTwoEntity)
    {
        GlobalScope.launch {
            database.insertTwo(exercise)
        }
    }
}