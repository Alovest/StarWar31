package com.example.starwar.Presentation.ViewModel

import androidx.core.widget.ListViewAutoScrollHelper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwar.Data.Repository.GetPersonDataRepository
import com.example.starwar.Data.Retrofit.Pojo.FilmsApi
import com.example.starwar.Data.Retrofit.Pojo.PeopleApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.Koin

class GetPersonDataViewModel(
    private val personDataRepository: GetPersonDataRepository,
): ViewModel() {

    private val allDataPerson = MutableLiveData<List<PeopleApi>>()
    private val allFilms = MutableLiveData< List<FilmsApi>>()

    val filmData: LiveData<List<FilmsApi>> = allFilms
    val personData: LiveData<List<PeopleApi>> = allDataPerson

    fun getPersonViewModel(ids: List<Int>){
        viewModelScope.launch(Dispatchers.Main) {
            val personList = mutableListOf<PeopleApi>()
            for(id in ids){
                try {
                    val response = personDataRepository.getPersonData(id)
                    personList.add(response)
                } catch (e: Exception) {
                    e.fillInStackTrace()
                }
            }
            allDataPerson.value = personList
            }
        }
    fun getFilmById(ids: List<Int>){
        viewModelScope.launch(Dispatchers.Main) {
            val filmsList = mutableListOf<FilmsApi>()
            for (id in ids) {
                try {
                    val response = personDataRepository.getFilmByIdRep(id)
                    filmsList.add(response)
                } catch (e: Exception) {
                    e.fillInStackTrace()
                }
            }
            allFilms.value = filmsList
        }
    }
    }


