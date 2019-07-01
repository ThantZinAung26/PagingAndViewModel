package com.soft.paggingsampledemo

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CarDAO {

    @Insert
    fun insert(car: Car)

    @Insert
    fun inserts(cars: List<Car>)

    @Query("SELECT * FROM carAll ORDER BY name COLLATE NOCASE ASC")
    fun findByName(): DataSource.Factory<Int, Car>

    @Delete
    fun delete(car: Car)

}