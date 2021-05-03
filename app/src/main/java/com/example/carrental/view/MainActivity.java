package com.example.carrental.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.carrental.R;
import com.example.carrental.databinding.OutputFragmentBinding;
import com.example.carrental.model.data.Car;
import com.example.carrental.model.db.CarDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity implements InputFragment.CarDelegate {

    private CarDatabase database;
    private InputFragment inputFragment;
    private OutputFragment outputFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFragment = (InputFragment)getSupportFragmentManager().
                findFragmentById(R.id.input_frame);
        outputFragment = (OutputFragment) getSupportFragmentManager().
                findFragmentById(R.id.output_frame);
        readDatabase();
    }

    @Override
    public void insertCar(Car car) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                CarDatabase.getDatabase(MainActivity.this).getCarDAO().insertCar(car);
                readDatabase();
            }
        }.start();


    }

    private void readDatabase() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                List<Car> cars = CarDatabase.getDatabase(MainActivity.this).getCarDAO().getAllCars();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        outputFragment.updateList(cars);
                    }
                });

            }
        }.start();
    }
}