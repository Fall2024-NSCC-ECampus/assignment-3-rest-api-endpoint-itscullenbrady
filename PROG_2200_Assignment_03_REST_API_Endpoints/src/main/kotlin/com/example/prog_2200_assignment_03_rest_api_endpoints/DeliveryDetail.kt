package com.example.prog_2200_assignment_03_rest_api_endpoints


import jakarta.persistence.*

@Entity
data class DeliveryDetail(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var orderId: Long,
    var deliveryAddress: String,
    var deliveryDate: String, // You might want to use LocalDate
    var status: String // e.g., "Delivered", "In Transit"
)