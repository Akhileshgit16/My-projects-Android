package com.wsa.assigment2

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.content.ContextCompat
import android.graphics.drawable.ColorDrawable
import androidx.core.graphics.blue

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

/*        val main: ConstraintLayout = findViewById(R.id.main)
        val click: Button = findViewById(R.id.button)

        // Define a list of colors using listOf
        val colors = listOf(R.color.red, R.color.yellow, R.color.blue)

// Create an iterator to loop through the colors
        var colorIterator = colors.iterator()

        click.setOnClickListener {
            // Get the next color from the iterator
            if (!colorIterator.hasNext()) {
                // Reset the iterator to the beginning if it has reached the end
                colorIterator = colors.iterator()
            }

            // Set the background color of the ConstraintLayout to the next color
            main.setBackgroundColor(resources.getColor(colorIterator.next()))
        }
*/

        /*  val originalColor = (main.background as ColorDrawable).color
          val colorList = listOf(
              ContextCompat.getColor(this, R.color.red),     // Color 1: red
              ContextCompat.getColor( this, R.color.yellow),  // Color 2: yellow
              ContextCompat.getColor(this, R.color.blue),    // Color 3: blue
              originalColor                                 // Color 4: original
          )

          var colorIndex = 0

          click.setOnClickListener {
              // Set the background color based on colorIndex from the colorList
              main.setBackgroundColor(colorList[colorIndex])

              // Use when to update the colorIndex and cycle it through 0, 1, 2, 3
              colorIndex = when (colorIndex) {
                  0 -> 1  // Move to next color (yellow)
                  1 -> 2  // Move to next color (blue)
                  2 -> 3  // Move to next color (original)
                  else -> 0  // Reset to the first color (red)
              }
          } */

     // Old code with background color change
        val main :ConstraintLayout = findViewById(R.id.main)
        val click: Button = findViewById(R.id.button)

        click.setOnClickListener{
            // Change the background color of the ConstraintLayout
            main.setBackgroundColor(resources.getColor(R.color.black))

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}