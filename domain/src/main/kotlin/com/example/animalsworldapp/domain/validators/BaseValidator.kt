package com.example.animalsworldapp.domain.validators

interface BaseValidator {

    fun validate(value: String): Boolean
}