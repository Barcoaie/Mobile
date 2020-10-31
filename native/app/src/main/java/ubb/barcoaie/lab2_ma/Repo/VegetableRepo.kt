package ubb.barcoaie.lab2_ma.Repo

import ubb.barcoaie.lab2_ma.Domain.Vegetable

class VegetableRepo {
    private val vegetables : MutableList<Vegetable> = mutableListOf<Vegetable>()

    @JvmName("getVegetables1")
    fun getVegetables(): List<Vegetable> {
        return vegetables
    }

    fun addVegetable(vegetable: Vegetable): Boolean  {
        this.vegetables.add(vegetable)
        return true
    }

    fun delVegetable(index: Int): Boolean {
        this.vegetables.removeAt(index)
        return true
    }

    fun updateVegetable(index: Int, vegetable: Vegetable): Boolean {
        this.vegetables.removeAt(index)
        this.vegetables.add(index, vegetable)
        return true
    }
}