package project.st991571169st991571540.gursikhpeter

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class DietJournalViewmodel(
    val database: DietDao,
    application: Application
) : AndroidViewModel(application) {

    private var dietJob = Job();
    private var uiScope = CoroutineScope(Dispatchers.Main + dietJob)

    private var dietjournallivedata = MutableLiveData<DietEntity>();

    // private var dietjournallivedatalist = MutableLiveData<List<DietEntity>>();

    var dietjournallivedatalist = database.getAllDiet()


    fun addDietEntry(diet: DietEntity) {
        uiScope.launch {
            insertDietEntry(diet)
            Toast.makeText(getApplication(), "Diet Entry Successfully Added", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private suspend fun insertDietEntry(diet: DietEntity) {
        withContext(Dispatchers.IO) {
            database.insertDiet(diet)
        }
    }


}