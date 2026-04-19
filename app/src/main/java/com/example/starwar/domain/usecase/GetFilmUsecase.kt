package com.example.starwar.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.example.starwar.Data.Retrofit.Pojo.FilmsApi
import com.example.starwar.domain.repository.GetPersonDataRepository

class GetFilmUsecase(private val repository: GetPersonDataRepository) {
    private val allFilms = MutableLiveData< List<FilmsApi>>()

    suspend operator fun invoke(ids: List<Int>){
        val filmsList = mutableListOf<FilmsApi>()
        for (id in ids) {
            try {
                val response = repository.getFilmByIdRep(id)
                filmsList.add(response)
            } catch (e: Exception) {
                e.fillInStackTrace()
            }
        }
        allFilms.value = filmsList
    }
}