package com.example.starwar.data.Repository

import com.example.starwar.data.Retrofit.Interface.InterfaceStarwarApi
import com.example.starwar.data.Retrofit.Pojo.FilmsApi
import com.example.starwar.data.Retrofit.Pojo.PeopleApi
import com.example.starwar.domain.repository.GetPersonDataRepository

class GetPersonDataRepositoryImpl(
    override val apiService: InterfaceStarwarApi
): GetPersonDataRepository {
    override suspend fun getPersonData(id: Int): PeopleApi {
        return apiService.getPersonId(id)
    }

    override suspend fun getFilmByIdRep(id: Int): FilmsApi {
        return apiService.getFilmById(id)
    }
}