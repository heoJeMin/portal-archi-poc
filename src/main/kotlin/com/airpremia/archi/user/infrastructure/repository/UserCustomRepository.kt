package com.airpremia.archi.user.infrastructure.repository

import com.airpremia.archi.user.domain.dto.UserInfoSearchCondition
import com.airpremia.archi.user.domain.entity.UserInfo
import org.springframework.stereotype.Repository

@Repository
interface UserCustomRepository {
    fun findByCondition(condition: UserInfoSearchCondition): List<UserInfo?>
}
