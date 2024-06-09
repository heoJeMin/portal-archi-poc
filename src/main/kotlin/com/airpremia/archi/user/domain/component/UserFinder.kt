package com.airpremia.archi.user.domain.component

import com.airpremia.archi.user.domain.dto.UserInfoSearchCondition
import com.airpremia.archi.user.domain.entity.UserInfo
import com.airpremia.archi.user.infrastructure.repository.UserCustomRepository
import com.airpremia.archi.user.infrastructure.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class UserFinder(
    private val userRepository: UserRepository,
    private val userCustomRepository: UserCustomRepository
) {
    fun findByUserIdAndPassword(userId: String, password: String): UserInfo? {
        return userRepository.findByUserIdAndPassword(userId, password)
    }

    fun findByUserId(userId: String): UserInfo? {
        return userCustomRepository.findByCondition(
            UserInfoSearchCondition(
                userId = userId
            )
        ).firstOrNull()
    }

    fun findByUserEmail(userEmail: String): UserInfo? {
        return userCustomRepository.findByCondition(
            UserInfoSearchCondition(
                userEmail = userEmail
            )
        ).firstOrNull()
    }

    fun findByUserPhone(userPhone: String): UserInfo? {
        return userCustomRepository.findByCondition(
            UserInfoSearchCondition(
                userPhone = userPhone
            )
        ).firstOrNull()
    }
}
