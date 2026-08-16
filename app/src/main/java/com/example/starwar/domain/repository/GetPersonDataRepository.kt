package com.example.starwar.domain.repository

import com.example.starwar.data.Retrofit.Interface.InterfaceStarwarApi
import com.example.starwar.data.Retrofit.Pojo.FilmsApi
import com.example.starwar.data.Retrofit.Pojo.PeopleApi

interface GetPersonDataRepository {
    val apiService: InterfaceStarwarApi
    suspend fun getPersonData(id: Int): PeopleApi {
       return apiService.getPersonId(id)
    }

    suspend fun getFilmByIdRep(id: Int): FilmsApi {
        return apiService.getFilmById(id)
    }
}