package project.st991571169st991571540.gursikhpeter

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ExerciseOneEntity::class, ExerciseTwoEntity::class, ExerciseThreeEntity::class, DietEntity::class],
    version = 1
)
abstract class ProjectDB : RoomDatabase() {
    abstract fun ExerciseOneDao(): ExerciseOneDao
    abstract fun ExerciseTwoDao(): ExerciseTwoDao
    abstract fun ExerciseThreeDao(): ExerciseThreeDao
    abstract fun DietDao(): DietDao

    companion object {
        @Volatile
        private var INSTANCE: ProjectDB? = null
        fun getInstance(context: Context): ProjectDB {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    ProjectDB::class.java,
                    "project.db"
                ).build()
            }
            return INSTANCE as ProjectDB
        }
    }
}