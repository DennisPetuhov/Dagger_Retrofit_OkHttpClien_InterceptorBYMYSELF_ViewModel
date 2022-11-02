package com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api

data class ApiState<out S>(
    val data: S?,
    val status: Status,
    val msg: String?
) {
    companion object {
        fun <S> success(data: S?): ApiState<S> {
            return ApiState(data, Status.SUCCESS, " ")}

            fun <S> error(msg: String?): ApiState<S> {
                return ApiState(null, Status.ERROR, msg)
            }
            fun <S >loading():ApiState<S>{
                return ApiState(null, Status.LOADING,null)
            }
        }
    }



enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}