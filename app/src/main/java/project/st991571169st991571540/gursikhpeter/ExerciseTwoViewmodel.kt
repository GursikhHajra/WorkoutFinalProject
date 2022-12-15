package project.st991571169st991571540.gursikhpeter

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ExerciseTwoViewmodel(
    val database: ExerciseTwoDao,
    application: Application
) : AndroidViewModel(application) {

    private var exerciseTwoJob = Job();
    private var uiScope = CoroutineScope(Dispatchers.Main + exerciseTwoJob)

    private var exercisetwolivedata = MutableLiveData<ExerciseTwoEntity>();

    //  private var exercisetwolivedatalist = MutableLiveData<List<ExerciseTwoEntity>>();

    var exercisetwolivedatalist = database.getAllExTwo()

    fun addExerciseTwo(exercise: ExerciseTwoEntity) {
        uiScope.launch {
            insertExercise(exercise)
            Toast.makeText(getApplication(), "Exercise Successfully Added", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private suspend fun insertExercise(exercise: ExerciseTwoEntity) {
        withContext(Dispatchers.IO) {
            database.insertTwo(exercise)
        }
    }
}