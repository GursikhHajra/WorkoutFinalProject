package project.st991571169st991571540.gursikhpeter

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExerciseThreeDao {
    @Query("SELECT * FROM exerciseThree")
    fun getAllExThree(): LiveData<List<ExerciseThreeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(exerciseThree: ExerciseThreeEntity)

    @Query("DELETE FROM exerciseThree")
    fun deleteAll3()

    @Query("UPDATE exerciseThree SET date= :date,time=:time, weight=:wieght WHERE id=:id")
    fun edit3(id: Long?, date: String, time: String, wieght: Int)

    @Delete
    suspend fun deleteEntry(exerciseThree: ExerciseThreeEntity)
}