package com.citysaver.apps.controller;

import com.citysaver.apps.service.CityService;
import com.citysaver.apps.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListDataController {
    private final DistrictService districtService;
    private final CityService cityService;

    @Autowired
    public ListDataController(DistrictService districtService, CityService cityService) {
        this.districtService = districtService;
        this.cityService = cityService;
    }

    @GetMapping(value = "/list")
    public String listData(Model model) {
        model.addAttribute("cities", cityService.findAll());
        model.addAttribute("districts", districtService.findAll());

        return "list";
    }
}
