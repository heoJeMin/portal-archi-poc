package com.airpremia.archi.user.domain.component

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class UserFinderTest : UserTestDataSetting() {

    @Autowired
    private lateinit var userFinder: UserFinder

    @BeforeEach
    fun setup() {
        this.init()
    }

    @Test
    @DisplayName("존재하는 UserId - Password 조회 시 Not Null")
    fun test1() {
        Assertions.assertNotNull(userFinder.findByUserIdAndPassword(USER_ID, PASSWORD))
    }

    @Test
    @DisplayName("존재하지 않는 UserId, Password 조회 시 Null")
    fun test2() {
        Assertions.assertNull(userFinder.findByUserIdAndPassword(INVALID_VALUE, INVALID_VALUE))

        Assertions.assertNull(userFinder.findByUserIdAndPassword(USER_ID, INVALID_VALUE))

        Assertions.assertNull(userFinder.findByUserIdAndPassword(INVALID_VALUE, PASSWORD))
    }

    @Test
    @DisplayName("존재하는 UserId 조회 시 Not Null")
    fun test3() {
        Assertions.assertNotNull(userFinder.findByUserId(USER_ID))
    }

    @Test
    @DisplayName("존재하지 않는 UserId 조회 시 Null")
    fun test4() {
        Assertions.assertNull(userFinder.findByUserId(INVALID_VALUE))
    }

    @Test
    @DisplayName("존재하는 Email 조회 시 Not Null")
    fun test5() {
        Assertions.assertNotNull(userFinder.findByUserEmail(USER_EMAIL))
    }

    @Test
    @DisplayName("존재하지 않는 Email 조회 시 Null")
    fun test6() {
        Assertions.assertNull(userFinder.findByUserEmail(INVALID_VALUE))
    }

    @Test
    @DisplayName("존재하는 Phone 조회 시 Not Null")
    fun test7() {
        Assertions.assertNotNull(userFinder.findByUserPhone(USER_PHONE))
    }

    @Test
    @DisplayName("존재하지 않는 Phone 조회 시 Null")
    fun test8() {
        Assertions.assertNull(userFinder.findByUserPhone(INVALID_VALUE))
    }
}
