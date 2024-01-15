package com.expample.animalsworldapp.validators

import com.example.animalsworldapp.domain.validators.BaseValidator
import com.example.animalsworldapp.domain.validators.PasswordValidator
import org.junit.Test

class PasswordValidatorTest {

    val passwordValidator: BaseValidator = PasswordValidator()

    @Test
    fun `should return false if value empty`() {
        val name = ""
        val result = passwordValidator.validate(name)

        assertFalse(result)
    }

    @Test
    fun `should return false if value min than MIN_LENGTH`() {
        val name = "ABUBAKR"
        val result = passwordValidator.validate(name)

        assertFalse(result)
    }

    @Test
    fun `should return false if value at least one digit`() {
        val name = "abubakirusenbaev"
        val result = passwordValidator.validate(name)

        assertFalse(result)
    }

    @Test
    fun `should return false if value at least one special character `() {
        val name = "abubakirusenbaev"
        val result = passwordValidator.validate(name)

        assertFalse(result)
    }

    @Test
    fun `should return false if value all conditions true`() {
        val name = "abubakir123321"
        val result = passwordValidator.validate(name)

        assertTrue(result)
    }

}

