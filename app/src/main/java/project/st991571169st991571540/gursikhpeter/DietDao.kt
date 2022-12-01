package project.st991571169st991571540.gursikhpeter

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DietDao {
    @Query("SELECT * FROM diet")
    fun getAllDiet(): List<DietEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDiet(diet: DietEntity)

    @Query("DELETE FROM diet")
    fun deleteAllDiet()

    @Query("UPDATE diet SET date= :date,time=:time, name=:name, calories=:calories WHERE id=:id")
    fun editDiet(id: Long?, date: String, time: String, name: String, calories: String)
}