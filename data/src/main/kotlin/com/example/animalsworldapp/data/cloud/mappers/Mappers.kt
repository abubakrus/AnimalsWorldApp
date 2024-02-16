package com.example.animalsworldapp.data.cloud.mappers

import com.example.animalsworldapp.data.cloud.models.fauna.FaunaCloud
import com.example.animalsworldapp.data.cloud.models.flora.FloraCloud
import com.example.animalsworldapp.data.cloud.models.forests.ForestCloud
import com.example.animalsworldapp.data.cloud.models.mountain.MountainCloud
import com.example.animalsworldapp.data.cloud.models.users.UsersCloud
import com.example.animalsworldapp.domain.models.FaunaDomain
import com.example.animalsworldapp.domain.models.FloraDomain
import com.example.animalsworldapp.domain.models.ForestDomain
import com.example.animalsworldapp.domain.models.MountainDomain
import com.example.animalsworldapp.domain.models.UsersDomain


fun FaunaCloud.toDomain(): FaunaDomain = this.run {
    FaunaDomain(
        objectId = objectId,
        classes = classes,
        name = name,
        backgroundImage = backgroundImage.url,
        image = image.url,
        interestingFact = interestingFact,
        aboutFauna = aboutFauna,
        location = location,
        createdAt = createdAt,
        locationImage = locationImage.url,
        updatedAt = updatedAt,
        voice = voice?.url,
        videoUri = videoUri
    )
}

fun UsersCloud.toDomain(): UsersDomain = this.run {
    UsersDomain(
        about = about,
        avatar = avatar?.url,
        contactWithMe = contactWithMe,
        createdAt = createdAt,
        lastName = lastName,
        location = location,
        name = name,
        nickName = nickName,
        id = id,
        updatedAt = updatedAt,
        email = email,
        password = password
    )
}

fun FloraCloud.toDomain(): FloraDomain = this.run {
    FloraDomain(
        id = objectId,
        name = name,
        backgroundImage = backgroundImage.url,
        image = image.url,
        interestingFact = interestingFact,
        aboutFlora = aboutFlora,
        location = location
    )
}

fun MountainCloud.toDomain(): MountainDomain = this.run {
    MountainDomain(
        id = objectId,
        name = name,
        backgroundImage = backgroundImage.url,
        image = image.url,
        interestingFact = interestingFact,
        about = about,
        location = location,
        locationImage = locationImage.url
    )
}

fun ForestCloud.toDomain(): ForestDomain = this.run {
    ForestDomain(
        about = about,
        backgroundImage = backgroundImage.url,
        createdAt = createdAt,
        image = image.url,
        interestingFact = interestingFact,
        location = location,
        name = name,
        id = id,
        updatedAt = updatedAt
    )
}
