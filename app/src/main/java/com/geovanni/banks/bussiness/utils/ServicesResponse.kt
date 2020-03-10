package com.geovanni.banks.bussiness.utils

class ServicesResponse<T> {

    private var response: T? = null

    fun setResponse(response: T) {
        this.response = response
    }

}