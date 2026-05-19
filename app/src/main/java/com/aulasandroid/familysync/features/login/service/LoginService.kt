package com.aulasandroid.familysync.features.login.service

import com.aulasandroid.familysync.features.login.model.LoginRequest
import com.aulasandroid.familysync.features.login.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginService {

    @Headers(
        "Content-Type: application/json"
    )
    @POST("v1/familysync/login")
    suspend fun logar(
        @Body request: LoginRequest
    ): Response<LoginResponse>
}