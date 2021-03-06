package com.dsliunkova.kanbanforworkers.repositories;

import com.dsliunkova.kanbanforworkers.entities.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
    public List<Car> findAllByOwnerId(int id);
}
