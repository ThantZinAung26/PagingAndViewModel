package com.soft.paggingsampledemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.paging.Config
import androidx.paging.toLiveData


class CarViewModel(app: Application) : AndroidViewModel(app) {

    val dao = CarDB.getInstance(app).carDAO()

    val carAll = dao.findByName().toLiveData(
        Config(
            pageSize = 30,
            enablePlaceholders = true,
            maxSize = 200
        )
    )

    fun insert(text: CharSequence) = ioThread {
        dao.insert(Car(0, name = text.toString()))
    }

    fun remove(car: Car) = ioThread {
        dao.delete(car)
    }
}