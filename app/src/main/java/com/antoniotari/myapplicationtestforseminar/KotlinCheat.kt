package com.antoniotari.myapplicationtestforseminar

/**
 * Kotlin has two types of constructor - one is the primary constructor and the other is the secondary constructor.
 * One Kotlin class can have one primary constructor, and one or more secondary constructor.
 * Java constructor initializes the member variables, however, in Kotlin the primary constructor initializes the class,
 * whereas the secondary constructor helps to include some extra logic while initializing the same.
 *
 */
class KotlinCheat(private val name: String, private val age: Int = 22) {
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

    fun booleans() {
        val trueBoolean = true
        val falseBoolean = false
        val andCondition = trueBoolean && falseBoolean
        val orCondition = trueBoolean || falseBoolean
    }



    fun collections(args: Array<String>) {
        val numbers: MutableList<Int> = mutableListOf(1, 2, 3) //mutable List
        val readOnlyView: List<Int> = numbers                  // immutable list
        println("my mutable list--$numbers")        // prints "[1, 2, 3]"
        numbers.add(4)
        println("my mutable list after addition --"+numbers)        // prints "[1, 2, 3, 4]"
        println(readOnlyView)
        // readOnlyView.clear()    // ⇒ does not compile
        // gives error
    }

    fun ifElse(args: Array<String>) {
        val a:Int = 5
        val b:Int = 2
        var max: Int

        if (a > b) {
            max = a
        } else {
            max = b
        }
        print("Maximum of a or b is " +max)

        // As expression
        // val max = if (a > b) a else b

        val x:Int = 5
        when (x) {
            1 -> print("x = = 1")
            2 -> print("x = = 2")

            else -> { // Note the block
                print("x is neither 1 nor 2")
            }
        }

        when (x) {
            1,2 -> print(" Value of X either 1,2")

            else -> { // Note the block
                print("x is neither 1 nor 2")
            }
        }
    }

    fun nullSafety() {

        // Nullable properties
        val cannotBeNull: String = null // Invalid
        val canBeNull: String? = null // Valid

        val cannotBeNull: Int = null // Invalid
        val canBeNull: Int? = null // Valid

        // checking null
        val name: String? = "Adam"

        if (name != null && name.length > 0) {
            print("String length is ${name.length}")
        } else {
            print("String is empty.")
        }

        // safe operator
        val nullableStringLength: Int? = nullableString?.length
        val nullableDepartmentHead: String? = person?.department?.head?.name

        // safe cast
        // Will not throw ClassCastException
        val nullableCar: Car? = (input as? Car)

        // elvis operator
        val nonNullStringLength: Int = nullableString?.length ?: 0
        val nonNullDepartmentHead: String = person?.department?.head?.name ?: ""
        val nonNullDepartmentHead: String = person?.department?.head?.name.orEmpty()

    }

    fun printMe() {
        print(name + age + message)
    }
}


// STATIC FIELDS
class Person {
    companion object {
        val NAME_KEY = "name_key"
    }
}

val key = Person.NAME_KEY


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