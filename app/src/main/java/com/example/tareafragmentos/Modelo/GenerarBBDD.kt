package com.example.tareafragmentos.Modelo

import android.content.Context
import android.util.Log
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.tareafragmentos.Modelo.Dao.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Database(entities = [Alumno::class, Profesor::class], version = 1)

abstract class GenerarBBDD : RoomDatabase() {

    abstract fun profesorDao(): ProfesorDao
    abstract fun alumnoDao(): AlumnoDao



    companion object {
        private const val DB_NAME = "Data"

        @Volatile
        private var INSTANCE: GenerarBBDD? = null
        fun getDatabase(context: Context): GenerarBBDD? {
            INSTANCE ?: synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    GenerarBBDD::class.java,
                    DB_NAME
                )./*addMigrations(MIGRATION_1_2).*/build()
            }
            return INSTANCE
        }
        }

}