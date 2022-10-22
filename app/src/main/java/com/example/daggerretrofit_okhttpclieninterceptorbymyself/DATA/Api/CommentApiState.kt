package com.example.daggerretrofit_okhttpclieninterceptorbymyself.DATA.Api

data class CommentApiState<out S>(
    val data: S?,
    val status: Status,
    val msg: String?
) {
    companion object {
        fun <S> success(data: S?): CommentApiState<S> {
            return CommentApiState(data, Status.SUCCESS, " ")}

            fun <S> error(msg: String?): CommentApiState<S> {
                return CommentApiState(null, Status.ERROR, msg)
            }
            fun <S >loading():CommentApiState<S>{
                return CommentApiState(null, Status.LOADING,null)
            }
        }
    }



enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}