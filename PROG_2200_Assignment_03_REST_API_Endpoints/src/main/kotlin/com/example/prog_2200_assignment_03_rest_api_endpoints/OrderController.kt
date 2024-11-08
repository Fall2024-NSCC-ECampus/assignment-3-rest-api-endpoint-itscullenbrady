package com.example.prog_2200_assignment_03_rest_api_endpoints

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrderController @Autowired constructor(private val orderRepository: OrderRepository) {

    @GetMapping
    fun getAllOrders(): List<Order> {
        return orderRepository.findAll()
    }

    @PostMapping
    fun createOrder(@RequestBody order: Order): Order {
        return orderRepository.save(order)
    }

    @GetMapping("/{id}")
    fun getOrderById(@PathVariable id: Long): ResponseEntity<Order> {
        return orderRepository.findById(id)
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/{id}")
    fun updateOrder(@PathVariable id: Long, @RequestBody orderDetails: Order): ResponseEntity<Order> {
        return orderRepository.findById(id)
            .map { order ->
                val updatedOrder = order.copy(productId = orderDetails.productId, quantity = orderDetails.quantity, totalPrice = orderDetails.totalPrice, status = orderDetails.status)
                ResponseEntity.ok(orderRepository.save(updatedOrder))
            }
            .orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deleteOrder(@PathVariable id: Long): ResponseEntity<Void> {
        return orderRepository.findById(id)
            .map {
                orderRepository.delete(it)
                ResponseEntity<Void>(HttpStatus.NO_CONTENT)
            }
            .orElse(ResponseEntity.notFound().build())
    }
}