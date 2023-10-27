package com.example.busschedule.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDao {

    @Query("SELECT * FROM Schedule ORDER BY arrival_time_in_millis ASC")
    fun getAllBusSchedules(): Flow<List<BusSchedule>>

    @Transaction
    @Query("SELECT * FROM Schedule WHERE stop_name = :stopName")
    fun getBusScheduleByStopName(stopName: String): Flow<List<BusSchedule>>
}