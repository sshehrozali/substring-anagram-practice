package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    fun checkAnagram(str1: String, str2: String): Boolean {
        val charMapOfStr1 = mutableMapOf<Char, Int>()   // to store occurrences of each char in str1

        // Generate frequency map of str1
        for (char in str1) {
            charMapOfStr1[char] = charMapOfStr1.getOrDefault(char, 0) + 1
        }

        // Decrement frequency based on str2
        for (i in str2.indices) {
            if (charMapOfStr1.containsKey(str2[i])) {
                charMapOfStr1[str2[i]] = charMapOfStr1[str2[i]]!! - 1
            }
        }

        return charMapOfStr1.all { it.value == 0 }
    }

    val result = checkAnagram("evil", "vile")
    println("Provided strings are anagram: $result")
}