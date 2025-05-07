package data.repository

import logic.entities.ClothingCategory
import data.local.dataSource.IClothesDataSource
import logic.repository.IClothingSuggestionRepository

class ClothingSuggestionRepositoryImp(
    private val clothesDataSource: IClothesDataSource,
    ): IClothingSuggestionRepository {

    override suspend fun getClothingSuggestionsByTemperature(temperature: Float): ClothingCategory {
        return clothesDataSource.getClothingByTemperature(temperature)
    }
}