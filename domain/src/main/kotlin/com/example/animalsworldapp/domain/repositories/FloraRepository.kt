package com.example.animalsworldapp.domain.repositories

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.FloraDomain

interface FloraRepository {

    suspend fun fetchFloraById(id:String):Result<FloraDomain>

    suspend fun fetchAllFlora():Result<List<FloraDomain>>

    suspend fun deleteFloraById(id: String)

    suspend fun updateFlora(updateFlora:FloraDomain):Result<FloraDomain>
}