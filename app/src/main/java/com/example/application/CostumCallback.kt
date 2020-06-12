package com.example.application

interface CustomCallback {

    fun onSuccess(result: String){}
    fun onFailure(errorMessage: String){}

}