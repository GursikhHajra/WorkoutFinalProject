package project.st991571169st991571540.gursikhpeter

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class ExerciseThreeViewmodel(
    val database: ExerciseThreeDao,
    application: Application
) : AndroidViewModel(application) {

    private var exerciseThreeJob = Job();
    private var uiScope = CoroutineScope(Dispatchers.Main + exerciseThreeJob)

    private var exercisethreelivedata = MutableLiveData<ExerciseThreeEntity>();

    //private var exercisethreelivedatalist = MutableLiveData<List<ExerciseThreeEntity>>();

    var exercisethreelivedatalist = database.getAllExThree()

    fun addExerciseThree(exercise: ExerciseThreeEntity) {
        uiScope.launch {
            insertExercise(exercise)
            Toast.makeText(getApplication(), "Exercise Successfully Added", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private suspend fun insertExercise(exercise: ExerciseThreeEntity) {
        withContext(Dispatchers.IO) {
            database.insert(exercise)
        }
    }

    suspend fun deleteEntry(exercise: ExerciseThreeEntity) = database.deleteEntry(exercise)

    fun deleteEntry2(exercise: ExerciseThreeEntity) = viewModelScope.launch {
        deleteEntry(exercise)
    }
}