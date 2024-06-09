package com.airpremia.archi.user.domain.entity

import jakarta.persistence.*
import org.springframework.data.domain.Persistable

@Entity
@Table(
    name = "user_info", uniqueConstraints = [
        UniqueConstraint(columnNames = ["user_email"]),
        UniqueConstraint(columnNames = ["user_phone"])
    ]
)
data class UserInfo(
    @Id
    @Column(name = "user_id")
    val userId: String,
    @Column(name = "password")
    val password: String,
    @Column(name = "user_name")
    val userName: String,
    @Column(name = "user_email", unique = true)
    val userEmail: String,
    @Column(name = "user_phone", unique = true)
    val userPhone: String,
) : Persistable<String> {
    override fun getId(): String? {
        return this.userId
    }

    override fun isNew(): Boolean {
        return true
    }
}
