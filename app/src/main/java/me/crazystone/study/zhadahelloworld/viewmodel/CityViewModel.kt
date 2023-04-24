package me.crazystone.study.zhadahelloworld.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CityViewModel : ViewModel() {

    private val cityData = MutableLiveData<String>()
    private val messageData = MutableLiveData<String>()
    private val list = MutableLiveData<MutableList<String>>()

    init {
        list.value = mutableListOf()
    }

    fun update(message: String) {
        messageData.value = message
    }

    fun add(message: String) {
        var _list = list.value
//        Log.d("wtf","_list:" + _list)
        _list?.add(message)
        list.value = _list!!
    }

    fun getMessageData(): LiveData<String> = messageData

    fun getCityData(): LiveData<String> = cityData

    fun getList(): LiveData<MutableList<String>> = list
}