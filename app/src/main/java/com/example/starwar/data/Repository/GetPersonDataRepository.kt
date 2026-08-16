package com.example.starwar.data.Repository

import com.example.starwar.data.Retrofit.Interface.InterfaceStarwarApi
import com.example.starwar.data.Retrofit.Pojo.FilmsApi
import com.example.starwar.data.Retrofit.Pojo.PeopleApi

class GetPersonDataRepository(apiService: InterfaceStarwarApi) {
    val apiService = apiService
    suspend fun getPersonData(id: Int): PeopleApi{
       return apiService.getPersonId(id)
    }

    suspend fun getFilmByIdRep(id: Int): FilmsApi{
        return apiService.getFilmById(id)
    }
}