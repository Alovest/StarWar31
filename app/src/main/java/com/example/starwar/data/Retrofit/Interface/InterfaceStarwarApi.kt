package com.example.starwar.data.Retrofit.Interface

import com.example.starwar.data.Retrofit.Pojo.FilmsApi
import com.example.starwar.data.Retrofit.Pojo.PeopleApi
import retrofit2.http.GET
import retrofit2.http.Path

interface InterfaceStarwarApi {
    @GET("people/{id}")
    suspend fun getPersonId(
        @Path("id") personId: Int
    ): PeopleApi

    @GET("films/{id}")
    suspend fun getFilmById(
        @Path("id") filmId: Int
    ): FilmsApi
}