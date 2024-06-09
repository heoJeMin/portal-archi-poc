package com.airpremia.archi.user.domain.component

import com.airpremia.archi.user.controller.dto.SignUpRequest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.DuplicateKeyException

class UserManagerTest : UserTestDataSetting() {

    @Autowired
    private lateinit var userManager: UserManager

    @BeforeEach
    fun setup() {
        this.init()
    }

    @Test
    @DisplayName("Unique: UserId")
    fun test1() {
        Assertions.assertThrows(DuplicateKeyException::class.java) {
            userManager.signUp(
                SignUpRequest(
                    USER_ID,
                    INVALID_VALUE,
                    INVALID_VALUE,
                    INVALID_VALUE,
                    INVALID_VALUE
                )
            )
        }
    }

    @Test
    @DisplayName("Unique: userEmail")
    fun test2() {
        Assertions.assertThrows(DataIntegrityViolationException::class.java) {
            userManager.signUp(
                SignUpRequest(
                    OTHER_ID,
                    PASSWORD,
                    USER_NAME,
                    USER_EMAIL,
                    OTHER_PHONE
                )
            )
        }
    }

    @Test
    @DisplayName("Unique: userPhone")
    fun test3() {
        Assertions.assertThrows(DataIntegrityViolationException::class.java) {
            userManager.signUp(
                SignUpRequest(
                    OTHER_ID,
                    PASSWORD,
                    USER_NAME,
                    OTHER_EMAIL,
                    USER_PHONE
                )
            )
        }
    }

    @Test
    @DisplayName("Save Done: UserId - UserEmail - UserPhone is Unique")
    fun test4() {
        Assertions.assertDoesNotThrow {
            userManager.signUp(
                SignUpRequest(
                    OTHER_ID,
                    PASSWORD,
                    USER_NAME,
                    OTHER_EMAIL,
                    OTHER_PHONE
                )
            )
        }
    }
}
