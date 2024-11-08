package com.example.prog_2200_assignment_03_rest_api_endpoints


import jakarta.persistence.*

@Entity
data class HubRate(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val description: String,
    var rate: Double
)