package ubb.barcoaie.lab2_ma.Domain

data class Vegetable (
    val name: String, override val id: Long
) : BaseEntity