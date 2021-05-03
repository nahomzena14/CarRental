package com.example.carrental.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carrental.databinding.CarListLayoutBinding;
import com.example.carrental.model.data.Car;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    List<Car> cars;

    public CarAdapter(List<Car> cars) {
        this.cars = cars;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CarListLayoutBinding binding = CarListLayoutBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );

        return new CarViewHolder(binding);
    }

    public void setCars(List<Car> cars){
        this.cars = cars;
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = cars.get(position);
        holder.binding.nameTextView.setText("Name:"+car.getName());
        holder.binding.idTextView.setText("ID:"+car.getId());
        holder.binding.priceTextView.setText("Price:"+car.getPrice()+"/day");
        holder.binding.tagTextView.setText("Tag:"+car.getLicenseTag());
        holder.binding.availableTextView.setText("Available = "+car.isAvailable());
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    class CarViewHolder extends RecyclerView.ViewHolder{
        CarListLayoutBinding binding;
        public CarViewHolder(CarListLayoutBinding b){
            super(b.getRoot());
            this.binding = b;
        }
    }
}


