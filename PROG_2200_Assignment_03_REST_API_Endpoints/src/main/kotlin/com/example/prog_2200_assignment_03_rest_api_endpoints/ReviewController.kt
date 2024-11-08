package com.example.prog_2200_assignment_03_rest_api_endpoints

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/reviews")
class ReviewController @Autowired constructor(private val reviewRepository: ReviewRepository) {

    @GetMapping
    fun getAllReviews(): List<Review> {
        return reviewRepository.findAll()
    }

    @PostMapping
    fun createReview(@RequestBody review: Review): Review {
        return reviewRepository.save(review)
    }

    @GetMapping("/{id}")
    fun getReviewById(@PathVariable id: Long): ResponseEntity<Review> {
        return reviewRepository.findById(id)
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/{id}")
    fun updateReview(@PathVariable id: Long, @RequestBody reviewDetails: Review): ResponseEntity<Review> {
        return reviewRepository.findById(id)
            .map { review ->
                val updatedReview = review.copy(rating = reviewDetails.rating, comment = reviewDetails.comment)
                ResponseEntity.ok(reviewRepository.save(updatedReview))
            }
            .orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deleteReview(@PathVariable id: Long): ResponseEntity<Void> {
        return reviewRepository.findById(id)
            .map {
                reviewRepository.delete(it)
                ResponseEntity<Void>(HttpStatus.NO_CONTENT)
            }
            .orElse(ResponseEntity.notFound().build())
    }
}