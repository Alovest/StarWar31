package com.example.starwar.Data.Repository

import com.example.starwar.Data.Retrofit.Interface.InterfaceStarwarApi
import com.example.starwar.Data.Retrofit.Pojo.FilmsApi
import com.example.starwar.Data.Retrofit.Pojo.PeopleApi

class GetPersonDataRepository(apiService: InterfaceStarwarApi) {
    val apiService = apiService
    suspend fun getPersonData(id: Int): PeopleApi{
       return apiService.getPersonId(id)
    }

    suspend fun getFilmByIdRep(id: Int): FilmsApi{
        return apiService.getFilmById(id)
    }
}