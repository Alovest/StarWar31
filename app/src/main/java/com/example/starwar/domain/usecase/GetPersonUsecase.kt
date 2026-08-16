package com.example.starwar.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.example.starwar.data.Retrofit.Pojo.PeopleApi
import com.example.starwar.domain.repository.GetPersonDataRepository

class GetPersonUsecase(private val repository: GetPersonDataRepository) {
    private val allDataPerson = MutableLiveData<List<PeopleApi>>()

    suspend operator fun invoke(ids: List<Int>){
        val personList = mutableListOf<PeopleApi>()
        for(id in ids){
            try {
                val response = repository.getPersonData(id)
                personList.add(response)
            } catch (e: Exception) {
                e.fillInStackTrace()
            }
        }
        allDataPerson.value = personList
    }
    }
