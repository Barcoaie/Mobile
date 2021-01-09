package ubb.barcoaie.lab5_ma.service

import android.content.Context
import ubb.barcoaie.lab5_ma.repository.VegetableRepo

class VegetableService {
    private var vegetableRepo: VegetableRepo? = null
    private var hasConnection: Boolean = false

    private var context: Context? = null
}