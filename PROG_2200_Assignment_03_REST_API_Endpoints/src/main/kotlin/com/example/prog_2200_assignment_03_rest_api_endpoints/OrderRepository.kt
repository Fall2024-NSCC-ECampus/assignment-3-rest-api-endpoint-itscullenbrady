package com.example.prog_2200_assignment_03_rest_api_endpoints

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, Long> {
    // Additional query methods can be defined here if needed
}