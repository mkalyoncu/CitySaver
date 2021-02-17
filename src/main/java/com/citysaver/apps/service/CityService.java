package com.citysaver.apps.service;

import com.citysaver.apps.entity.City;
import com.citysaver.apps.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City save(City city) {
        return cityRepository.save(city);
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
