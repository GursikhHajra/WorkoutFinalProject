package project.st991571169st991571540.gursikhpeter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ExerciseThreeViewmodel(
    val database: ExerciseThreeDao,
    application: Application
) : AndroidViewModel(application) {

    private var exercisethreelivedata = MutableLiveData<ExerciseThreeEntity>();

    private var exercisethreelivedatalist = MutableLiveData<List<ExerciseThreeEntity>>();

    fun addExerciseThree(exercise: ExerciseThreeEntity)
    {
        GlobalScope.launch {
            database.insert(exercise)
        }
    }
}