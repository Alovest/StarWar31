package com.example.starwar.Presentation.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwar.domain.repository.GetPersonDataRepository
import com.example.starwar.Data.Retrofit.Pojo.FilmsApi
import com.example.starwar.Data.Retrofit.Pojo.PeopleApi
import com.example.starwar.domain.usecase.GetFilmUsecase
import com.example.starwar.domain.usecase.GetPersonUsecase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GetPersonDataViewModel(
    private val usecaseFrPrs: GetPersonUsecase,
    private val usecaseFrFlm: GetFilmUsecase
): ViewModel() {

    private val allDataPerson = MutableLiveData<List<PeopleApi>>()
    private val allFilms = MutableLiveData< List<FilmsApi>>()

    val filmData: LiveData<List<FilmsApi>> = allFilms
    val personData: LiveData<List<PeopleApi>> = allDataPerson

    fun getPersonViewModel(ids: List<Int>) {
        viewModelScope.launch(Dispatchers.Main) {
            usecaseFrPrs(ids)
        }
    }
    fun getFilmById(ids: List<Int>){
        viewModelScope.launch(Dispatchers.Main) {
            usecaseFrFlm(ids)
        }
    }
    }


