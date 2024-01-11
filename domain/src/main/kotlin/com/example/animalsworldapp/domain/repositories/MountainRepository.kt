package com.example.animalsworldapp.domain.repositories

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.MountainDomain

interface MountainRepository {

    suspend fun fetchMountainById(id: String): Result<MountainDomain>

    suspend fun fetchAllMountain(): Result<List<MountainDomain>>

    suspend fun getLimitedData(limit: Int): Result<List<MountainDomain>>

    suspend fun deleteMountainById(id: String)

    suspend fun updateMountain(updateFauna: MountainDomain): Result<MountainDomain>
}