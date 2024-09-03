package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    fun checkSubstringAnagram(text: String, pattern: String): Boolean {

        // Initialise both arrays from 0..25 (ASCII a-z)
        val patternCharFrequency = IntArray(26)
        val windowCharFrequency = IntArray(26)

        // Calculating character frequency in pattern
        for (char in pattern) {
            patternCharFrequency[char - 'a']++
        }

        // Calculating character frequency in text
        for (i in pattern.indices) {
            windowCharFrequency[text[i] - 'a']++
        }

        // If initial pattern matches then
        if (patternCharFrequency.contentEquals(windowCharFrequency)) {
            return true
        }

        // else use sliding window approach to match substring of text with pattern
        for (i in 0 until (text.length - pattern.length)) {
            windowCharFrequency[text[i] - 'a']--    // decrement leftmost char frequency
            windowCharFrequency[text[i + pattern.length] - 'a']++   // increment rightmost char frequency

            if (patternCharFrequency.contentEquals(windowCharFrequency)) {
                return true // If frequencies match, then substring is anagram
            }
        }

        return false    // If initial frequency match and sliding window approach result in no anagram then return false
    }

    val result = checkSubstringAnagram("cbaebabacd", "abc")
    println("Provided pattern is an anagram: $result")

}