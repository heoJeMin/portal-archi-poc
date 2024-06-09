package com.airpremia.archi.user.domain.dto

data class UserInfoSearchCondition(
    val userId: String? = null,
    val password: String? = null,
    val userName: String? = null,
    val userEmail: String? = null,
    val userPhone: String? = null
)
