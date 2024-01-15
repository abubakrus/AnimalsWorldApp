package com.example.animalsworldapp.domain.validators

import com.example.animalsworldapp.domain.extinsions.isTitleCase

/**
 * Класс  для валтдации имени в приложении:
 *
 * - Не должен быть пустым.
 * - Не должен содержпть символов.
 * - Первая буква должена быть заглавным.
 * - Максимальное количество символов.
 */


internal const val NAME_MAX_LENGTH = 252
private val NAME_REGEX = "[0-9!\"#$%&'()*+,-./:;\\\\<=>?@\\[\\]^_`{|}~]".toRegex()

class NameValidator : BaseValidator {
    override fun validate(value: String): Boolean {
        return when {
            value.isEmpty() -> false
            value.matches(NAME_REGEX) -> false
            !value.isTitleCase() -> false
            value.length > NAME_MAX_LENGTH -> false
            else -> true

        }

    }
}