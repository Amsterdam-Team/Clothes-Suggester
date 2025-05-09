package logic.entities

data class ClothingCategory(
    val name: ClothingCategoryName,
    val temperatureRange: IntRange,
    val suggestion: List<String>
)
enum class ClothingCategoryName {
    FREEZING,
    COLD,
    COOL,
    MILD,
    WARM,
    HOT
}