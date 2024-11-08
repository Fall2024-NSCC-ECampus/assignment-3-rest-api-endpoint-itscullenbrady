package com.example.prog_2200_assignment_03_rest_api_endpoints


import jakarta.persistence.*

@Entity
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var productId: Long,
    var quantity: Int,
    var totalPrice: Double,
    var status: String // e.g., "Pending", "Completed", "Cancelled"
)