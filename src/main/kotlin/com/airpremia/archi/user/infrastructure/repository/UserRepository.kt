package com.airpremia.archi.user.infrastructure.repository

import com.airpremia.archi.user.domain.entity.UserInfo
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserInfo, String> {
    fun findByUserIdAndPassword(userId: String, password: String): UserInfo?
}
