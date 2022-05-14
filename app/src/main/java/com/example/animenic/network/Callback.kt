package com.example.animenic.network

interface Callback<T> {

    fun onSuccess(result: T?)
    fun onFailed(exception: Exception)


}