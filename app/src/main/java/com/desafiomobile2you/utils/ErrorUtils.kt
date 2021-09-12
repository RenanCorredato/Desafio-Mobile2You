package com.desafiomobile2you.utils


import com.desafiomobile2you.api.ApiError
import com.desafiomobile2you.api.ApiService
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException

object ErrorUtils {

    fun parseError(response: Response<*>): ApiError? {
        val converter: Converter<ResponseBody, ApiError> = ApiService.getTMDBApiClient()
            .responseBodyConverter(ApiError::class.java, arrayOfNulls<Annotation>(0))

        var error: ApiError? = null

        try {
            response.errorBody()?.let { errorBody ->
                error = converter.convert(errorBody)
            }
        } catch (e: IOException) {
            return ApiError
        }

        return error
    }
}