package com.wsa.ubereats

import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan


data class Foodclas(val bomma: Int,val peru: String ) {

    fun getFormattedName(): Spanned {
        // Splits the name by the hyphen character to separate it into parts
        val words = peru.split(" ")
        val firstWord = words[0].capitalize() // Capitalizes the first word
        val secondWord =
            if (words.size > 1) words[1].capitalize() else "" // Capitalizes the second word if it exists

        // Constructs a SpannableString with the formatted name
        val spannableString = SpannableString("$firstWord $secondWord")

        // Sets the color of the first word to white
        spannableString.setSpan(ForegroundColorSpan(Color.WHITE), 0, firstWord.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        // Checks if there is a second word, and if so, sets its color to black
        if (secondWord.isNotEmpty()) {
            spannableString.setSpan(ForegroundColorSpan(Color.BLACK), firstWord.length + 1, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        // Returns the SpannableString with the color formatting applied
        return spannableString
    }
}



