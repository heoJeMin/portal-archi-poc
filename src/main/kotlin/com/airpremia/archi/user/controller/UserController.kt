package com.airpremia.archi.user.controller

import com.airpremia.archi.user.application.UserService
import com.airpremia.archi.user.controller.dto.SignInRequest
import com.airpremia.archi.user.controller.dto.SignInResponse
import com.airpremia.archi.user.controller.dto.SignUpRequest
import com.airpremia.archi.user.controller.dto.SignUpResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {
    @PostMapping("/sign-in")
    fun signIn(@RequestBody signInRequest: SignInRequest): ResponseEntity<SignInResponse> {
        return ResponseEntity.ok(userService.signIn(signInRequest))
    }

    @PostMapping("/sign-up")
    fun signUp(@RequestBody signUpRequest: SignUpRequest): ResponseEntity<SignUpResponse> {
        signUpRequest.validate()
        return ResponseEntity.ok(userService.signUp(signUpRequest))
    }
}
