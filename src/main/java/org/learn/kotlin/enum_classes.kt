package org.learn.kotlin

enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

enum class ProtocolState {
    WAITING {
        override fun signal() = this.name
    },
    TALKING {
        override fun signal() = this.name
    };

    abstract fun signal(): String
}

enum class Color(val rgb: Int) {
    RED(0xFF0000) {
        override fun sayIam(): Int {
            return this.rgb
        }
    },
    GREEN(rgb = 0x00FF00) {
        override fun sayIam(): Int {
            return this.rgb
        }
    },
    BLUE(rgb = 0x0000FF) {
        override fun sayIam(): Int {
            return this.rgb
        }
    };

    abstract fun sayIam(): Int
}


//good example of generics in Enum
inline fun <reified T : Enum<T>> printAllValues() {
    print(enumValues<T>().joinToString { it.name })
}


fun main(args: Array<String>) {
    val realDirection: Direction = Direction.EAST

    var directions: Array<Direction> = Direction.values()

    val direction = Direction.valueOf("WEST")

    printAllValues<Color>()
}