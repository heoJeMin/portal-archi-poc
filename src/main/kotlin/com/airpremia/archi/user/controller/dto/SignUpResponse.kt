package com.airpremia.archi.user.controller.dto

import com.airpremia.archi.user.domain.entity.UserInfo

data class SignUpResponse(
    val userId: String,
    val userName: String
) {
    constructor(user: UserInfo) : this(user.userId, user.userName)
}
