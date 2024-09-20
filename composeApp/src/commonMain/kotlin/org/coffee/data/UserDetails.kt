package org.coffee.data

data class UserDetails(
    var name:String="",
    var email:String="",
    var mobile:String="",
    var gender:String="",
    var password:String="",
    val isLogin:Boolean=false
)
