package com.airpremia.archi.user.application

import com.airpremia.archi.user.controller.dto.SignInRequest
import com.airpremia.archi.user.controller.dto.SignInResponse
import com.airpremia.archi.user.controller.dto.SignUpRequest
import com.airpremia.archi.user.controller.dto.SignUpResponse
import com.airpremia.archi.user.domain.component.UserFinder
import com.airpremia.archi.user.domain.component.UserManager
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userFinder: UserFinder,
    private val userManager: UserManager
) {

    fun signIn(signInRequest: SignInRequest): SignInResponse {
        val userInfo = userFinder.findByUserIdAndPassword(signInRequest.userId, signInRequest.password)
            ?: throw RuntimeException("Invalid Login Request")

        return SignInResponse(userInfo)
    }

    fun signUp(signUpRequest: SignUpRequest): SignUpResponse {
        if (!Objects.isNull(userFinder.findByUserId(signUpRequest.userId))) {
            throw RuntimeException("Duplicate User Id")
        }

        if (!Objects.isNull(userFinder.findByUserEmail(signUpRequest.userEmail))) {
            throw RuntimeException("Duplicate Email")
        }

        if (!Objects.isNull(userFinder.findByUserPhone(signUpRequest.userPhone))) {
            throw RuntimeException("Duplicate Phone Number")
        }

        return SignUpResponse(userManager.signUp(signUpRequest))
    }
}
