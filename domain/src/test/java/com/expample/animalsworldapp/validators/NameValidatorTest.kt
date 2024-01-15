package com.expample.animalsworldapp.validators

import com.example.animalsworldapp.domain.validators.BaseValidator
import com.example.animalsworldapp.domain.validators.NameValidator
import org.junit.Test


class NameValidatorTest {

    val nameValidator: BaseValidator = NameValidator()

    @Test
    fun `should return false if value empty`() {
        val name = ""
        val result = nameValidator.validate(name)

        assertFalse(result)
    }

    @Test
    fun `should return false if value contains symbols`() {
        val name = "123"
        val result = nameValidator.validate(name)

        assertFalse(result)
    }

    @Test
    fun `should return false if value first  letter in not capital`() {
        val name = "abubakir"
        val result = nameValidator.validate(name)

        assertFalse(result)
    }

    @Test
    fun `should return false if value more than NAME_MAX_LENGTH`() {
        val name = "abubakirusenbaevkdskmkdskk"
        val result = nameValidator.validate(name)

        assertFalse(result)
    }

    @Test
    fun `should return false if value all conditions true`() {
        val name = "Abubakir"
        val result = nameValidator.validate(name)

        assertTrue(result)
    }
}


fun assertFalse(condition: Boolean, message: String? = null) {
    if (condition) {
        throw IllegalStateException(message)
    }
}

fun assertTrue(condition: Boolean, message: String? = null) {
    if (!condition) {
        throw IllegalStateException(message)
    }
}