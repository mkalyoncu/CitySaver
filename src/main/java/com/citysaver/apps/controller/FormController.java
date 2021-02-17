package com.citysaver.apps.controller;

import com.citysaver.apps.data.DataConverter;
import com.citysaver.apps.data.DataValidator;
import com.citysaver.apps.data.RetrievedData;
import com.citysaver.apps.entity.City;
import com.citysaver.apps.entity.District;
import com.citysaver.apps.service.CityService;
import com.citysaver.apps.service.DistrictService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
    private final DistrictService districtService;
    private final CityService cityService;

    private final String formSubmitSuccessMessage;
    private final String formSubmitErrorMessage;

    @Autowired
    public FormController(DistrictService districtService,
                          CityService cityService,
                          @Value("${form.submit.success}") String formSubmitSuccessMessage,
                          @Value("${form.submit.error}") String formSubmitErrorMessage) {
        this.districtService = districtService;
        this.cityService = cityService;
        this.formSubmitSuccessMessage = formSubmitSuccessMessage;
        this.formSubmitErrorMessage = formSubmitErrorMessage;
    }


    @GetMapping(value = {"/form"})
    public String submit(Model model) {
        model.addAttribute("retrievedData", new RetrievedData());

        return "form";
    }

    @PostMapping(value = {"/form"})
    public ModelAndView submit(@ModelAttribute("retrievedData") RetrievedData retrievedData,
                               ModelMap model) {
        if (DataValidator.isRetrievedDataValid(retrievedData)) {
            City city = DataConverter.convertToCity(retrievedData);
            District district = DataConverter.convertToDistrict(retrievedData);

            City savedCity = cityService.save(city);
            district.setCityId(savedCity.getId());
            districtService.save(district);

            model.addAttribute("message", formSubmitSuccessMessage);

        } else {
            model.addAttribute("message", formSubmitErrorMessage);
        }

        return new ModelAndView("form", model);
    }
}
