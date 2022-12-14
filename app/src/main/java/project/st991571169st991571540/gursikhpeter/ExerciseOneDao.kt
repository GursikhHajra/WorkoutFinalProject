package project.st991571169st991571540.gursikhpeter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExerciseOneDao {
    @Query("SELECT * FROM exerciseOne")
    fun getAllExOne(): LiveData<List<ExerciseOneEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(exerciseOne: ExerciseOneEntity)

    @Delete
    fun delete(exerciseOne: ExerciseOneEntity)

    @Query("UPDATE exerciseOne SET date= :date,time=:time, pushup=:push WHERE id=:id")
    fun edit(id: Long?, date: String, time: String, push: Int)

}