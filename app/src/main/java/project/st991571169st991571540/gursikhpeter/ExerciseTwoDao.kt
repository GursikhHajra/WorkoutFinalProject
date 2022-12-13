package project.st991571169st991571540.gursikhpeter

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ExerciseTwoDao {
    @Query("SELECT * FROM exerciseTwo")
    fun getAllExTwo(): LiveData<List<ExerciseTwoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTwo(exerciseTwo: ExerciseTwoEntity)

    @Query("DELETE FROM exerciseTwo")
    fun deleteAll2()

    @Query("UPDATE exerciseTwo SET date= :date,time=:time, distance=:distance WHERE id=:id")
    fun edit2(id: Long?, date: String, time: String, distance: Int)


}