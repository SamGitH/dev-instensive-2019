package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?,String?>{
        if(fullName == "" || fullName == " ")
            return null to null
        val parts : List<String>? = fullName?.split(" ")
        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)
        return firstName to lastName
    }

    fun transliteration(payload: String, divider:String = " "): String =
        payload
            .map {if (it == ' ') divider else transliteration(it)}
            .reduce {a, b -> a + b}

    private fun transliteration(char: Char): String = when (char) {
        'а'-> "a"
        'б'-> "b"
        'в'-> "v"
        'г'-> "g"
        'д'-> "d"
        'е'-> "e"
        'ё'-> "e"
        'ж'-> "zh"
        'з'-> "z"
        'и'-> "i"
        'й'-> "i"
        'к'-> "k"
        'л'-> "l"
        'м'-> "m"
        'н'-> "n"
        'о'-> "o"
        'п'-> "p"
        'р'-> "r"
        'с'-> "s"
        'т'-> "t"
        'у'-> "u"
        'ф'-> "f"
        'х'-> "h"
        'ц'-> "c"
        'ч'-> "ch"
        'ш'-> "sh"
        'щ'-> "sh'"
        'ъ'-> ""
        'ы'-> "i"
        'ь'-> ""
        'э'-> "e"
        'ю'-> "yu"
        'я'-> "ya"
        'А'-> "A"
        'Б'-> "B"
        'В'-> "V"
        'Г'-> "G"
        'Д'-> "D"
        'Е'-> "E"
        'Ё'-> "E"
        'Ж'-> "Zh"
        'З'-> "Z"
        'И'-> "I"
        'Й'-> "I"
        'К'-> "K"
        'Л'-> "L"
        'М'-> "M"
        'Н'-> "N"
        'О'-> "O"
        'П'-> "P"
        'Р'-> "R"
        'С'-> "S"
        'Т'-> "T"
        'У'-> "U"
        'Ф'-> "F"
        'Х'-> "H"
        'Ц'-> "C"
        'Ч'-> "Ch"
        'Ш'-> "Sh"
        'Щ'-> "Sh'"
        'Ы'-> "I"
        'Э'-> "E"
        'Ю'-> "Yu"
        'Я'-> "Ya"
        else -> "$char"
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        if(firstName === null && lastName !== null)
            return "${lastName?.get(0)?.toUpperCase()}"
        if (firstName !== null && lastName === null)
            return "${firstName?.get(0)?.toUpperCase()}"
        if (firstName === null && lastName === null)
            return "$firstName"
        if ((firstName == " " || firstName == "") && (lastName == " " || lastName == ""))
            return "null"
        return "${firstName?.get(0)?.toUpperCase()}${lastName?.get(0)?.toUpperCase()}"
    }
}