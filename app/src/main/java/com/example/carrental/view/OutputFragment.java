package com.example.carrental.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.SnapHelper;

import com.example.carrental.databinding.OutputFragmentBinding;
import com.example.carrental.model.data.Car;

import java.util.LinkedList;
import java.util.List;

public class OutputFragment extends Fragment {


    private OutputFragmentBinding binding;
    private CarAdapter carAdapter = new CarAdapter(new LinkedList<Car>());

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = OutputFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.carRecycleView.setAdapter(carAdapter);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(binding.carRecycleView);
    }

    public void updateList(List<Car> cars){
        carAdapter.setCars(cars);
    }

}
