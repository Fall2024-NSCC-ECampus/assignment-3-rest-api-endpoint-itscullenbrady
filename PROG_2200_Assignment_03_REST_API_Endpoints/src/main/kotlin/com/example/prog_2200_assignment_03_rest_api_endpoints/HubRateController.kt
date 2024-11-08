package com.example.prog_2200_assignment_03_rest_api_endpoints

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/hubRates")
class HubRateController @Autowired constructor(private val hubRateRepository: HubRateRepository) {

    @GetMapping
    fun getAllHubRates(): List<HubRate> {
        return hubRateRepository.findAll()
    }

    @PostMapping
    fun createHubRate(@RequestBody hubRate: HubRate): HubRate {
        return hubRateRepository.save(hubRate)
    }

    @GetMapping("/{id}")
    fun getHubRateById(@PathVariable id: Long): ResponseEntity<HubRate> {
        return hubRateRepository.findById(id)
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/{id}")
    fun updateHubRate(@PathVariable id: Long, @RequestBody hubRateDetails: HubRate): ResponseEntity<HubRate> {
        return hubRateRepository.findById(id)
            .map { hubRate ->
                val updatedHubRate = hubRate.copy(rate = hubRateDetails.rate, description = hubRateDetails.description)
                ResponseEntity.ok(hubRateRepository.save(updatedHubRate))
            }
            .orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deleteHubRate(@PathVariable id: Long): ResponseEntity<Void> {
        return hubRateRepository.findById(id)
            .map {
                hubRateRepository.delete(it)
                ResponseEntity<Void>(HttpStatus.NO_CONTENT)
            }
            .orElse(ResponseEntity.notFound().build())
    }
}