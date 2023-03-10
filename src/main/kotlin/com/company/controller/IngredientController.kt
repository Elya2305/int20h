package com.company.controller

import com.company.domain.IngredientDto
import com.company.service.IngredientService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.logging.Logger

@RestController
@RequestMapping("/ingredients")
class IngredientController(private val ingredientService: IngredientService) {
    private val log = Logger.getLogger(this.javaClass.name)

    @PostMapping
    fun save(@RequestBody ingredient: IngredientDto): IngredientDto {
        log.info("Request on saving ingredient: $ingredient")
        return ingredientService.save(ingredient)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) {
        log.info("Request on deleting ingredient: $id")
        ingredientService.delete(id)
    }

    @GetMapping
    fun all(): List<IngredientDto> {
        log.info("Request on getting all ingredients")
        return ingredientService.all()
    }
}
