package com.example.carrental.model.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.carrental.model.data.Car;

import java.util.List;

@Dao
public interface CarDAO {

    @Query("SELECT * FROM cars")
    public List<Car> getAllCars();

    @Insert
    void insertCar(Car... car);

    @Delete
    void deleteCar(Car car);

    @Query("SELECT * FROM cars WHERE id=:id")
    List<Car> getOneCar(int id);

    @Query("UPDATE cars SET available = :update WHERE id = :id")
    void updateAvailability(int id,int update);

}
