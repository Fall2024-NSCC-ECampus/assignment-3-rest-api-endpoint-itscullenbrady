package com.example.prog_2200_assignment_03_rest_api_endpoints

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/deliveryDetails")
class DeliveryDetailController @Autowired constructor(private val deliveryDetailRepository: DeliveryDetailRepository) {

    @GetMapping
    fun getAllDeliveryDetails(): List<DeliveryDetail> {
        return deliveryDetailRepository.findAll()
    }

    @PostMapping
    fun createDeliveryDetail(@RequestBody deliveryDetail: DeliveryDetail): DeliveryDetail {
        return deliveryDetailRepository.save(deliveryDetail)
    }

    @GetMapping("/{id}")
    fun getDeliveryDetailById(@PathVariable id: Long): ResponseEntity<DeliveryDetail> {
        return deliveryDetailRepository.findById(id)
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/{id}")
    fun updateDeliveryDetail(@PathVariable id: Long, @RequestBody deliveryDetailDetails: DeliveryDetail): ResponseEntity<DeliveryDetail> {
        return deliveryDetailRepository.findById(id)
            .map { deliveryDetail ->
                val updatedDeliveryDetail = deliveryDetail.copy(status = deliveryDetailDetails.status, deliveryDate = deliveryDetailDetails.deliveryDate)
                ResponseEntity.ok(deliveryDetailRepository.save(updatedDeliveryDetail))
            }
            .orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deleteDeliveryDetail(@PathVariable id: Long): ResponseEntity<Void> {
        return deliveryDetailRepository.findById(id)
            .map {
                deliveryDetailRepository.delete(it)
                ResponseEntity<Void>(HttpStatus.NO_CONTENT)
            }
            .orElse(ResponseEntity.notFound().build())
    }
}