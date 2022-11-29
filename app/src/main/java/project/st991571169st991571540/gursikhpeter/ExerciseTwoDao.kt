package project.st991571169st991571540.gursikhpeter

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExerciseTwoDao {
    @Query("SELECT * FROM exerciseTwo")
    fun getAllExTwo(): List<ExerciseTwoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTwo(exerciseTwo: ExerciseTwoEntity)
}