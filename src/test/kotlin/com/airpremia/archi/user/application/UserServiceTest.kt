package com.airpremia.archi.user.application

import com.airpremia.archi.user.controller.dto.SignInRequest
import com.airpremia.archi.user.controller.dto.SignUpRequest
import com.airpremia.archi.user.domain.component.UserTestDataSetting
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired


class UserServiceTest : UserTestDataSetting() {
    @Autowired
    private lateinit var userService: UserService

    @Test
    @DisplayName("Valid User SignIn Test")
    fun test1() {
        Assertions.assertDoesNotThrow {
            userService.signIn(
                SignInRequest(
                    USER_ID,
                    PASSWORD
                )
            )
        }
    }

    @Test
    @DisplayName("Invalid User SignIn Test")
    fun test2() {
        Assertions.assertThrows(RuntimeException::class.java) {
            userService.signIn(
                SignInRequest(
                    USER_ID,
                    INVALID_VALUE
                )
            )
        }
    }

    @Test
    @DisplayName("Duplicate Email SignUp Test")
    fun test3() {
        Assertions.assertThrows(RuntimeException::class.java) {
            userService.signUp(
                SignUpRequest(
                    OTHER_ID,
                    PASSWORD,
                    USER_NAME,
                    USER_EMAIL,
                    USER_PHONE
                )
            )
        }
    }


    @Test
    @DisplayName("SignUp Success")
    fun test4() {
        userService.signUp(
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
