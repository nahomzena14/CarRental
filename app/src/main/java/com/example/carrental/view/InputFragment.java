package com.example.carrental.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.carrental.databinding.InputFragmentBinding;
import com.example.carrental.model.data.Car;

public class InputFragment extends Fragment {

    private InputFragmentBinding binding;
    interface CarDelegate{
        void insertCar(Car car);
    }
    private CarDelegate carDelegate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = InputFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.addButton.setOnClickListener(v ->{
            String carName = binding.carEditText.getText().toString().trim();
            double price = Double.parseDouble(binding.priceEditText.getText().toString().trim());
            String licenseTag = binding.licenseEditText.getText().toString().trim();

            Car car = new Car(carName,price,licenseTag,1);
            carDelegate.insertCar(car);
            binding.carEditText.setText("");
            binding.licenseEditText.setText("");
            binding.priceEditText.setText("");
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        carDelegate = (CarDelegate) context;
    }
}
