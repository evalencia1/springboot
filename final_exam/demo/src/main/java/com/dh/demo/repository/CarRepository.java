package com.dh.demo.repository;

import com.dh.demo.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ElmerVL on 18/06/2017.
 */
public interface CarRepository extends JpaRepository<Car, Long> {
}
