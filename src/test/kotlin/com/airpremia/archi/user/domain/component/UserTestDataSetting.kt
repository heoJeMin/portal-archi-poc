package com.airpremia.archi.user.domain.component

import com.airpremia.archi.user.domain.entity.UserInfo
import com.airpremia.archi.user.infrastructure.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class UserTestDataSetting {

    @Autowired
    private lateinit var userRepository: UserRepository

    companion object {
        const val USER_ID = "userId"
        const val PASSWORD = "1234"
        const val USER_NAME = "userName"
        const val USER_EMAIL = "email@naver.com"
        const val USER_PHONE = "010-1234-5678"
        const val INVALID_VALUE = "invalid"
        const val OTHER_ID = "uniqueUserId"
        const val OTHER_NAME = "uniqueUserName"
        const val OTHER_EMAIL = "uniqueEmail@naver.com"
        const val OTHER_PHONE = "010-8765-4321"
    }

    fun init() {
        userRepository.save(
            UserInfo(
                USER_ID,
                PASSWORD,
                USER_NAME,
                USER_EMAIL,
                USER_PHONE
            )
        )
    }
}
