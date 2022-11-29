package project.st991571169st991571540.gursikhpeter

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExerciseThreeDao {
    @Query("SELECT * FROM exerciseThree")
    fun getAllExThree(): List<ExerciseThreeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(exerciseThree: ExerciseThreeEntity)
}