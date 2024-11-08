package com.example.prog_2200_assignment_03_rest_api_endpoints


import jakarta.persistence.*

@Entity
data class Payment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var orderId: Long,
    var amount: Double,
    var paymentMethod: String, // e.g., "Credit Card", "PayPal"
    var status: String // e.g., "Paid", "Pending"
)