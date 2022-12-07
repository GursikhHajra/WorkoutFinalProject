package project.st991571169st991571540.gursikhpeter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DietJournalViewmodel(
    val database: DietDao,
    application: Application
) : AndroidViewModel(application){

    private var dietjournallivedata = MutableLiveData<DietEntity>();

    private var dietjournallivedatalist = MutableLiveData<List<DietEntity>>();

    fun addDietEntry(diet: DietEntity)
    {
        GlobalScope.launch {
            database.insertDiet(diet)
        }
    }
}