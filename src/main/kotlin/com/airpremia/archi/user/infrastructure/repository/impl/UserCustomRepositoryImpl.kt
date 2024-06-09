package com.airpremia.archi.user.infrastructure.repository.impl

import com.airpremia.archi.user.domain.dto.UserInfoSearchCondition
import com.airpremia.archi.user.domain.entity.UserInfo
import com.airpremia.archi.user.infrastructure.repository.UserCustomRepository
import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.springframework.stereotype.Repository

@Repository
class UserCustomRepositoryImpl(
    private val kotlinJdslJpqlExecutor: KotlinJdslJpqlExecutor
) : UserCustomRepository {
    override fun findByCondition(condition: UserInfoSearchCondition): List<UserInfo?> {
        return kotlinJdslJpqlExecutor.findAll {
            select(
                entity(UserInfo::class)
            )
                .from(
                    entity(UserInfo::class)
                )
                .whereAnd(
                    condition.userId?.let {
                        path(UserInfo::userId).eq(condition.userId)
                    },
                    condition.userName?.let {
                        path(UserInfo::userName).eq(condition.userName)
                    },
                    condition.password?.let {
                        path(UserInfo::password).eq(condition.password)
                    },
                    condition.userEmail?.let {
                        path(UserInfo::userEmail).eq(condition.userEmail)
                    },
                    condition.userPhone?.let {
                        path(UserInfo::userPhone).eq(condition.userPhone)
                    }
                )
        }
    }
}
