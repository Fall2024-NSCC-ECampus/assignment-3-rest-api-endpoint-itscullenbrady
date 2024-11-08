package com.example.prog_2200_assignment_03_rest_api_endpoints


import jakarta.persistence.*

@Entity
data class NonDeliveryDetail(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var orderId: Long,
    var reason: String, // e.g., "Out of Stock", "Address Issue"
    var status: String // e.g., "Pending", "Resolved"
)