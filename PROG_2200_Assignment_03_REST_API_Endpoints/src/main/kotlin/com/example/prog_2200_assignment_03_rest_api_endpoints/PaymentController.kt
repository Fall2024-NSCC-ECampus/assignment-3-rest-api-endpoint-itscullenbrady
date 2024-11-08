package com.example.prog_2200_assignment_03_rest_api_endpoints

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/payments")
class PaymentController @Autowired constructor(private val paymentRepository: PaymentRepository) {

    @GetMapping
    fun getAllPayments(): List<Payment> {
        return paymentRepository.findAll()
    }

    @PostMapping
    fun createPayment(@RequestBody payment: Payment): Payment {
        return paymentRepository.save(payment)
    }

    @GetMapping("/{id}")
    fun getPaymentById(@PathVariable id: Long): ResponseEntity<Payment> {
        return paymentRepository.findById(id)
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/{id}")
    fun updatePayment(@PathVariable id: Long, @RequestBody paymentDetails: Payment): ResponseEntity<Payment> {
        return paymentRepository.findById(id)
            .map { payment ->
                val updatedPayment = payment.copy(amount = paymentDetails.amount, paymentMethod = paymentDetails.paymentMethod, status = paymentDetails.status)
                ResponseEntity.ok(paymentRepository.save(updatedPayment))
            }
            .orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deleteOrder(@PathVariable id: Long): ResponseEntity<Void> {
        return paymentRepository.findById(id)
            .map {
                paymentRepository.delete(it)
                ResponseEntity<Void>(HttpStatus.NO_CONTENT)
            }
            .orElse(ResponseEntity.notFound().build())
    }
}