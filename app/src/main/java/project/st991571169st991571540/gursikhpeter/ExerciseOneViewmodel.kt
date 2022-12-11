package project.st991571169st991571540.gursikhpeter

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class ExerciseOneViewmodel(
            val database: ExerciseOneDao,
            application: Application
            ) : AndroidViewModel(application){

    private var exerciseOneJob = Job();
    private var uiScope = CoroutineScope(Dispatchers.Main + exerciseOneJob)
  //  private val repository: ExerciseOneRepository

    private var exerciseonelivedata = MutableLiveData<ExerciseOneEntity>();

    var exerciseonelivedatalist = MutableLiveData<List<ExerciseOneEntity>>();

    init {
        val doa = ProjectDB.getInstance(application).ExerciseOneDao()
       // repository = ExerciseOneRepository(doa)
       // exerciseonelivedatalist = repository.exerciseonelivedatalist as MutableLiveData<List<ExerciseOneEntity>>
    }


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
            //repository.insert(exercise)
        }
    }

    fun delete(exerciseOneEntity: ExerciseOneEntity){
        uiScope.launch {
            database.delete(
                exerciseOneEntity.id
            )
        }
    }
}