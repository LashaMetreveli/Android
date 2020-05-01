package com.example.application

import android.util.Log.d
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


object DataLoader {

    private var retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl("https://reqres.in/api/")
        .build()

    private var service = retrofit.create(RetrofitAPI::class.java)

    fun getRequest(path: String, customCallback: CustomCallback) {
        val call = service.getRequest(path)
        call.enqueue(callBack(customCallback))
    }

    fun postRequest(
        path: String,
        parameters: MutableMap<String, String>,
        customCallback: CustomCallback
    ) {
        var call = service.postRequest(path, parameters);
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
                customCallback.onSuccess(response.body().toString())
            }
        }
}

interface RetrofitAPI {

    @GET("{path}")
    fun getRequest(@Path("path") path: String): Call<String>

    @FormUrlEncoded
    @POST("{path}")
    fun postRequest(@Path("path") path: String, parameterName: Map<String, String>): Call<String>
}

