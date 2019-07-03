package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User (
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = Date(),
    var isOnline: Boolean = false
)
{
    constructor(id:String, firstName: String?, lastName: String?) : this (
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String):this(id, "Sam", "Sung")

    init {
        println("Im live, " +
        "my name is $firstName $lastName" +
        " last visit ${lastVisit?.format()}")
    }

    companion object Factory {
        private var lastID : Int = -1
        fun makeUser(fullName:String?) : User{
            lastID++
            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User(id = "$lastID",
                firstName = firstName,
                lastName = lastName)
//            return User(id = "$lastID",
//                firstName = "${if (firstName === null || firstName == "") "User" else "$firstName"}",
//                lastName = "${if (lastName === null || lastName == "") "$lastID" else "$lastName"}")
       }
    }
}