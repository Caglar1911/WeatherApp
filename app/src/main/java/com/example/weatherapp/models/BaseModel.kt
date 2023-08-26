package com.example.weatherapp.models

sealed class BaseModel<out T>{
    data class Succes<T>(val data:T):BaseModel<T>()
    data class Error(val error:String):BaseModel<Nothing>()
    object Loading:BaseModel<Nothing>()
}
