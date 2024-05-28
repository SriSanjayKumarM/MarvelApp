package com.demo.marvelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var currentImage = 0
    lateinit var image: ImageView

    // Character Names Array
    val characterNames = arrayListOf(
        "Captain America", "Iron Man", "Thor", "Loki", "Black Widow", "Hawkeye", "Hulk", "Dr Strange",
        "Wanda Maximoff", "Vision", "Spider-Man", "Captain Marvel", "Black Panther", "Bucky Barnes",
        "Ant-Man", "Nick Fury", "Star Lord", "Thanos", "Moon Knight", "Wolverine")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hide action Bar
        supportActionBar?.hide()

        //Assigning Buttons,Textview by creating a variables
        val next = findViewById<ImageButton>(R.id.btnNext)
        val prev = findViewById<ImageButton>(R.id.btnPrev)
        val name = findViewById<TextView>(R.id.chName)

        // Initialize the first image and character name
        updateImageAndName()

        // On Click handler for next button
        next.setOnClickListener {
            // Hide the current image
            hideCurrentImage()

            // Increment current image to view the next image
            currentImage = (currentImage + 1) % characterNames.size

            // Show the next image
            updateImageAndName()
        }

        // On Click handler for previous button
        prev.setOnClickListener {
            // Hide the current image
            hideCurrentImage()

            // Decrement current image to view the previous image
            currentImage = (currentImage - 1 + characterNames.size) % characterNames.size

            // Show the previous image
            updateImageAndName()
        }
    }

    private fun updateImageAndName() {
        val name = findViewById<TextView>(R.id.chName)
        name.text = characterNames[currentImage]

        // creating a variable and initializing images to it
        // (ie; character$currentImage = character0,1,2,3,..19 which is id name for image view)
        val idImageToShowString = "character$currentImage"

        //Getting integer address associated with each view
        val idImageToShowInt = resources.getIdentifier(idImageToShowString, "id", packageName)
        image = findViewById(idImageToShowInt)

        //Showing next image
        image.alpha = 1f
    }

    private fun hideCurrentImage() {
        val idCurrentImageString = "character$currentImage"

        //Getting integer address associated with each view
        val idCurrentImageInt = resources.getIdentifier(idCurrentImageString, "id", packageName)
        image = findViewById(idCurrentImageInt)

        //Hiding current image
        image.alpha = 0f
    }
}
