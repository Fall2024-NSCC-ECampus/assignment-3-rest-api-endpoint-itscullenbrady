package com.example.prog_2200_assignment_03_rest_api_endpoints

import jakarta.persistence.*

@Entity
data class Company(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var name: String,
    var address: String,
    var contactNumber: String
)