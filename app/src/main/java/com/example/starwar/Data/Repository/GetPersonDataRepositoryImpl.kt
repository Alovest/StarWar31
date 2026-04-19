package com.example.starwar.Data.Repository

import com.example.starwar.Data.Retrofit.Interface.InterfaceStarwarApi
import com.example.starwar.Data.Retrofit.Pojo.FilmsApi
import com.example.starwar.Data.Retrofit.Pojo.PeopleApi
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