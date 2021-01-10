package com.sunnyWeather.android.ui.place

import androidx.lifecycle.*

import com.sunnyWeather.android.logic.Repository
import com.sunnyWeather.android.logic.model.Place

class PlaceViewModel : ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }
    fun savePlace(place: Place)=Repository.savePlace(place)
    fun getSavedPlace()=Repository.getSavedPlace()
    fun isPlaceSaved()=Repository.isPlaceSaved()


}