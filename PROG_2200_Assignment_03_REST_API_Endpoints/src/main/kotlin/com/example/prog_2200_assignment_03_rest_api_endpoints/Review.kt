package com.example.prog_2200_assignment_03_rest_api_endpoints

import jakarta.persistence.*

@Entity
data class Review(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var productId: Long,
    var rating: Int, // e.g., 1-5 scale
    var comment: String
)