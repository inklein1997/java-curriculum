package com.company.coffeeroaster.repository;

import com.company.coffeeroaster.dto.Coffee;
import com.company.coffeeroaster.dto.Roaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
    List<Coffee> findByType(String type);
    List<Coffee> findByRoasterId(Integer roasterId);
    List<Coffee> findByTypeAndRoasterId(String type, Integer roasterId);
}
