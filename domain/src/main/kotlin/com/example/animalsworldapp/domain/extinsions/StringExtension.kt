package com.example.animalsworldapp.domain.extinsions


fun String.isTitleCase()
        = isNotEmpty() && this[0].isUpperCase() && drop(1).all{ it.isLowerCase() }