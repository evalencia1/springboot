package com.dh.demo.service;

import com.dh.demo.domain.Car;
import com.dh.demo.repository.CarRepository;
import com.dh.demo.web.CarController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ElmerVL on 18/06/2017.
 */
@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public void addCar(CarController.CarRequestDTO carDTO) {
        Car car = new Car();
        car.setBrand(carDTO.getBrand());
        car.setColor(carDTO.getColor());
        car.setImage(carDTO.getImage());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getYear());

        carRepository.save(car);
    }

    public void updateCar(Long id, CarController.CarRequestDTO carDTO) {

        Car car = carRepository.findOne(id);
        if (null != carDTO.getBrand()) {car.setBrand(carDTO.getBrand());}
        if (null != carDTO.getColor()) {car.setColor(carDTO.getColor());}
        if (null != carDTO.getImage()) {car.setImage(carDTO.getImage());}
        if (null != carDTO.getModel()) {car.setModel(carDTO.getModel());}
        if (null != carDTO.getYear()) {car.setYear(carDTO.getYear());}

        carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.delete(id);
    }
}
