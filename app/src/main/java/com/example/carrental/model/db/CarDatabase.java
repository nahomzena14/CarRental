package com.example.carrental.model.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.carrental.model.data.Car;

@Database(version = 1,entities = {Car.class})
public abstract class CarDatabase extends RoomDatabase {

    private static CarDatabase carDatabase;
    public abstract CarDAO getCarDAO();

    public static CarDatabase getDatabase(Context context){
        if(carDatabase == null){
            carDatabase = Room.databaseBuilder(context,
                    CarDatabase.class,
                    "cars.db").
                    build();
        }
        return carDatabase;
    }

}
