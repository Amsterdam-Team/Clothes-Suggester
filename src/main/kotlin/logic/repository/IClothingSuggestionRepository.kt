package logic.repository

import logic.entities.ClothingCategory

interface IClothingSuggestionRepository {
    suspend fun getClothingSuggestionsByTemperature(temperature: Float): ClothingCategory
}