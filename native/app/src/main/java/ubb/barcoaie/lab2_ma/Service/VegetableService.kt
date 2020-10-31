package ubb.barcoaie.lab2_ma.Service

import ubb.barcoaie.lab2_ma.Domain.Vegetable
import ubb.barcoaie.lab2_ma.Repo.VegetableRepo

class VegetableService(val repo: VegetableRepo) {
    fun add(vegetable: Vegetable) {
        repo.addVegetable(vegetable)
    }

    fun del(index: Int) {
        repo.delVegetable(index)
    }

    fun update(index: Int, vegetable: Vegetable) {
        repo.updateVegetable(index, vegetable)
    }

    override fun toString(): String {
        return repo.getVegetables().toString()
    }
}