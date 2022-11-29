package project.st991571169st991571540.gursikhpeter

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exerciseTwo")
data class ExerciseTwoEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo(name = "date")
    var date: String,
    @ColumnInfo(name = "time")
    var timePicker: String,
    @ColumnInfo(name = "distance")
    var Distance: Int
)