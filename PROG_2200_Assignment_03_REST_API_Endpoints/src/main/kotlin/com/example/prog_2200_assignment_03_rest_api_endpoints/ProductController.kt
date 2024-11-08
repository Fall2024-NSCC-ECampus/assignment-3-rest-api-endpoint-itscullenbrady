package com.example.prog_2200_assignment_03_rest_api_endpoints

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController @Autowired constructor(private val productRepository: ProductRepository) {

    @GetMapping
    fun getAllProducts(): List<Product> {
        return productRepository.findAll()
    }

    @PostMapping
    fun createProduct(@RequestBody product: Product): Product {
        return productRepository.save(product)
    }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long): ResponseEntity<Product> {
        return productRepository.findById(id)
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Long, @RequestBody productDetails: Product): ResponseEntity<Product> {
        return productRepository.findById(id)
            .map { product ->
                val updatedProduct = product.copy(name = productDetails.name, price = productDetails.price)
                ResponseEntity.ok(productRepository.save(updatedProduct))
            }
            .orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Long): ResponseEntity<Void> {
        return productRepository.findById(id)
            .map {
                productRepository.delete(it)
                ResponseEntity<Void>(HttpStatus.NO_CONTENT)
            }
            .orElse(ResponseEntity.notFound().build())
    }
}