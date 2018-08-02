package org.learn.kotlin

data class User constructor(val name: String = "Batuhan",
                            val age: Int = 20,
                            val gender: Gender = Gender.MALE) {

    companion object {
        internal fun of(name: String,
                        age: Int,
                        gender: String): User = User(name, age, Gender.of(gender))
    }
}

// data keywordü sınıfa otomatik olarak hashCode(),toString(),equals(),copy(),componentN methodlarını ekler.
enum class Gender {
    MALE,
    FEMALE;

    companion object GenderFactory {
        fun of(s: String): Gender = if (MALE.name == s.toUpperCase()) MALE else FEMALE
    }

}

inline fun <reified E : Enum<E>> getAllValuesFromEnum(print: (E) -> Unit) {
    return enumValues<E>()
            .asList()
            .forEach(print)
}


class Computer {

    fun start(): Unit = println("I'm starting...")

    fun stop(): Unit = println("I'm stopping")

    fun calculate(i: Int, y: Int) = x + y
}

fun computerOperatorWithReturn(operation: Computer.() -> Int): Int {
    val computer = Computer()
    return computer.operation()
}

fun computerOperator(operation: Computer.() -> Unit): Unit {
    val computer = Computer()

    computer.operation()

}


fun main(args: Array<String>) {


    computerOperator {
        start()
        stop()
    }

    computerOperatorWithReturn {
        start()
        return@computerOperatorWithReturn calculate(1, 2)
    }


    Computer().apply {
        start()

        stop()
    }


    println("Genders")
    val lazyOf = lazyOf(getAllValuesFromEnum<Gender> {
        println("Gender $it")
    })


    val user = User()
    println("Original user $user")

    val cpUser = user.copy(
            name = "Asena",
            age = 20,
            gender = Gender.of("female")
    )

    println("Copy user $cpUser")

    println("Is fields new ? : ${user == cpUser}")

    //Destructuring Declarations
    val (name, age, gender) = user

    println("Name $name age $age gender $gender")

    //Desctructring array
    val (el1, el2, el3) = arrayOf(1, 2, 3)

    println("el1 $el1 el2 $el2 el3 $el3")


    // destructuring example with method return.
    val (name1, age2, gender3) =
            User.of(name = "Asena", age = 19, gender = "female")

    execute { it -> println("User infos name: ${it.name} , age $it.age , gender $it.gender") }
}


fun execute(func: (user: User) -> Unit) {
    func.invoke(User.of("Batuhan", 23, "male"))
}