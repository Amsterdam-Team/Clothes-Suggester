package data.local.dataSource

import logic.entities.ClothingCategory

interface IClothesDataSource {
    fun getClothingByTemperature(temperature: Float): ClothingCategory
}