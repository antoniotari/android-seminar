package com.antoniotari.myapplicationtestforseminar

/**
 * Kotlin has two types of constructor - one is the primary constructor and the other is the secondary constructor.
 * One Kotlin class can have one primary constructor, and one or more secondary constructor.
 * Java constructor initializes the member variables, however, in Kotlin the primary constructor initializes the class,
 * whereas the secondary constructor helps to include some extra logic while initializing the same.
 *
 */
class KotlinCheat(private val name: String, private val age: Int) {
    init {
        val a: Int = 10000
        val d: Double = 100.00
        val f: Float = 100.00f
        val l: Long = 1000000004
        val s: Short = 10
        val b: Byte = 1

        println("Your Int Value is $a")
        println("Your Double  Value is $d")
        println("Your Float Value is $f")
        println("Your Long Value is $l")
        println("Your Short Value is $s")
        println("Your Byte Value is $b")
    }

    private var message: String = "Tutorials.point"

    constructor(name: String, age: Int, message: String) : this(name, age) {
        this.message = message
    }


    fun printMe() {
        print(name + age + message)
    }
}


/**
 * Everything in Kotlin is by default final, hence, we need to use the keyword “open” in front of the class
 * declaration to make it allowable to inherit. Take a look at the following example of inheritance.
 */
open class ABC {
    fun think () {
        print("Hey!! i am thiking ")
    }
}

class BCD: ABC(){ // inheritance happened using default constructor
}