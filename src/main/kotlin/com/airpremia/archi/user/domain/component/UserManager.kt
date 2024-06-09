package com.airpremia.archi.user.domain.component

import com.airpremia.archi.user.controller.dto.SignUpRequest
import com.airpremia.archi.user.domain.entity.UserInfo
import com.airpremia.archi.user.infrastructure.repository.UserRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserManager(
    private val userRepository: UserRepository
) {
    @Transactional
    fun signUp(signUpRequest: SignUpRequest): UserInfo {
        return userRepository.saveAndFlush(
            UserInfo(
                signUpRequest.userId,
                signUpRequest.password,
                signUpRequest.userName,
                signUpRequest.userEmail,
                signUpRequest.userPhone,
            )
        )
    }
}
