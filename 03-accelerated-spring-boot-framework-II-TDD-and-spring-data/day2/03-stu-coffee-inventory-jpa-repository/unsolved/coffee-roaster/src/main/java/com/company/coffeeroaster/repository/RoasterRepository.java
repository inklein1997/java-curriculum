package com.company.coffeeroaster.repository;

import com.company.coffeeroaster.dto.Roaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoasterRepository extends JpaRepository<Roaster, Integer> {
}
