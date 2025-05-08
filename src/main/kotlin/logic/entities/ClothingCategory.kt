package logic.entities

data class ClothingCategory(
    val name: ClothingCategoryName,
    val temperatureRange: IntRange,
    val suggestion: List<String>
)