package com.rajendra.kotlin.collection

/**
 * Created by Rajendra Verma on 22/09/22.
 */
class Basic {
    fun printMessage(message: String): Unit {                               // 1
        println(message)
    }

    fun printMessageWithPrefix(message: String, prefix: String = "Info") {  // 2
        println("[$prefix] $message")
    }

    fun sum(x: Int, y: Int): Int {                                          // 3
        return x + y
    }

    fun multiply(x: Int, y: Int) = x * y                                    // 4


}
