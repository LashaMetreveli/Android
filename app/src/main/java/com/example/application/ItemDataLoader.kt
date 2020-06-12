package com.example.application

import android.util.Log.d
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object ItemDataLoader {

    private var retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl("http://www.mocky.io/v2/5edb4d643200002a005d26f0/")
        .build()

    private var service = retrofit.create(RetrofitAPI::class.java)

    fun getRequest(path: String, customCallback: CustomCallback) {
        val call = service.getRequest(path)
        call.enqueue(callBack(customCallback))
    }

    private fun callBack(customCallback: CustomCallback): Callback<String> =
        object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                d("getRequst:", "${t.message}")
                customCallback.onFailure(t.message.toString())
            }
            override fun onResponse(call: Call<String>, response: Response<String>) {
                d("getRequst Success:", "${response.body()}")
            }
        }

}

interface RetrofitAPI {

    @GET("{path}")
    fun getRequest(@Path("path") path: String): Call<String>
}