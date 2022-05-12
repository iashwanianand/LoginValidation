package com.example.loginvalidation.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(person: Person)

    @Query("SELECT email FROM person_details")
    fun getEmail()

    @Query("SELECT password FROM person_details")
    fun getPassword()
}