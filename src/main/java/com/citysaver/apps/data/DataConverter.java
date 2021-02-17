package com.citysaver.apps.data;

import com.citysaver.apps.entity.City;
import com.citysaver.apps.entity.District;

public class DataConverter {

    public static City convertToCity(RetrievedData retrievedData) {
        City city = new City();
        city.setName(retrievedData.getCity());

        return city;
    }

    public static District convertToDistrict(RetrievedData retrievedData) {
        District district = new District();
        district.setName(retrievedData.getDistrict());

        return district;
    }
}
