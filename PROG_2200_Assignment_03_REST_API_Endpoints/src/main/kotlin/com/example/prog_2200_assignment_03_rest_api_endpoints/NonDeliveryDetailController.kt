package com.example.prog_2200_assignment_03_rest_api_endpoints

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/nonDeliveryDetails")
class NonDeliveryDetailController @Autowired constructor(private val nonDeliveryDetailRepository: NonDeliveryDetailRepository) {

    @GetMapping
    fun getAllNonDeliveryDetails(): List<NonDeliveryDetail> {
        return nonDeliveryDetailRepository.findAll()
    }

    @PostMapping
    fun createNonDeliveryDetail(@RequestBody nonDeliveryDetail: NonDeliveryDetail): NonDeliveryDetail {
        return nonDeliveryDetailRepository.save(nonDeliveryDetail)
    }

    @GetMapping("/{id}")
    fun getNonDeliveryDetailById(@PathVariable id: Long): ResponseEntity<NonDeliveryDetail> {
        return nonDeliveryDetailRepository.findById(id)
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/{id}")
    fun updateNonDeliveryDetail(@PathVariable id: Long, @RequestBody nonDeliveryDetailDetails: NonDeliveryDetail): ResponseEntity<NonDeliveryDetail> {
        return nonDeliveryDetailRepository.findById(id)
            .map { nonDeliveryDetail ->
                val updatedNonDeliveryDetail = nonDeliveryDetail.copy(reason = nonDeliveryDetailDetails.reason, status = nonDeliveryDetailDetails.status)
                ResponseEntity.ok(nonDeliveryDetailRepository.save(updatedNonDeliveryDetail))
            }
            .orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deleteNonDeliveryDetail(@PathVariable id: Long): ResponseEntity<Void> {
        return nonDeliveryDetailRepository.findById(id)
            .map {
                nonDeliveryDetailRepository.delete(it)
                ResponseEntity<Void>(HttpStatus.NO_CONTENT)
            }
            .orElse(ResponseEntity.notFound().build())
    }
}