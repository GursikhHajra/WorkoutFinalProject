package project.st991571169st991571540.gursikhpeter

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ExerciseOneViewmodel(
            val database: ExerciseOneDao,
            application: Application
            ) : AndroidViewModel(application){

    private var exerciseOneJob = Job();
    private var uiScope = CoroutineScope(Dispatchers.Main + exerciseOneJob)


    private var exerciseonelivedata = MutableLiveData<ExerciseOneEntity>();

    private var exerciseonelivedatalist = MutableLiveData<List<ExerciseOneEntity>>();


    fun addExerciseOne(exercise: ExerciseOneEntity)
    {
            uiScope.launch {
                insertExercise(exercise)
                Toast.makeText(getApplication(),"Exercise Successfully Added", Toast.LENGTH_SHORT).show()
            }
    }

    private suspend fun insertExercise(exercise: ExerciseOneEntity)
    {
        withContext(Dispatchers.IO){
            database.insert(exercise)
        }
    }
}