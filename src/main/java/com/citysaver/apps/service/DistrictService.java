package com.citysaver.apps.service;

import com.citysaver.apps.entity.District;
import com.citysaver.apps.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {
    private final DistrictRepository districtRepository;

    @Autowired
    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public District save(District district) {
        return districtRepository.save(district);
    }

    public List<District> findAll() {
        return districtRepository.findAll();
    }
}
