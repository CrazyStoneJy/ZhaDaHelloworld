package me.crazystone.study.zhadahelloworld.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CityViewModel : ViewModel() {

    private val accountData = MutableLiveData<String>()
    private val timeData = MutableLiveData<Int>()

    fun updateAccount(message: String) {
        accountData.value = message
    }

    fun updateTime(time: Int) {
        timeData.value = time
    }

    fun getAccount(): LiveData<String> = accountData

    fun getTime(): LiveData<Int> = timeData

}