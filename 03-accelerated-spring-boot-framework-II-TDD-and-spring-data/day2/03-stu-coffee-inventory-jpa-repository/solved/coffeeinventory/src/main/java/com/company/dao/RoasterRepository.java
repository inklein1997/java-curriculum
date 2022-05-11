package com.company.dao;

import com.company.dto.Roaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoasterRepository extends JpaRepository<Roaster, Integer> {


}
