package com.example.loginvalidation.roomdb

class PersonRepository(private val dao: PersonDao) {

    suspend fun insert(person: Person) {
        dao.insertPerson(person)
    }

    val getEmail = dao.getEmail()

    val getPassword = dao.getPassword()
}