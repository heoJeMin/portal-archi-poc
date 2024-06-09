package com.airpremia.archi.user.repository

import com.airpremia.archi.user.domain.dto.UserInfoSearchCondition
import com.airpremia.archi.user.infrastructure.repository.UserCustomRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class UserCustomRepositoryTest {
    @Autowired
    private lateinit var userCustomRepository: UserCustomRepository

    @Test
    @DisplayName("find by condition")
    fun test1() {
        Assertions.assertDoesNotThrow {
            userCustomRepository.findByCondition(
                UserInfoSearchCondition()
            )
        }
    }
}
