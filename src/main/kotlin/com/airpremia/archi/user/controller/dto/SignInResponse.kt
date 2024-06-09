package com.airpremia.archi.user.controller.dto

import com.airpremia.archi.user.domain.entity.UserInfo

data class SignInResponse(
    val userId: String,
    val userName: String,
    val userEmail: String,
    val userPhone: String
) {
    constructor(userInfo: UserInfo) : this(
        userId = userInfo.userId,
        userName = userInfo.userName,
        userEmail = userInfo.userEmail,
        userPhone = userInfo.userPhone
    )
}
