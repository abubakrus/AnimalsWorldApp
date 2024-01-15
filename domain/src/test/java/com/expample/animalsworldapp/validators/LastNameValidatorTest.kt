package com.expample.animalsworldapp.validators

import com.example.animalsworldapp.domain.validators.BaseValidator
import com.example.animalsworldapp.domain.validators.LastNameValidator
import com.expample.animalsworldapp.validators.assertFalse
import com.expample.animalsworldapp.validators.assertTrue
import org.junit.Test


class LastNameValidatorTest {

    val lastNameValidator: BaseValidator = LastNameValidator()

    @Test
    fun `should return false if value empty`() {
        val name = ""
        val result = lastNameValidator.validate(name)

        assertFalse(result)
    }
    @Test
    fun `should return false if value contains symbols`() {
        val name = "123"
        val result = lastNameValidator.validate(name)

        assertFalse(result)
    }
    @Test
    fun `should return false if value first  letter in not capital`() {
        val name = "abubakir"
        val result = lastNameValidator.validate(name)

        assertFalse(result)
    }
    @Test
    fun `should return false if value more than NAME_MAX_LENGTH`() {
        val name = "abubakirusenbaevkdskmkdskk"
        val result = lastNameValidator.validate(name)

        assertFalse(result)
    }
    @Test
    fun `should return false if value all conditions true`() {
        val name = "Abubakir"
        val result = lastNameValidator.validate(name)

        assertTrue(result)
    }
}

