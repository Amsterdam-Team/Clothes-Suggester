package data.local.dataSource

import logic.entities.ClothingCategory
import logic.entities.ClothingCategoryName


class ClothesDataSourceImp: IClothesDataSource {

    override fun getClothingByTemperature(temperature: Float): ClothingCategory {
        return getClothingCategories().first { category -> temperature.toInt() in category.temperatureRange }
    }

    private fun getClothingCategories(): List<ClothingCategory> {
        return listOf(
            ClothingCategory(
                name = ClothingCategoryName.FREEZING,
                temperatureRange = Int.MIN_VALUE..0,
                suggestion = listOf(
                    "Heavy coat",
                    "Thermal layers",
                    "Gloves",
                    "Scarf",
                    "Wool hat",
                    "Insulated boots"
                )
            ),
            ClothingCategory(
                name = ClothingCategoryName.COLD,
                temperatureRange = 1..10,
                suggestion = listOf(
                    "Warm coat",
                    "Sweater",
                    "Jeans or warm pants",
                    "Gloves",
                    "Beanie"
                )
            ),
            ClothingCategory(
                name = ClothingCategoryName.COOL,
                temperatureRange = 11..20,
                suggestion = listOf(
                    "Light jacket",
                    "Hoodie",
                    "Jeans or trousers",
                    "Long-sleeve shirt"
                )
            ),
            ClothingCategory(
                name = ClothingCategoryName.MILD,
                temperatureRange = 21..25,
                suggestion = listOf(
                    "T-shirt",
                    "Jeans or chinos",
                    "Light sweater or jacket (optional)"
                )
            ),
            ClothingCategory(
                name = ClothingCategoryName.WARM,
                temperatureRange = 26..30,
                suggestion = listOf(
                    "Short-sleeve shirt",
                    "Shorts or light pants",
                    "Breathable fabrics"
                )
            ),
            ClothingCategory(
                name = ClothingCategoryName.HOT,
                temperatureRange = 31..Int.MAX_VALUE,
                suggestion = listOf(
                    "Tank top",
                    "Shorts",
                    "Sunglasses",
                    "Hat or cap",
                    "Stay hydrated"
                )
            )
        )
    }
}