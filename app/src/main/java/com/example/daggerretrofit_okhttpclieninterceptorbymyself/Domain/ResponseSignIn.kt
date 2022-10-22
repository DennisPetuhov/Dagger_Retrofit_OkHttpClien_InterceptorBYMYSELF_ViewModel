package com.example.daggerretrofit_okhttpclieninterceptorbymyself.Domain

data class ResponseSignIn (
    val username:String?=null,
    val authorities:Array<String>?=null,
    val accessToken:String?=null,
    val tokenType:String?=null
)

//{
//    "username": "admin",
//    "authorities": [],
//    "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY2NDgwMzE0NiwiZXhwIjoxNjY0ODg5NTQ2fQ.LRwdj8UrRrrCNw5gMb0UGpb_gGQpYXZJk8nUBruh3CmElq0DXBJJhzdJ-KlesTh145Lu1qKwPEvWyb5HsfRd-A",
//    "tokenType": "Bearer"
//}