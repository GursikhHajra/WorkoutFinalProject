package project.st991571169st991571540.gursikhpeter

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExerciseOneDao {
    @Query("SELECT * FROM exerciseOne")
    fun getAllExOne(): List<ExerciseOneEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(exerciseOne: ExerciseOneEntity)
}