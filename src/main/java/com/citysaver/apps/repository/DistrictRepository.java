package com.citysaver.apps.repository;

import com.citysaver.apps.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {
    District save(District district);
}
