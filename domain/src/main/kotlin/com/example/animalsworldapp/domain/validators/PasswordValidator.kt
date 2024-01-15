package com.example.animalsworldapp.domain.validators

import com.example.animalsworldapp.domain.validators.BaseValidator

/**
 * Класс  для валтдации пароля в приложении:
 *
 * - Не должен быть пустым.
 * - Должен содержпть не менее 8 символов.
 */

private const val MIN_LENGTH = 8
private val NAME_REGEX = "[0-9!\"#$%&'()*+,-./:;\\\\<=>?@\\[\\]^_`{|}~]".toRegex()

class PasswordValidator : BaseValidator {
    override fun validate(value: String): Boolean {
        return when {
            value.isEmpty() -> false
            value.length <= MIN_LENGTH -> false
            !value.any() { it.isDigit() } -> false
            !value.any() { it.isLetterOrDigit() } -> false
            else -> true

        }

    }
}