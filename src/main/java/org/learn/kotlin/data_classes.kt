package org.learn.kotlin

data class User constructor(val name: String = "Batuhan",
                            val age: Int = 10,
                            val gender: Gender = Gender.MALE) {
    companion object {
        fun of(name: String, age: Int, gender: Gender): User = User(name, age, gender)
    }
}
// data keywordü sınıfa otomatik olarak hashCode(),toString(),equals(),copy(),componentN methodlarını ekler.

enum class Gender {
    MALE,
    FEMALE;

    companion object {
        fun of(s: String): Gender {
            val sUpper = s.toUpperCase()
            if (MALE.name == sUpper) {
                return MALE
            }
            return FEMALE
        }
    }
}

fun main(args: Array<String>) {
    val user = User()
    println("Original user $user")

    val cpUser = user.copy(name = "Asena", age = 20, gender = Gender.of("female"))

    println("Copy user $cpUser")

    println("Is fields new ? : ${user == cpUser}")

    //Destructuring Declarations
    val (name, age, gender) = user

    println("Name $name age $age gender $gender")

    //Desctructring array
    val (el1, el2, el3) = arrayOf(1, 2, 3)

    println("el1 $el1 el2 $el2 el3 $el3")


    // destructuring example with method return.
    val (name1, age2, gender3) = User.of(name = "Asena", age = 19, gender = Gender.of("female"))

    execute { (name, age, gender) -> println("User infos name: $name , age $age , gender $gender") }
}


fun execute(describeFunc: (user: User) -> Unit) {
    describeFunc.invoke(User.of("Batuhan", 23, Gender.of("male")))
}
