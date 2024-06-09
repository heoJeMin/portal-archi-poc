package com.airpremia.archi.user.controller.dto

data class SignUpRequest(
    val userId: String,
    val password: String,
    val userName: String,
    val userEmail: String,
    val userPhone: String
) {
    fun validate() {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
        val phoneRegex = "^(01[016789]-?\\d{3,4}-?\\d{4})$".toRegex()

        if (!emailRegex.matches(userEmail)) {
            throw RuntimeException("Invalid email format")
        }

        if (!phoneRegex.matches(userPhone)) {
            throw RuntimeException("Invalid phone number format")
        }
    }
}
